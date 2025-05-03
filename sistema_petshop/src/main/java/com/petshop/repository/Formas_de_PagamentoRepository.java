package com.petshop.repository;

import com.petshop.model.Formas_de_Pagamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Formas_de_PagamentoRepository extends JpaRepository<Formas_de_Pagamento, Long> {
}