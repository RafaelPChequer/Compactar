package com.WorkWave.WorkWave.models;

import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Entity
@Table (name = "servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "protocolo", nullable = false)
    private Long protocolo;
    @Column(name = "valor", nullable = false)
    private Float valor;
    @Column(name = "data_hora", nullable = false)
    private String data_hora;
    @Column(name = "detalhes", nullable = false, length = 140)
    private String detalhes;

    @Column(name = "statusPago", nullable = false)
    private boolean statusPago;
    @Column(name = "statusAceito", nullable = false)
    private boolean statusAceito;

    @ManyToOne
    @JoinColumn(name = "idAutonomo", nullable = false, updatable = false)
    private Autonomo autonomo;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false, updatable = false)
    private Cliente cliente;

    private void Dados(String data_hora) {  // Obtem o time em Wed, etc..
        try {
            this.data_hora = new SimpleDateFormat("dd/MM/yyyy")
                    .format(new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US).parse(data_hora));
} catch (ParseException e) {
            throw new RuntimeException(e);}
}

    public void setDataHora(String novaDataHora) {
        data_hora=novaDataHora;
    }
    public void setValor(Float ihwg){
        valor=ihwg;
    }
    public void setDetalhes(String weher){
        detalhes=weher;
    }
    public boolean getStatusPago(){return statusPago;}
    public void setStatusPago(Boolean sts){
        statusPago=sts;
    }
    public boolean getStatusAceito(){return statusAceito;}
    public void setStatusAceito(Boolean sts){
        statusAceito=sts;
    }
}