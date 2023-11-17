package com.WorkWave.WorkWave.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = Empresa.TABLE_NAME)
public class Empresa {
    public static final String TABLE_NAME = "empresa";


    @Id
    @Column(name = "cnpj", unique = true, length = 14,  nullable = false)
    private Integer cnpj;

    @Column(name = "endereco", length = 250, nullable = false)
    private String endereco;

    @Column(name = "telefone", length = 11, nullable = false)
    private Integer telefone;

    @Column(name = "comissao", nullable = true)
    private Long comissao;

}