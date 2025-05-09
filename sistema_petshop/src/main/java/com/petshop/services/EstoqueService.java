package com.petshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Estoque;
import com.petshop.repository.EstoqueRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public List<Estoque> buscarTudoNoEstoque() {
        return estoqueRepository.findAll();
    }

    public void salvarEstoque(Estoque estoque) {
        estoqueRepository.save(estoque);
    }

    public Estoque buscarPorId(Integer id) {
        return estoqueRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estoque não encontrado com ID: " + id));
    }

    public void excluirEstoquePorId(Integer id) {
        estoqueRepository.deleteById(id);
    }

    public Estoque atualizarEstoque(Estoque estoque) {
        if (estoque.getId() != null) {
            return estoqueRepository.save(estoque);
        }
        return null;
    }
}
