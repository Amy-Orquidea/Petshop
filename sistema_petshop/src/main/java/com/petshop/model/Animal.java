package com.petshop.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Vincula variáveis desta classe às colunas na tabela do banco de dados
@Table(name = "animais") // usado quando o nome da tabela é diferente da classe
public class Animal {

    // Declaração das variáveis
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150)
    private String nome;

    @Column(name = "data_de_nascimento")
    private LocalDateTime dataDeNascimento;

    private String fotoPath; // Caminho da imagem


    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "raca_id", nullable = false)
    private Raca raca;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Itens_de_Pedidos> itens_de_pedidos;

    // Construtores
    public Animal() {
    }

    public Animal(String nome, LocalDateTime dataDeNascimento, String fotoPath, Cliente cliente, Raca raca) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.fotoPath = fotoPath;
        this.cliente = cliente;
        this.raca = raca;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFotoPath() {
        return fotoPath;
    }

    public void setFotoPath(String fotoPath) {
        this.fotoPath = fotoPath;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public LocalDateTime getdataDeNascimento() {
        return dataDeNascimento;
    }

    public void setdataDeNascimento(LocalDateTime dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public List<Itens_de_Pedidos> getItens_de_pedidos() {
        return itens_de_pedidos;
    }

    public void setItens_de_pedidos(List<Itens_de_Pedidos> itens_de_pedidos) {
        this.itens_de_pedidos = itens_de_pedidos;
    }

}
