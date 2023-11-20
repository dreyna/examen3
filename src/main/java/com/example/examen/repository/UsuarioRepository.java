package com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
