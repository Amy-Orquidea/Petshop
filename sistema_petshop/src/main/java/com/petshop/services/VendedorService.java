package com.petshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Vendedor;
import com.petshop.repository.VendedorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public List<Vendedor> buscarTodosOsVendedores() {
        return vendedorRepository.findAll();
    }

    public void salvarVendedor(Vendedor vendedor) {
        vendedorRepository.save(vendedor);
    }

    public Vendedor buscarPorId(Integer id) {
        return vendedorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vendedor não encontrado com ID: " + id));
    }

    public void excluirVendedorPorId(Integer id) {
        vendedorRepository.deleteById(id);
    }

    public Vendedor atualizarVendedor(Vendedor vendedor) {
        if (vendedor.getId() != null) {
            return vendedorRepository.save(vendedor);
        }
        return null;
    }
}
