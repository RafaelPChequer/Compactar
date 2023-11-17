package com.WorkWave.WorkWave.repositories;

import com.WorkWave.WorkWave.models.Autonomo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutonomoRepository extends JpaRepository<Autonomo, Integer> {

}
