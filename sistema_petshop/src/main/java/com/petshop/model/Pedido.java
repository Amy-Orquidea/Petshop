package com.petshop.model;

import java.util.Calendar;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido {

// Declaração das variáveis
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Calendar dataHora = Calendar.getInstance();

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Itens_de_Pedidos> itens_de_pedidos;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pagamentos> pagamentos;
// Construtores
    public Pedido() {}



    public Pedido(Long id, Calendar dataHora) {
        this.id = id;
        this.dataHora = dataHora;
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public Calendar getDataHora() {
        return dataHora;
    }



    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }




    
}