package com.WorkWave.WorkWave.services;

import com.WorkWave.WorkWave.models.Anuncio;
import com.WorkWave.WorkWave.models.Servico;
import com.WorkWave.WorkWave.repositories.AnuncioRepository;
import com.WorkWave.WorkWave.repositories.AutonomoRepository;
import com.WorkWave.WorkWave.repositories.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AnuncioService {
    @Autowired
    private AnuncioRepository anuncioRepository;

    public Anuncio findById(Long idAnuncio){
        Optional<Anuncio> anuncio = this.anuncioRepository.findById(idAnuncio);
        return anuncio.orElseThrow(()->new RuntimeException("Anuncio não encontrado!"));
    }
    public void criarAnuncio(String foto, float valor, String descricao) {
        Anuncio anuncio =  new Anuncio();
        anuncio.setFoto(foto);
        anuncio.setValor(valor);
        anuncio.setDescricao(descricao);
        anuncio.setStatus(0);
        anuncioRepository.save(anuncio);
    }
    public void aprovarFoto(Long idAnuncio) {
        Anuncio anuncio = anuncioRepository.findById(idAnuncio)
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado com o protocolo: " + idAnuncio));
        anuncio.setStatus(1);
        anuncioRepository.save(anuncio);
    }
    public void negarFoto(Long idAnuncio) {
        Anuncio anuncio = anuncioRepository.findById(idAnuncio)
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado com o protocolo: " + idAnuncio));
        anuncio.setStatus(0);
        anuncio.setFoto(null);
        anuncioRepository.save(anuncio);
    }
    public void aprovarAnuncio(Long idAnuncio) {
        Anuncio anuncio = anuncioRepository.findById(idAnuncio)
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado com o protocolo: " + idAnuncio));
        if(anuncio.getStatus() == 1) {
            anuncio.setStatus(2);
        }
        anuncioRepository.save(anuncio);
    }
    public boolean habilitarVisualizacao(Long idAnuncio) {
        Anuncio anuncio = anuncioRepository.findById(idAnuncio)
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado com o protocolo: " + idAnuncio));
        if(anuncio.getStatus() == 2) {
            return true;
        } else {
            return false;
        }
    }
}