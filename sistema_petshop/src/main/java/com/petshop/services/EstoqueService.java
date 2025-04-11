package com.petshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Estoque;
import com.petshop.repository.EstoqueRepository;

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

 
    public Optional<Estoque> buscarPorId(Long id) {
        return estoqueRepository.findById(id);
    }

  
    public void excluirEstoquePorId(Long id) {
        estoqueRepository.deleteById(id);
    }

   
    public Estoque atualizarEstoque(Estoque estoque) {
        if (estoque.getId() != null) {
            return estoqueRepository.save(estoque);  
        }
        return null;
    }
}
