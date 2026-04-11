package com.github.rnf.evento.repositories;

import com.github.rnf.evento.domain.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade, Integer> { }
