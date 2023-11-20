package com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
