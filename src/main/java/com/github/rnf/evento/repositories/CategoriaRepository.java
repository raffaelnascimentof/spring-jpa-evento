package com.github.rnf.evento.repositories;

import com.github.rnf.evento.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> { }
