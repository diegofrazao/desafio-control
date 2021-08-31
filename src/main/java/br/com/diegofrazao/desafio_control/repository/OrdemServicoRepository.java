package br.com.diegofrazao.desafio_control.repository;

import br.com.diegofrazao.desafio_control.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
}
