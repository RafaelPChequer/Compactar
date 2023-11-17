package com.WorkWave.WorkWave.models;

import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Entity
@Table (name = "advertisement")
public class Anuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "idAnuncio", nullable = false)
    private Long idAnuncio;
    @Column (name = "fotoURL", nullable = false)
    private String fotoURL;
    @Column(name = "valor", nullable = false)
    private Float valor;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "status", nullable = false, length = 140)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "cpfAutonomo", nullable = false, updatable = false)
    private Autonomo autonomo;
    @ManyToOne
    @JoinColumn(name = "cpfFuncionario", nullable = false, updatable = false)
    private Funcionario funcionario;
    @OneToOne
    @JoinColumn(name = "idCategorias", nullable = false, updatable = false)
    private Categorias categorias;

    public void setStatus(int stats) {
        status = stats;
    };
    public int getStatus() {
        return status;
    };
    public void setFoto(String fotos) {
        fotoURL = fotos;
    };
    public float getValor() {
        return valor;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setValor(float value) {
        valor = value;
    };
    public void setDescricao(String descrip) {
        descricao = descrip;
    };
}