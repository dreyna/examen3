package com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examen.entity.Genero;
@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long>{

}
