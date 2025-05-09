package com.petshop.repository;

import com.petshop.model.Itens_de_Pedidos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Itens_de_PedidosRepository extends JpaRepository<Itens_de_Pedidos, Integer> {
}