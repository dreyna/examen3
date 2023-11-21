package com.example.examen.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.examen.dto.GeneroDTO;
import com.example.examen.entity.Genero;



public interface GeneroService {
	Genero create(GeneroDTO genero);
	Genero update(Long id, GeneroDTO genero);
	Genero disableOneById(Long id);
	Optional<Genero> read(Long id);
	Page<Genero> readAll(Pageable pageable);
}
