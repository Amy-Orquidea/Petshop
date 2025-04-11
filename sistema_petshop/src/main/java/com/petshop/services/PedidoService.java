package com.petshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Pedido;
import com.petshop.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Listar todos os pedidos
    public List<Pedido> buscarTodosOsPedidos() {
        return pedidoRepository.findAll();
    }

    // diferença entre salvar e editar é que se salvar passando o id atualiza
    // salvar sem id o banco de dado vai gerar um registro novo do pedido
    public void salvarPedido(Pedido pedido) {
        pedidoRepository.save(pedido); 
    }

    // Buscar um pedido por ID no JPA Repository
    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    // Deletar um pedido por ID no JPA Repository
    public void excluirPedidoPorId(Long id) {
        pedidoRepository.deleteById(id);
    }

    // Editar pedido (atualizar suas informações)
    public Pedido atualizarPedido(Pedido pedido) {
        if (pedido.getId() != null) {
            return pedidoRepository.save(pedido);  // aqui chamamos o método save acima
        }
        return null;
    }


}