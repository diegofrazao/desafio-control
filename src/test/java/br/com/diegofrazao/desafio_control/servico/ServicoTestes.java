package br.com.diegofrazao.desafio_control.servico;

import br.com.diegofrazao.desafio_control.model.Servico;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServicoTestes {

    @Test
    public void testeGetDescricaoServico() {
        Servico servico = new Servico("corte de luz",10.0);
        assertEquals(servico.getDescricao(), "corte de luz");
    }

    @Test
    public void testeSetDescricaoServico() {
        Servico servico = new Servico("descricao",10.0);
        servico.setDescricao("corte de luz");
        assertEquals(servico.getDescricao(), "corte de luz");
    }

    @Test
    public void testeGetValorServico() {
        Servico servico = new Servico("corte de luz",10.0);
        assertEquals(servico.getValor(), 10.00);
    }

    @Test
    public void testeSetValorServico() {
        Servico servico = new Servico("descricao",10.0);
        servico.setValor(45.00);
        assertEquals(servico.getValor(), 45.00);
    }

}
