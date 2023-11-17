package com.WorkWave.WorkWave.services;


import com.WorkWave.WorkWave.models.Anuncio;
import com.WorkWave.WorkWave.models.Servico;
import com.WorkWave.WorkWave.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico findById(Long protocolo){
        Optional<Servico> servico = this.servicoRepository.findById(protocolo);
        return servico.orElseThrow(()->new RuntimeException("Cliente não encontrado!"));
    }
    public void agendarServico(String novaDataHora, Anuncio anuncio) {
        Servico servico =  new Servico();
        servico.setValor(anuncio.getValor());
        servico.setDataHora(novaDataHora);
        servico.setDetalhes(anuncio.getDescricao());
        servico.setStatusAceito(false);
        servicoRepository.save(servico);
    }
    public void aceitarServico(Long protocolo) {
        Servico servico = servicoRepository.findById(protocolo)
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado com o protocolo: " + protocolo));
        servico.setStatusAceito(true);
        servicoRepository.save(servico);
    }
    public void reagendarServico(Long protocolo, String novaDataHora) {
        Servico servico = servicoRepository.findById(protocolo)
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado com o protocolo: " + protocolo));
        if(servico.getStatusAceito()) {
            servico.setDataHora(novaDataHora);
            servicoRepository.save(servico);
        }
    }
    public void cancelarServico(Long protocolo) {
        Servico servico = servicoRepository.findById(protocolo)
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado com o protocolo: " + protocolo));
        servicoRepository.delete(servico);
    }

    public void pagar(Long protocolo){
        Servico servico = servicoRepository.findById(protocolo)
                .orElseThrow(()-> new IllegalArgumentException("Serviço não encontrado com o protocolo: " + protocolo));
        servico.setStatusPago(true);
        servicoRepository.save(servico);

    }
}