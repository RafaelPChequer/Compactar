package com.WorkWave.WorkWave.models;

import jakarta.persistence.*;

@Entity
@Table(name = "autonomo")
public class Autonomo {

    @Id
    @Column(name = "idAutonomo", updatable = false)
    private Integer id;

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

    @Column(name = "experiencia", nullable = true)
    private String experiencia;

    @OneToOne
    @JoinColumn(name = "idCategorias", nullable = false)
    private Categorias categorias;

    @Column(name = "urlPortifolio", nullable = true)
    private String portifolio;

    // Constructors

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public String getPortifolio() {
        return portifolio;
    }

    public void setPortifolio(String portifolio) {
        this.portifolio = portifolio;
    }
}
