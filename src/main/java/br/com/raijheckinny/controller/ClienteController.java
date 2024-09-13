package br.com.raijheckinny.controller;

import br.com.raijheckinny.domain.Cliente;
import br.com.raijheckinny.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/form")
    public String formCliente(Model model) {

        model.addAttribute("cliente", new Cliente());
        return "clienteForm";
    }

    @PostMapping("/save")
    public String saveCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.cadastrarCliente(cliente);
        return "redirect:/cliente/list";
    }

    @GetMapping("/list")
    public String listCliente(Model model) {
        model.addAttribute("cliente", clienteService.buscarTodosCliente());
        return "clienteList";
    }

    @GetMapping("/remover/{id}")
    public String deletarCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
        return "redirect:/cliente/list";
    }
    @GetMapping("/editar/{id}")
    public String alterarCliente(@ModelAttribute("id") Long id,Model model) {
        Cliente cliente = clienteService.buscarClientePorId(id);

        model.addAttribute("cliente", cliente);
        return "clienteEditar";
    }
}
