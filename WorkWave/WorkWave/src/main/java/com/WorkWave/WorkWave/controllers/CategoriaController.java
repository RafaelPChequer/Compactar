package com.WorkWave.WorkWave.controllers;

import com.WorkWave.WorkWave.models.Categorias;
import com.WorkWave.WorkWave.repositories.CategoriasRepository;
import com.WorkWave.WorkWave.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping("/{id}")
    public ResponseEntity<Categorias> getCategoriaById(@PathVariable Integer id) {
        try {
            Categorias categoria = categoriaService.findById(id);
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
