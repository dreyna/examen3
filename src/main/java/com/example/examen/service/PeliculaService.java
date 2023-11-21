package com.example.examen.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.examen.dto.PeliculaDTO;
import com.example.examen.entity.Pelicula;

public interface PeliculaService {
	Pelicula create(PeliculaDTO pelicula);
	Pelicula update(Long id, PeliculaDTO pelicula);
	Pelicula disableOneById(Long id);
	Optional<Pelicula> read(Long id);
	Page<Pelicula> readAll(Pageable pageable);
}
