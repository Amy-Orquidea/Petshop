package com.petshop.model;

import java.time.LocalDateTime;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="estoque")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime data_entrada;
    private String nota_de_entrada;
    private int quantidade;
    private int valor_de_entrada;

    @ManyToOne
        @JoinColumn(name = "produto_id", nullable = false)
        private Produto produto;
    
    //constructors
    public Estoque() {}

    public Estoque(Long id, LocalDateTime data_entrada, String nota_de_entrada, int quantidade, int valor_de_entrada,
            Produto produto) {
        this.id = id;
        this.data_entrada = data_entrada;
        this.nota_de_entrada = nota_de_entrada;
        this.quantidade = quantidade;
        this.valor_de_entrada = valor_de_entrada;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(LocalDateTime data_entrada) {
        this.data_entrada = data_entrada;
    }

    public String getNota_de_entrada() {
        return nota_de_entrada;
    }

    public void setNota_de_entrada(String nota_de_entrada) {
        this.nota_de_entrada = nota_de_entrada;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getValor_de_entrada() {
        return valor_de_entrada;
    }

    public void setValor_de_entrada(int valor_de_entrada) {
        this.valor_de_entrada = valor_de_entrada;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    

}