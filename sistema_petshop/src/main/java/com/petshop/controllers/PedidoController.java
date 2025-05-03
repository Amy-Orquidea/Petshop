package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petshop.model.Pedido;
import com.petshop.model.Pagamentos;
import com.petshop.services.PagamentosService;
import com.petshop.services.PedidoService;

@Controller
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PagamentosService pagamentosService;

    @GetMapping("/pedidos")
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidoService.buscarTodosOsPedidos());
        return "pedidos/lista";
    }

    @GetMapping("/pedidos/cadastro")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("pagamentos", pagamentosService.buscarTodosOsPagamentos());
        return "pedidos/cadastro";
    }

    @GetMapping("/pedidos/editar/{id}")
    public String editarPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.buscarPorId(id);
        model.addAttribute("pedido", pedido);
        model.addAttribute("pagamentos", pagamentosService.buscarTodosOsPagamentos());
        return "pedidos/editar";
    }

    @PostMapping("/pedidos/editar/{id}")
    public String atualizarProduto(@PathVariable Long id, @ModelAttribute Pedido pedidoAtualizado) {
        Pedido pedido = pedidoService.buscarPorId(id);
        Pagamentos pagamentos = pagamentosService.buscarPorId(id);
        pedido.setNumeroPedido(pedidoAtualizado.getNumeroPedido());
        pedido.setDataHora(pedidoAtualizado.getDataHora());
        pedido.setPagamentos(pagamentos);
        pedidoService.salvarPedido(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/pedidos/deletar/{id}")
    public String deletarpedido(@PathVariable Long id) {
        pedidoService.excluirPedidoPorId(id);
        return "redirect:/pedisdos";
    }

    // Podemos salvar sem a foto por isso verificamos se a foto veio vazia com o
    // método isEmpty()
    @PostMapping("/pedidos")
    public String salvarpedido(@ModelAttribute Pedido pedido, @RequestParam("pagamentoId") Long pagamentoId) {
        Pagamentos pagamentos = pagamentosService.buscarPorId(pagamentoId);
        pedido.setPagamentos(pagamentos);
        pedidoService.salvarPedido(pedido);
        return "redirect:/pedidos";
    }

}
