package com.WorkWave.WorkWave.controllers;

import com.WorkWave.WorkWave.models.Servico;
import com.WorkWave.WorkWave.models.Anuncio;
import com.WorkWave.WorkWave.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable Long id) {
        try {
            Servico servico = servicoService.findById(id);
            return new ResponseEntity<>(servico, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/agendar")
    public ResponseEntity<String> agendarServico(@RequestParam String novaDataHora, @RequestParam Anuncio anuncio) {
        try {
            servicoService.agendarServico(novaDataHora, anuncio);
            return new ResponseEntity<>("Serviço agendado com sucesso.", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/aceitar")
    public ResponseEntity<String> aceitarServico(@RequestParam Long protocolo) {
        try {
            servicoService.aceitarServico(protocolo);
            return new ResponseEntity<>("Serviço aceito com sucesso.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/reagendar")
    public ResponseEntity<String> reagendarServico(@RequestParam Long protocolo, @RequestParam String novaDataHora) {
        try {
            servicoService.reagendarServico(protocolo, novaDataHora);
            return new ResponseEntity<>("Serviço reagendado com sucesso.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cancelar")
    public ResponseEntity<String> cancelarServico(@RequestParam Long protocolo) {
        try {
            servicoService.cancelarServico(protocolo);
            return new ResponseEntity<>("Serviço cancelado com sucesso.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/pagar")
    public ResponseEntity<String> pagarServico(@RequestParam Long protocolo) {
        try {
            servicoService.pagar(protocolo);
            return new ResponseEntity<>("Pagamento efetuado com sucesso.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
