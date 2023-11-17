
package com.WorkWave.WorkWave.repositories;

import com.WorkWave.WorkWave.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
