package com.petshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Especie;
import com.petshop.repository.EspecieRepository;

@Service
public class EspecieService {

    @Autowired
    private EspecieRepository especieRepository;

    
    public List<Especie> buscarTodasAsEspecies() {
        return especieRepository.findAll();
    }

   
    public void salvarEspecie(Especie especie) {
        especieRepository.save(especie); 
    }

 
    public Optional<Especie> buscarPorId(Long id) {
        return especieRepository.findById(id);
    }

  
    public void excluirEspeciePorId(Long id) {
        especieRepository.deleteById(id);
    }

   
    public Especie atualizarEspecie(Especie especie) {
        if (especie.getId() != null) {
            return especieRepository.save(especie);  
        }
        return null;
    }


}