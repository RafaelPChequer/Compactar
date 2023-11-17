package com.WorkWave.WorkWave.repositories;

import com.WorkWave.WorkWave.models.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

}
