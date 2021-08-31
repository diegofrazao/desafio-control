package br.com.diegofrazao.desafio_control.model;

import java.util.List;

public class Relatorio {

    private Servico servico;
    private Double valorServico;
    private Integer quantidade;

    public Relatorio(Servico servico,
                     Double valorServico,
                     Integer quantidade) {
        this.servico = servico;
        this.valorServico = valorServico;
        this.quantidade = quantidade;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Double getValorServico() {
        return valorServico;
    }

    public void setValorServico(Double valorServico) {
        this.valorServico = valorServico;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getDesconto() {
        if (this.quantidade >= 30)
            return 30;
        else if (this.quantidade >= 20)
            return 20;
        else if (this.quantidade >= 10)
            return 10;
        else
            return 0;
    }

    public Double getValorTotal() {
        return this.quantidade * this.servico.getValor();
    }

    public Double getValorFinal() {
        Double descontoValorFinal = getValorTotal() * (getDesconto() / 100.0);
        return this.getValorTotal() - descontoValorFinal;
    }

    public Double getSomaValorTotal(List<Relatorio> relatorios) {
        Double soma = 0.0;
        for (Relatorio r : relatorios) {
            soma += r.getValorTotal();
        }
        return soma;
    }
}
