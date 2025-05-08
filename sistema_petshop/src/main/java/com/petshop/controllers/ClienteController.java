package com.petshop.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petshop.comum.BibliotecaDeMetodosComunsAoSistema;
import com.petshop.model.Cliente;
import com.petshop.services.ClienteService;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Value("${imagens.clientes.path}")
    private String imagesPath;

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.buscarTodosOsClientes());
        return "clientes/lista";
    }

    @GetMapping("/clientes/cadastro")
    public String exibirFormularioCadastro() {
        return "clientes/cadastro";
    }

    @GetMapping("/clientes/editar/{id}")
    public String editarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.buscarPorId(id);
        model.addAttribute("cliente", cliente);
        return "clientes/editar";
    }

    @PostMapping("/clientes/editar/{id}")
    public String atualizarCliente(@PathVariable Long id, @ModelAttribute Cliente clienteAtualizado) {
        Cliente cliente = clienteService.buscarPorId(id);
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setTelefone(clienteAtualizado.getTelefone());
        cliente.setEndereco(clienteAtualizado.getEndereco());
        clienteService.salvarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/deletar/{id}")
    public String deletarCliente(@PathVariable Long id) {
        clienteService.excluirClientePorId(id);
        return "redirect:/clientes";
    }

    // Podemos salvar sem a foto por isso verificamos se a foto veio vazia com o
    // método isEmpty()
    @PostMapping("/clientes") // Salvar no POST /clientes
    public String salvarCliente(@ModelAttribute Cliente cliente,
            @RequestParam("foto") MultipartFile foto,
            RedirectAttributes redirectAttributes) { // Usar RedirectAttributes
        try {
            if (!foto.isEmpty()) {
                String nomeUUID = UUID.randomUUID().toString().replace("-", "");
                Path diretorioPath = Paths.get(imagesPath);
                Files.createDirectories(diretorioPath);
                Path caminhoArquivo = diretorioPath.resolve(nomeUUID);
                Files.copy(foto.getInputStream(), caminhoArquivo);
                
                // Salva o caminho no banco removendo src\main\resources\static\
                cliente.setFotoPath(BibliotecaDeMetodosComunsAoSistema.caminhoDasImagensWeb(caminhoArquivo.toString()));
            }
            // O service fará a lógica de criar novo
            clienteService.salvarCliente(cliente);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Cliente salvo com sucesso!");
            return "redirect:/clientes";
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao salvar a foto do cliente.");
            // Logar erro
            // model.addAttribute("cliente", cliente); // Devolve o objeto com erro para o
            // form
            return "clientes/cadastro"; // Volta para o form de cadastro
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao salvar cliente: " + e.getMessage());
            // Logar erro
            // model.addAttribute("cliente", cliente);
            return "clientes/cadastro";
        }
    }
    }
