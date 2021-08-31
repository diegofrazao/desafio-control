package br.com.diegofrazao.desafio_control.controller;

import br.com.diegofrazao.desafio_control.model.OrdemServico;
import br.com.diegofrazao.desafio_control.model.Relatorio;
import br.com.diegofrazao.desafio_control.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RelatorioController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @GetMapping("/relatorio")
    public String listarRelatorio(Model model) {
        List<OrdemServico> ordemServicos = this.ordemServicoService.getOrdemServicos();
        model.addAttribute("exibirRelatorio",
                ordemServicos.stream().map(
                        ordemServico -> new Relatorio(ordemServico.getServico(),
                                ordemServico.getServico().getValor(),
                                ordemServico.getQuantidade()
                        )).collect(Collectors.toList()));
        return "relatorio";
    }

}
