package com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
