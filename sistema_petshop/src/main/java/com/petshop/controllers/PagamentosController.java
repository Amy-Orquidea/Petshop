package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petshop.model.Formas_de_Pagamento;
import com.petshop.model.Pagamentos;
import com.petshop.services.Formas_de_PagamentoService;
import com.petshop.services.PagamentosService;

@Controller
public class PagamentosController {

    @Autowired
    private PagamentosService pagamentosService;

    @Autowired
    private Formas_de_PagamentoService formas_de_PagamentoService;

    @GetMapping("/pagamentos")
    public String listarPagamento(Model model) {
        model.addAttribute("pagamentos", pagamentosService.buscarTodosOsPagamentos());
        return "pagamentos/lista";
    }

    @GetMapping("/pagamentos/cadastro")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("pagamentos", pagamentosService.buscarTodosOsPagamentos()); // Lista de especies para seleção
        return "pagamentos/cadastro";
    }

    @GetMapping("/pagamentos/editar/{id}")
    public String editarPagamento(@PathVariable Long id, Model model) {
        Pagamentos pagamentos = pagamentosService.buscarPorId(id);
        model.addAttribute("pagamento", pagamentos);
        model.addAttribute("formas", formas_de_PagamentoService.buscarTodasAsFormas());
        return "pagamentos/editar";
    }

    @PostMapping("/pagamentos/editar/{id}")
    public String atualizarPagamento(@PathVariable Long id, @ModelAttribute Pagamentos pagamentoAtualizado,
            @RequestParam("pagamentoId") Long pagamentoId) {
        Pagamentos pagamentos = pagamentosService.buscarPorId(id);
        Formas_de_Pagamento formas_de_Pagamento = formas_de_PagamentoService.buscarPorId(pagamentoId);
        pagamentos.setId(pagamentoAtualizado.getId());
        pagamentos.setValor_pago(pagamentoAtualizado.getValor_pago());
        pagamentoAtualizado.setFormas_de_Pagamento(formas_de_Pagamento);
        pagamentosService.salvarPagamento(pagamentos);
        return "redirect:/pagamentos";
    }

    @GetMapping("/pagamentos/deletar/{id}")
    public String deletarPagamento(@PathVariable Long id) {
        pagamentosService.excluirPagamentoPorId(id);
        return "redirect:/pagamentos";
    }

    @PostMapping("/pagamentos")
    public String salvarPagamento(@ModelAttribute Pagamentos pagamentos, @RequestParam("formaId") Long formaId) {
        Formas_de_Pagamento formas_de_Pagamento = formas_de_PagamentoService.buscarPorId(formaId);
        pagamentos.setFormas_de_Pagamento(formas_de_Pagamento);
        pagamentosService.salvarPagamento(pagamentos);
        return "redirect:/racas";
    }

}