package com.petshop.services;

import com.petshop.model.Animal;
import com.petshop.model.Categoria;
import com.petshop.model.Cliente;
import com.petshop.model.Produto;
import com.petshop.model.Raca;
import com.petshop.repository.AnimalRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final ClienteService clienteService;
    private final RacaService racaService;

    @Value("${file.upload-dir:src/main/resources/static/}")
    private String uploadDir;

    public AnimalService(AnimalRepository animalRepository, ClienteService clienteService, RacaService racaService) {
        this.animalRepository = animalRepository;
        this.clienteService = clienteService;
        this.racaService = racaService;
    }

    public List<Animal> buscarTodosOsAnimais() {
        return animalRepository.findAll();
    }

    public Animal buscarPorId(Integer id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal não encontrado com ID: " + id));
    }

    public Animal salvarAnimal(Animal animal) {
        // Validar e anexar Categoria
        if (animal.getCliente() == null || animal.getCliente().getId() == null) {
            throw new IllegalArgumentException("Categoria é obrigatória para o animal.");
        }
        Categoria categoria = categoriaService.buscarPorIdOuFalhar(animal.getCategoria().getId());
        animal.setCategoria(categoria);

        if (animal.getPreco() == null || animal.getPreco() < 0) {
            throw new IllegalArgumentException("Preço do animal não pode ser negativo.");
        }

        // Lógica de atualização vs criação
        if (animal.getId() != null) {
            animal existente = buscarPorId(animal.getId());
            existente.setNome(animal.getNome());
            existente.setPreco(animal.getPreco());
            existente.setCategoria(animal.getCategoria()); // Atualiza categoria
            if (animal.getFotoPath() != null && !animal.getFotoPath().isBlank()) {
                existente.setFotoPath(animal.getFotoPath());
            }
            return animalRepository.save(existente);
        } else {
            return animalRepository.save(animal);
        }
    }

    public void excluirAnimalPorId(Integer id) {
        // Verifica se o animal existe
        Animal ani = animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("animal não encontrado com ID: " + id));

        // Exclui o arquivo associado, se existir
        String fotoPath = ani.getFotoPath();
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
                throw new RuntimeException("Erro ao deletar o arquivo associado ao animal com ID: " + id, e);
            }
        }
}