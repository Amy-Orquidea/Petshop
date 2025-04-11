package com.petshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="formas_de_pagamento")
public class Formas_de_Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

      @ManyToOne
        @JoinColumn(name = "pagamento_id", insertable = false, updatable = false)
        private Pagamentos pagamentos;

    //constructors
    public Formas_de_Pagamento() {}

    public Formas_de_Pagamento(String descricao) {
        this.descricao = descricao;
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
