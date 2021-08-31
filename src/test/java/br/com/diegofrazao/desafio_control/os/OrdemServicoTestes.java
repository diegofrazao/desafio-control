package br.com.diegofrazao.desafio_control.os;

import br.com.diegofrazao.desafio_control.model.OrdemServico;
import br.com.diegofrazao.desafio_control.model.Servico;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrdemServicoTestes {

    @Test
    public void testeGetFuncionario() {
        OrdemServico ordemServico = new OrdemServico(new Servico("descricao", 0.0),
                1,
                "Diego Frazão",
                "2020-08-10",
                LocalTime.now(),
                LocalTime.now(),
                "testes"
        );
        assertEquals(ordemServico.getNomeFuncionario(), "Diego Frazão");
    }

    @Test
    public void testeSetFuncionario() {
        OrdemServico ordemServico = new OrdemServico(new Servico("descricao", 0.0),
                1,
                "Diego Frazão",
                "2020-08-10",
                LocalTime.now(),
                LocalTime.now(),
                "testes"
        );
        ordemServico.setNomeFuncionario("Funcionario Control");
        assertEquals(ordemServico.getNomeFuncionario(), "Funcionario Control");
    }

    @Test
    public void testeGetDetalhe() {
        OrdemServico ordemServico = new OrdemServico(new Servico("descricao", 0.0),
                1,
                "Diego Frazão",
                "2020-08-10",
                LocalTime.now(),
                LocalTime.now(),
                "testes"
        );
        assertEquals(ordemServico.getDetalhe(), "testes");
    }

    @Test
    public void testeSetDetalhe() {
        OrdemServico ordemServico = new OrdemServico(new Servico("descricao", 0.0),
                1,
                "Diego Frazão",
                "2020-08-10",
                LocalTime.now(),
                LocalTime.now(),
                "testes"
        );
        ordemServico.setDetalhe("Detalhamento OS");
        assertEquals(ordemServico.getDetalhe(), "Detalhamento OS");
    }
}
