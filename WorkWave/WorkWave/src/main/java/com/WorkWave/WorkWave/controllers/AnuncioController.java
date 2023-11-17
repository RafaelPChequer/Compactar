package com.WorkWave.WorkWave.controllers;

import com.WorkWave.WorkWave.models.Anuncio;
import com.WorkWave.WorkWave.services.AnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/anuncios")
public class AnuncioController {

    @Autowired
    private AnuncioService anuncioService;

    @GetMapping("/{id}")
    public ResponseEntity<Anuncio> getAnuncioById(@PathVariable Long id) {
        Anuncio anuncio = anuncioService.findById(id);
        return ResponseEntity.ok(anuncio);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarAnuncio(@RequestParam String foto,
                                               @RequestParam float valor,
                                               @RequestParam String descricao) {
        anuncioService.criarAnuncio(foto, valor, descricao);
        return ResponseEntity.ok("Anuncio criado com sucesso!");
    }

    @PostMapping("/aprovarFoto/{idAnuncio}")
    public ResponseEntity<String> aprovarFoto(@PathVariable Long idAnuncio) {
        anuncioService.aprovarFoto(idAnuncio);
        return ResponseEntity.ok("Foto do anúncio aprovada com sucesso!");
    }

    @PostMapping("/negarFoto/{idAnuncio}")
    public ResponseEntity<String> negarFoto(@PathVariable Long idAnuncio) {
        anuncioService.negarFoto(idAnuncio);
        return ResponseEntity.ok("Foto do anúncio negada com sucesso!");
    }

    @PostMapping("/aprovarAnuncio/{idAnuncio}")
    public ResponseEntity<String> aprovarAnuncio(@PathVariable Long idAnuncio) {
        anuncioService.aprovarAnuncio(idAnuncio);
        return ResponseEntity.ok("Anúncio aprovado com sucesso!");
    }

    @GetMapping("/habilitarVisualizacao/{idAnuncio}")
    public ResponseEntity<Boolean> habilitarVisualizacao(@PathVariable Long idAnuncio) {
        boolean habilitado = anuncioService.habilitarVisualizacao(idAnuncio);
        return ResponseEntity.ok(habilitado);
    }
}
