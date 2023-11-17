package com.WorkWave.WorkWave.services;

import com.WorkWave.WorkWave.models.Autonomo;
import com.WorkWave.WorkWave.repositories.AutonomoRepository;
import com.WorkWave.WorkWave.repositories.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AutonomoService {
    @Autowired
    private AutonomoRepository autonomoRepository;

    public Autonomo findById(Integer id){
        Optional<Autonomo> autonomo = this.autonomoRepository.findById(id);
        return autonomo.orElseThrow(()->new RuntimeException("Autonomo não encontrado!"));
    }
}
