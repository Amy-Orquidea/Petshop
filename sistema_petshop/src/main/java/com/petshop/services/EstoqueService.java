package com.petshop.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Estoque;
import com.petshop.model.Produto;
import com.petshop.repository.EstoqueRepository;
import com.petshop.repository.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EstoqueService {
    
    @Autowired
    private final EstoqueRepository estoqueRepository;

    private ProdutoService produtoService;

    public EstoqueService(EstoqueRepository estoqueRepository, ProdutoRepository produtoRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public List<Estoque> buscarEstoqueDeProdutos() {
        return estoqueRepository.findAll();
    }

    public void registrarEntrada(Estoque estoque, Integer produtoId) {
        Produto produtoOpt = produtoService.buscarPorId(produtoId);

        if (estoque.getDataEntrada() == null) {
            estoque.setDataEntrada(LocalDateTime.now());
        }
    }

    public void excluir(Integer id) {
        estoqueRepository.deleteById(id);
    }

    public List<Estoque> listarPorProduto(Integer produtoId) {
        Optional<Produto> produtoOpt = produtoRepository.findById(produtoId);
        if (produtoOpt.isPresent()) {
            return estoqueRepository.findByProdutoIdOrderByDataEntradaDesc(produtoId);
        }
        return List.of();
    }

    public Integer getTotalQuantidadePorProduto(Integer produtoId) {
        Integer total = estoqueRepository.getTotalQuantidadeByProdutoId(produtoId);
        return total != null ? total : 0;
    }
}
