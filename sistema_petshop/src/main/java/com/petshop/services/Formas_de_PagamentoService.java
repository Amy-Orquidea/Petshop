package com.petshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Formas_de_Pagamento;
import com.petshop.repository.Formas_de_PagamentoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class Formas_de_PagamentoService {

    @Autowired
    private Formas_de_PagamentoRepository formas_de_PagamentoRepository;

    public List<Formas_de_Pagamento> buscarTodasAsFormas() {
        return formas_de_PagamentoRepository.findAll();
    }

    public void salvarForma(Formas_de_Pagamento formas_de_Pagamento) {
        formas_de_PagamentoRepository.save(formas_de_Pagamento);
    }

    public Formas_de_Pagamento buscarPorId(Integer id) {
        return formas_de_PagamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Forma de Pagamento não encontrado com ID: " + id));
    }

    public void excluirFormaPorId(Integer id) {
        formas_de_PagamentoRepository.deleteById(id);
    }

    public Formas_de_Pagamento atualizarForma(Formas_de_Pagamento formas_de_Pagamento) {
        if (formas_de_Pagamento.getId() != null) {
            return formas_de_PagamentoRepository.save(formas_de_Pagamento);
        }
        return null;
    }

}