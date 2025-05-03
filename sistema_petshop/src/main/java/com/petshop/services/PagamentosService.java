package com.petshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Pagamentos;
import com.petshop.repository.PagamentosRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PagamentosService {

    @Autowired
    private PagamentosRepository pagamentosRepository;

    public List<Pagamentos> buscarTodosOsPagamentos() {
        return pagamentosRepository.findAll();
    }

    public void salvarPagamento(Pagamentos pagamentos) {
        pagamentosRepository.save(pagamentos);
    }

    public Pagamentos buscarPorId(Long id) {
        return pagamentosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pagamento não encontrado com ID: " + id));
    }

    public void excluirPagamentoPorId(Long id) {
        pagamentosRepository.deleteById(id);
    }

    public Pagamentos atualizarPagamento(Pagamentos pagamentos) {
        if (pagamentos.getId() != null) {
            return pagamentosRepository.save(pagamentos);
        }
        return null;
    }

}