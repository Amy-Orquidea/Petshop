package com.petshop.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "itens_de_pedidos")
public class Itens_de_Pedidos implements Serializable {

    @EmbeddedId
    private ItensDePedidosId id;

    @ManyToOne
    @JoinColumn(name = "fk_vendedores_id", insertable = false, updatable = false)
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "fk_produtos_id", insertable = false, updatable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "fk_clientes_id", insertable = false, updatable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "fk_animais_id", insertable = false, updatable = false)
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "fk_pedidos_numero_pedido", insertable = false, updatable = false)
    private Pedido pedido;

    // Getters e setters, equals e hashCode
    public ItensDePedidosId getId() {
        return id;
    }

    public void setId(ItensDePedidosId id) {
        this.id = id;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}

@Embeddable
class ItensDePedidosId implements Serializable {

    @Column(name = "fk_vendedores_id")
    private Integer vendedorId;

    @Column(name = "fk_produtos_id")
    private Integer produtoId;

    @Column(name = "fk_clientes_id")
    private Integer clienteId;

    @Column(name = "fk_animais_id")
    private Integer animalId;

    @Column(name = "fk_pedidos_numero_pedido")
    private Integer pedidoNumeroPedido;

    // Getters e setters, equals e hashCode
}