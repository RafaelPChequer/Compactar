package com.WorkWave.WorkWave.models;

import jakarta.persistence.*;
@Entity
@Table(name = "notificacao")
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "idNotificacao", nullable = false)
    private Integer idNotificacao;

    @Column(name = "data_hora", nullable = false)
    private String data_hora;
    @Column(name = "detalhes", nullable = false, length = 140)
    private String detalhes;
    @ManyToOne
    @JoinColumn(name = "idFuncionario", updatable = false, nullable = false)
    private Funcionario funcionario;
    @ManyToOne
    @JoinColumn(name = "idCliente", updatable = false, nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idAutonomo", nullable = false, updatable = false)
    private Autonomo autonomo;

}
