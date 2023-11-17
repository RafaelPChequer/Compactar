package com.WorkWave.WorkWave.services;

import com.WorkWave.WorkWave.models.Autonomo;
import com.WorkWave.WorkWave.models.Categorias;
import com.WorkWave.WorkWave.repositories.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriasRepository categoriasRepository;

     public Categorias findById(Integer idCategorias) {
        Optional<Categorias> categoria = this.categoriasRepository.findById(idCategorias);
        return categoria.orElseThrow(()->new RuntimeException("Categoria não encontrada!"));
    }
}
