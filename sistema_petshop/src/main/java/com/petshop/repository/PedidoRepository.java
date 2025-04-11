package com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {}