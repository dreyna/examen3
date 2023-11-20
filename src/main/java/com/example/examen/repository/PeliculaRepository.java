package com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.entity.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{

}
