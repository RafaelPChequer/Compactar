package com.WorkWave.WorkWave.controllers;

import com.WorkWave.WorkWave.models.Autonomo;
import com.WorkWave.WorkWave.services.AutonomoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/autonomos")
public class AutonomoController {

    @Autowired
    private AutonomoService autonomoService;

    @GetMapping("/{id}")
    public ResponseEntity<Autonomo> getAutonomoById(@PathVariable Integer id) {
        Autonomo autonomo = autonomoService.findById(id);
        return new ResponseEntity<>(autonomo, HttpStatus.OK);
    }

    @PostMapping
    public void createAutonomo(@RequestBody Autonomo autonomo) {
    }

    @PutMapping("/{id}")
    public void updateAutonomo(@PathVariable Integer id, @RequestBody Autonomo updatedAutonomo) {
        Autonomo existingAutonomo = autonomoService.findById(id);

        // Atualize os campos necessários do Autonomo existente com os valores do Autonomo atualizado
        existingAutonomo.setNome(updatedAutonomo.getNome());
        existingAutonomo.setSenha(updatedAutonomo.getSenha());
        existingAutonomo.setDataNascimento(updatedAutonomo.getDataNascimento());
        existingAutonomo.setEmail(updatedAutonomo.getEmail());
        existingAutonomo.setTelefone(updatedAutonomo.getTelefone());
        existingAutonomo.setEndereco(updatedAutonomo.getEndereco());
        existingAutonomo.setExperiencia(updatedAutonomo.getExperiencia());
        existingAutonomo.setCategorias(updatedAutonomo.getCategorias());
        existingAutonomo.setPortifolio(updatedAutonomo.getPortifolio());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutonomo(@PathVariable Integer id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
