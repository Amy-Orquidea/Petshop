package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petshop.model.Categoria;
import com.petshop.services.CategoriaService;

import jakarta.persistence.EntityNotFoundException;

@Controller("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarCategoria(Model model) {
        model.addAttribute("categorias", categoriaService.buscarTodosAsCategorias());
        return "categorias/lista";
    }

    @GetMapping("/cadastro")
    public String exibirFormularioCadastro() {
        return "categorias/cadastro";
    }

   @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Categoria categoria = categoriaService.buscarPorId(id);
            model.addAttribute("categoria", categoria);
            return "categorias/editar";
        } catch (EntityNotFoundException e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Categoria não encontrada com ID: " + id);
            return "redirect:/categorias";
        }
    }

    @PostMapping("/editar/{id}")
    public String atualizarCategoria(@PathVariable Integer id,
            @ModelAttribute Categoria categoriaAtualizado,
            RedirectAttributes redirectAttributes) {
        try {
            categoriaAtualizado.setId(id);
            // O service salvarCategoria fará a lógica de merge/update
            categoriaService.salvarCategoria(categoriaAtualizado);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Categoria atualizada com sucesso!");
            return "redirect:/categorias";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao atualizar categoria: " + e.getMessage());
            // Logar erro
            return "redirect:/categorias/editar/" + id;
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletarcategoria(@PathVariable Integer id) {
        categoriaService.excluirCategoriaPorId(id);
        return "redirect:/categorias";
    }

    // Podemos salvar sem a foto por isso verificamos se a foto veio vazia com o
    // método isEmpty()

    @PostMapping
    public String salvarCategoria(@ModelAttribute Categoria categoria, Model model,
            RedirectAttributes redirectAttributes) {
        try {
            // O service tem a lógica para guardar a categoria
            categoriaService.salvarCategoria(categoria);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Categoria salva com sucesso!");
            return "redirect:/categorias";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao salvar categoria: " + e.getMessage());
            model.addAttribute("categoria", categoria);
            return "categorias/cadastro";
        }
    }

}
