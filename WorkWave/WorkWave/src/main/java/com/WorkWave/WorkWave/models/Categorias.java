package com.WorkWave.WorkWave.models;

import jakarta.persistence.*;

@Entity
@Table (name = "categoria")
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCategorias", unique = true, nullable = false )
    private Integer idCategorias;
    @Column (name = "limpeza", nullable = false)
    private boolean limpeza;
    @Column (name = "eletrico", nullable = false)
    private boolean eletrico;
    @Column (name = "encanador",nullable = false)
    private boolean encanador;
    @Column (name = "fotografia",nullable = false)
    private boolean fotografia;
    @Column (name = "jardinagem",nullable = false)
    private boolean jardinagem;
    @Column (name = "eventos",nullable = false)
    private boolean enventos;
}