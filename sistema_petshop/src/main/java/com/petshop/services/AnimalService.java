package com.petshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Animal;
import com.petshop.repository.AnimalRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    // Listar todos os animais
    public List<Animal> buscarTodosOsAnimais() {
        return animalRepository.findAll();
    }

    public void salvarAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    // Buscar um animal por ID
    public Animal buscarPorId(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vendedor não encontrado com ID: " + id));
    }

    // Deletar um animal
    public void excluirAnimalPorId(Long id) {
        animalRepository.deleteById(id);
    }

    // Editar animal (atualizar suas informações)
    public Animal atualizarAnimal(Animal animal) {
        if (animal.getId() != null) {
            return animalRepository.save(animal); // aqui chamamos o método save acima
        }
        return null;
    }

}