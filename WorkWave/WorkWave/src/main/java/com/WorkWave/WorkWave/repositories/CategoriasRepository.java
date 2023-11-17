package com.WorkWave.WorkWave.repositories;

import com.WorkWave.WorkWave.models.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Integer> {

}
