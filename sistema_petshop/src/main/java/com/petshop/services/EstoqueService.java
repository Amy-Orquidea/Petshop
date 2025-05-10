package com.petshop.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.petshop.model.Estoque;
import com.petshop.model.Produto;
import com.petshop.repository.EstoqueRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;

    private final ProdutoService produtoService;

    public EstoqueService(EstoqueRepository estoqueRepository, @Lazy ProdutoService produtoService) {
        this.estoqueRepository = estoqueRepository;
        this.produtoService = produtoService;
        
    }

    public Estoque buscarProdutoPorId(Integer id) {
        return estoqueRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Estoque não encontrado com ID: " + id));
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
        return estoqueRepository.findByProdutoIdOrderByDataEntradaDesc(produtoId);
    }

    public Integer getTotalQuantidadePorProduto(Integer produtoId) {
        Integer total = estoqueRepository.getTotalQuantidadeByProdutoId(produtoId);
        return total != null ? total : 0;
    }

    public void salvar(Estoque estoque) {  
        estoqueRepository.save(estoque);
    }



}