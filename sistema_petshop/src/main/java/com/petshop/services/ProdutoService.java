package com.petshop.services;

import com.petshop.model.Categoria;
import com.petshop.model.Produto;
import com.petshop.repository.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaService categoriaService; // Para buscar categoria

    @Value("${file.upload-dir:src/main/resources/static/}")
    private String uploadDir;

    // Usar @Lazy para quebrar dependência circular se CategoriaService também
    // depender de ProdutoService
    public ProdutoService(ProdutoRepository produtoRepository, @Lazy CategoriaService categoriaService) {
        this.produtoRepository = produtoRepository;
        this.categoriaService = categoriaService;
    }

    public List<Produto> buscarTodosOsProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Integer id) { // Usar Integer
        return produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));
    }

    public Produto salvarProduto(Produto produto) {
        // Validar e anexar Categoria
        if (produto.getCategoria() == null || produto.getCategoria().getId() == null) {
            throw new IllegalArgumentException("Categoria é obrigatória para o produto.");
        }
        Categoria categoria = categoriaService.buscarPorIdOuFalhar(produto.getCategoria().getId());
        produto.setCategoria(categoria);

        if (produto.getPreco() == null || produto.getPreco() < 0) {
            throw new IllegalArgumentException("Preço do produto não pode ser negativo.");
        }

        // Lógica de atualização vs criação
        if (produto.getId() != null) {
            Produto existente = buscarPorId(produto.getId());
            existente.setNome(produto.getNome());
            existente.setPreco(produto.getPreco());
            existente.setCategoria(produto.getCategoria()); // Atualiza categoria
            if (produto.getFotoPath() != null && !produto.getFotoPath().isBlank()) {
                existente.setFotoPath(produto.getFotoPath());
            }
            return produtoRepository.save(existente);
        } else {
            return produtoRepository.save(produto);
        }
    }

    public void excluirProdutoPorId(Integer id) {
        // Verifica se o produto existe
        Produto prod = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));

        // Exclui o arquivo associado, se existir
        String fotoPath = prod.getFotoPath();
        if (fotoPath != null && !fotoPath.isBlank()) {
            try {
                Path diretorioPath = Paths.get(uploadDir);
                Path caminhoArquivo = diretorioPath.resolve(fotoPath).normalize(); // Normaliza para evitar path
                                                                                   // traversal

                // Verifica se o arquivo existe antes de tentar deletar
                if (Files.exists(caminhoArquivo)) {
                    Files.delete(caminhoArquivo);
                }
            } catch (IOException e) {
                throw new RuntimeException("Erro ao deletar o arquivo associado ao produto com ID: " + id, e);
            }
        }

        // Exclui o produto do banco de dados
        produtoRepository.deleteById(id);
    }

}