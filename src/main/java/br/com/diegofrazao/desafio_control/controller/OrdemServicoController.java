package br.com.diegofrazao.desafio_control.controller;

import br.com.diegofrazao.desafio_control.model.OrdemServico;
import br.com.diegofrazao.desafio_control.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @GetMapping("/ordem-servico")
    public String ordemServico(Model model) {
        model.addAttribute("listarOrdemServico", this.ordemServicoService.getOrdemServicos());
        return "ordem-servico";
    }

    @GetMapping("/adicionar-ordem-servico")
    public String adicionarOrdemServico(Model model) {
        model.addAttribute("ordemServico", new OrdemServico());
        return "adicionar-ordem-servico";
    }

    @GetMapping("/adicionar-servico-ordem-servico/{id}")
    public ModelAndView adicionarOrdemServico(@PathVariable("id") Long id) {
        ModelAndView editView = new ModelAndView("adicionar-servico-ordem-servico");
        OrdemServico ordemServico = this.ordemServicoService.adicionarOrdemServico(id);
        editView.addObject("ordemServico", ordemServico);
        return editView;
    }

    @GetMapping("/editar-ordem-servico/{id}")
    public ModelAndView editarOrdemServico(@PathVariable("id") Long id) {
        ModelAndView editView = new ModelAndView("editar-ordem-servico");
        OrdemServico ordemServico = this.ordemServicoService.getOrdemServicoPorId(id);
        editView.addObject("ordemServico", ordemServico);
        return editView;
    }

    @GetMapping("/deletar-ordem-servico/{id}")
    public String deletarOrdemServico(@PathVariable("id") Long id) {
        this.ordemServicoService.deletarOrdemServico(id);
        return "redirect:/ordem-servico";
    }

    @PostMapping("/editar-ordem-servico")
    public String editarOrdemServico(@ModelAttribute OrdemServico ordemServico) {
        this.ordemServicoService.editarOrdemServico(ordemServico);
        return "redirect:/ordem-servico";
    }

    @PostMapping("/adicionar-ordem-servico")
    public String inserirOrdemServico(@ModelAttribute OrdemServico ordemServico) {
        try {
            this.ordemServicoService.inserirOrdemServico(ordemServico);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/ordem-servico";
    }
}
