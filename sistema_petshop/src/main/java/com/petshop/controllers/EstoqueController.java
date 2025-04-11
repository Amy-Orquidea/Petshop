package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petshop.model.Estoque;
import com.petshop.model.Produto;
import com.petshop.services.EstoqueService;
import com.petshop.services.ProdutoService;

@Controller
public class EstoqueController {
    
   @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private ProdutoService produtoService;


    @GetMapping("/estoques")
    public String listarEstoque(Model model) {
        model.addAttribute("estoques", estoqueService.buscarTudoNoEstoque());
        return "estoques/lista";
    }

    @GetMapping("/estoques/cadastro")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("produtos", produtoService.buscarTodosOsProdutos()); // Lista de especies para seleção
        return "estoques/cadastro";
    }

    @GetMapping("/estoques/deletar/{id}")
    public String deletarraca(@PathVariable Long id) {
        estoqueService.excluirEstoquePorId(id);
        return "redirect:/estoques";
    }
 @PostMapping("/estoques")
    public String salvarestoque(@ModelAttribute Estoque estoque, Model model, @RequestParam("produtoId") Long produtoId) {
        Produto produto = produtoService.buscarPorId(produtoId)
        .orElseThrow(() -> new IllegalArgumentException("produto inválido: " + produtoId));
estoque.setProduto(produto);
        estoqueService.salvarEstoque(estoque);
        model.addAttribute("estoques", estoqueService.buscarTudoNoEstoque());
        return "redirect:/estoques";
    }
    
}
