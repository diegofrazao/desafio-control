package br.com.diegofrazao.desafio_control.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "ordem_de_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ordem_servico")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Servico servico;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "nome_funcionario", nullable = false)
    private String nomeFuncionario;

    @Column(name = "data", nullable = false)
//    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String data;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio = LocalTime.now();

    @Column(name = "hora_fim", nullable = false)
    private LocalTime horaFim = LocalTime.now();

    @Column(name = "detalhe")
    private String detalhe = "";

    public OrdemServico() {
    }

    public OrdemServico(Servico servico, int quantidade, String nomeFuncionario, String data, LocalTime horaInicio, LocalTime horaFim, String detalhe) {
        this.servico = servico;
        this.quantidade = quantidade;
        this.nomeFuncionario = nomeFuncionario;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.detalhe = detalhe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHoraInicio() {
        return horaInicio.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = LocalTime.parse(horaInicio, DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getHoraFim() {
        return horaFim.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = LocalTime.parse(horaFim, DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

}
