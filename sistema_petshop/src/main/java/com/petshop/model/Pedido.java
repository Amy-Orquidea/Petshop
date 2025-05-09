package com.petshop.model;

import java.util.Calendar;
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
@Table(name = "pedidos")
public class Pedido {

    // Declaração das variáveis
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero_pedido;

    private Calendar dataHora = Calendar.getInstance();

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Itens_de_Pedidos> itens_de_pedidos;

    @ManyToOne
    @JoinColumn(name = "pagamento_id", insertable = false, updatable = false)
    private Pagamentos pagamentos;

    // Construtores
    public Pedido() {
    }

    public Pedido(Integer numero_pedido, Calendar dataHora) {
        this.numero_pedido = numero_pedido;
        this.dataHora = dataHora;
    }

    public Integer getNumeroPedido() {
        return numero_pedido;
    }

    public void setNumeroPedido(Integer numero_pedido) {
        this.numero_pedido = numero_pedido;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public Pagamentos getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Pagamentos pagamentos) {
        this.pagamentos = pagamentos;
    }

}