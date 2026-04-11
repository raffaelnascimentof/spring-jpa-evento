package com.github.rnf.evento.repositories;

import com.github.rnf.evento.domain.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participante, Integer> { }
