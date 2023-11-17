package com.WorkWave.WorkWave.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "idCliente", updatable = false)
    private Long id;

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

    public Long getId() {return id;}
    public String getNome() {return nome;}
    public String getSenha() {return senha;}

    public Integer getTelefone() {return telefone;}

    public void setNome(String nome) {this.nome = nome;}
    public void setSenha(String erh) {senha = erh;}
    public void setDataNascimento(String ewtg) {dataNascimento = ewtg;}
    public void setEmail(String erh) {email = erh;}
    public void setTelefone(int erh) {telefone = erh;}
    public void setEndereco(String erh) {endereco = erh;}
}
