package com.WorkWave.WorkWave.models;

import jakarta.persistence.*;

@Entity
@Table (name = "funcionario")
public class Funcionario {

    @Id
    @Column(name = "idFuncionario", updatable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cnpjEmpresa", nullable = false)
    private Empresa empresa;

    @Column(name = "salario", nullable = true)
    private float salario;

    @Column(name = "name", length = 100, unique = true, nullable = false)
    private String nome;

    @Column(name = "senha", length = 60, nullable = false)
    private String senha;

    @Column(name = "dataNascimento")
    private String dataNascimento;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone", length = 11, nullable = false)
    private Integer telefone;

    @Column(name = "endereco", length = 100)
    private String endereco;
}

