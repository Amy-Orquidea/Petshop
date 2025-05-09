package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.petshop.model.Formas_de_Pagamento;
import com.petshop.services.Formas_de_PagamentoService;

@Controller
public class Formas_de_PagamentoController {

    @Autowired
    private Formas_de_PagamentoService formas_de_PagamentoService;

    @GetMapping("/formas")
    public String listarFormas(Model model) {
        model.addAttribute("formas", formas_de_PagamentoService.buscarTodasAsFormas());
        return "formas/lista";
    }

    @GetMapping("/formas/cadastro")
    public String exibirFormularioCadastro() {
        return "formas/cadastro";
    }

    @GetMapping("/formas/editar/{id}")
    public String editarEspecie(@PathVariable Integer id, Model model) {
        Formas_de_Pagamento formas_de_Pagamento = formas_de_PagamentoService.buscarPorId(id);
        model.addAttribute("forma", formas_de_Pagamento);
        return "formas/editar";
    }

    @PostMapping("/formas/editar/{id}")
    public String atualizarEspecie(@PathVariable Integer id,
            @ModelAttribute Formas_de_Pagamento formas_de_PagamentoAtualizada) {
        Formas_de_Pagamento formas_de_Pagamento = formas_de_PagamentoService.buscarPorId(id);
        formas_de_Pagamento.setId(formas_de_PagamentoAtualizada.getId());
        formas_de_Pagamento.setNome(formas_de_PagamentoAtualizada.getNome());
        formas_de_PagamentoService.salvarForma(formas_de_Pagamento);
        return "redirect:/formas";
    }

    @GetMapping("/formas/deletar/{id}")
    public String deletarEspecie(@PathVariable Integer id) {
        formas_de_PagamentoService.excluirFormaPorId(id);
        return "redirect:/formas";
    }

    @PostMapping("/formas")
    public String salvarEspecie(@ModelAttribute Formas_de_Pagamento formas_de_Pagamento) {
        formas_de_PagamentoService.salvarForma(formas_de_Pagamento);
        return "redirect:/formas";
    }

}
