package br.com.diegofrazao.desafio_control.controller;

import br.com.diegofrazao.desafio_control.model.Servico;
import br.com.diegofrazao.desafio_control.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/servico")
    public String listarServico(Model model) {
        model.addAttribute("listarServicos", this.servicoService.getServico());
        return "servico";
    }

    @GetMapping("/adicionar-servico")
    public String adicionarServico(Model model) {
        model.addAttribute("servico", new Servico());
        return "adicionar-servico";
    }

    @GetMapping("/editar-servico/{id}")
    public ModelAndView editarServico(@PathVariable("id") Long id) {
        ModelAndView editView = new ModelAndView("editar-servico");
        Servico service = this.servicoService.getServicoPorId(id);
        editView.addObject("editarServico", service);
        return editView;
    }

    @GetMapping("/deletar-servico/{id}")
    public String deletarServico(@PathVariable("id") Long id) {
        this.servicoService.deletarServico(id);
        return "redirect:/servico";
    }

    @PostMapping("/editar-servico")
    public String editarServico(@ModelAttribute Servico servico) {
        this.servicoService.salvarServico(servico);
        return "redirect:/servico";
    }

    @PostMapping("/adicionar-servico")
    public String inserirServico(@ModelAttribute Servico servico) {
        this.servicoService.salvarServico(servico);
        return "redirect:/servico";
    }

}
