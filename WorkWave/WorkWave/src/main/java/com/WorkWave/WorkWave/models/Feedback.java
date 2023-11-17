package com.WorkWave.WorkWave.models;

import jakarta.persistence.*;

public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFeedback")
    private Integer idFeedback;

    @Column(name = "Avaliacao")
    private Integer avaliacao;

    @Column(name = "Descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "Resposta", columnDefinition = "TEXT")
    private String resposta;

    @Column(name = "Servico_Protocolo")
    private Integer servicoProtocolo;

    @ManyToOne
    @JoinColumn(name = "Servico_Autonomo_IDAutonomo")
    private Autonomo autonomo;



    @ManyToOne
    @JoinColumn(name = "Servico_Cliente_idCliente")
    private Cliente cliente;


    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public int getServicoProtocolo() {
        return servicoProtocolo;
    }

    public void setSErvicoProtocolo(int servicoProtocolo) {
        this.servicoProtocolo = servicoProtocolo;
    }

    public Autonomo getAutonomo() {
        return autonomo;
    }

    public void setAutonomo(Autonomo autonomo) {
        this.autonomo = autonomo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setIdFeedback(Integer idFeedback) {
        this.idFeedback = idFeedback ;
    }
}


