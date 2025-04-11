package com.petshop.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="pagamentos")
public class Pagamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valor_pago;


    @OneToMany(mappedBy = "pagamentos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Formas_de_Pagamento> forma_de_pagamento;
      @ManyToOne
        @JoinColumn(name = "pedido_id", insertable = false, updatable = false)
        private Pedido pedido;

    //constructors
    public Pagamentos() {}


    public Pagamentos(double valor_pago) {
        this.valor_pago = valor_pago;
    }

    //getters and setters
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public double getValor_pago() {
        return valor_pago;
    }


    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }

    
    

}
