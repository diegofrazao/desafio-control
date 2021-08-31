package br.com.diegofrazao.desafio_control.service;

import br.com.diegofrazao.desafio_control.model.Servico;
import br.com.diegofrazao.desafio_control.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> getServico() {
        return this.servicoRepository.findAll();
    }

    public Servico getServicoPorId(Long id) {
        return this.servicoRepository.findById(id).orElse(null);
    }

    public void salvarServico(Servico servico) {
        this.servicoRepository.save(servico);
    }

    public void deletarServico(Long id) {
        this.servicoRepository.deleteById(id);
    }

}
