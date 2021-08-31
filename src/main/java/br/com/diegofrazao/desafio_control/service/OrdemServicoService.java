package br.com.diegofrazao.desafio_control.service;

import br.com.diegofrazao.desafio_control.model.OrdemServico;
import br.com.diegofrazao.desafio_control.model.Servico;
import br.com.diegofrazao.desafio_control.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ServicoService servicoService;

    public List<OrdemServico> getOrdemServicos() {
        return this.ordemServicoRepository.findAll();
    }

    public OrdemServico getOrdemServicoPorId(Long id) {
        return this.ordemServicoRepository.findById(id).orElse(null);
    }

    public void editarOrdemServico(OrdemServico ordemServico) {
        this.ordemServicoRepository.save(ordemServico);
    }

    public void inserirOrdemServico(OrdemServico ordemServico) throws Exception {
        if (ordemServico == null) {
            throw new Exception("OS inválida");
        }
        ordemServico.getServico().setOrdemServico(ordemServico);
        this.ordemServicoRepository.save(ordemServico);
    }

    public OrdemServico adicionarOrdemServico(Long id) {
        Servico servico = servicoService.getServicoPorId(id);
        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setServico(servico);
        return ordemServico;
    }

    public void deletarOrdemServico(Long id) {
        this.ordemServicoRepository.deleteById(id);
    }

}
