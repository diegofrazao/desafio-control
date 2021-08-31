package br.com.diegofrazao.desafio_control.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico", nullable = false)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private double valor;

    @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL)
    private List<OrdemServico> ordemServicos = new ArrayList<>();

    public Servico() {

    }

    public Servico(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<OrdemServico> getOrdemServico() {
        return ordemServicos;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServicos.add(ordemServico);
    }

}
