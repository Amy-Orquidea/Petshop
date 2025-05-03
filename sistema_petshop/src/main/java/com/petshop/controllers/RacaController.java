package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petshop.model.Especie;
import com.petshop.model.Raca;
import com.petshop.services.EspecieService;
import com.petshop.services.RacaService;

@Controller
public class RacaController {

    @Autowired
    private RacaService racaService;

    @Autowired
    private EspecieService especieService;

    @GetMapping("/racas")
    public String listarRaca(Model model) {
        model.addAttribute("racas", racaService.buscarTodasAsRacas());
        return "racas/lista";
    }

    @GetMapping("/racas/cadastro")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("especies", especieService.buscarTodasAsEspecies()); // Lista de especies para seleção
        return "racas/cadastro";
    }

    @GetMapping("/racas/editar/{id}")
    public String editarRaca(@PathVariable Long id, Model model) {
        Raca raca = racaService.buscarPorId(id);
        model.addAttribute("raca", raca);
        model.addAttribute("especies", especieService.buscarTodasAsEspecies());
        return "racas/editar";
    }

    @PostMapping("/racas/editar/{id}")
    public String atualizarRaca(@PathVariable Long id, @ModelAttribute Raca racaAtualizado,
            @RequestParam("especieId") Long especieId) {
        Raca raca = racaService.buscarPorId(id);
        Especie especie = especieService.buscarPorId(especieId);
        raca.setId(racaAtualizado.getId());
        raca.setNome(racaAtualizado.getNome());
        raca.setEspecie(especie);
        racaService.salvarRaca(raca);
        return "redirect:/racas";
    }

    @GetMapping("/racas/deletar/{id}")
    public String deletarraca(@PathVariable Long id) {
        racaService.excluirRacaPorId(id);
        return "redirect:/racas";
    }

    @PostMapping("/racas")
    public String salvarracas(@ModelAttribute Raca raca, @RequestParam("especieId") Long especieId) {
        Especie especie = especieService.buscarPorId(especieId);
        raca.setEspecie(especie);
        racaService.salvarRaca(raca);
        return "redirect:/racas";
    }

}
