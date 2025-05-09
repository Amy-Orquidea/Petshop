package com.petshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Raca;
import com.petshop.repository.RacaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RacaService {

    @Autowired
    private RacaRepository racaRepository;

    public List<Raca> buscarTodasAsRacas() {
        return racaRepository.findAll();
    }

    public void salvarRaca(Raca raca) {
        racaRepository.save(raca);
    }

    public Raca buscarPorId(Integer id) {
        return racaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Raça não encontrado com ID: " + id));
    }

    public void excluirRacaPorId(Integer id) {
        racaRepository.deleteById(id);
    }

    public Raca atualizarRaca(Raca raca) {
        if (raca.getId() != null) {
            return racaRepository.save(raca);
        }
        return null;
    }

}