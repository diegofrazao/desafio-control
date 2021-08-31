package br.com.diegofrazao.desafio_control.repository;

import br.com.diegofrazao.desafio_control.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
