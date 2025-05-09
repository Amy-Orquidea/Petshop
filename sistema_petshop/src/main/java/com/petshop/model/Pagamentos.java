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
@Table(name = "pagamentos")
public class Pagamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double valor_pago;

    @OneToMany(mappedBy = "pagamentos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;
    @ManyToOne
    @JoinColumn(name = "formas_id", insertable = false, updatable = false)
    private Formas_de_Pagamento formas_de_pagamento;

    // constructors
    public Pagamentos() {
    }

    public Pagamentos(double valor_pago) {
        this.valor_pago = valor_pago;
    }

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Formas_de_Pagamento getFormas_de_Pagamento() {
        return formas_de_pagamento;
    }

    public void setFormas_de_Pagamento(Formas_de_Pagamento formas_de_Pagamento) {
        this.formas_de_pagamento = formas_de_Pagamento;
    }

}
