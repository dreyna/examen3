package com.example.examen.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.dto.PeliculaDTO;
import com.example.examen.entity.Pelicula;
import com.example.examen.service.PeliculaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping
	public ResponseEntity<Page<Pelicula>> listar(Pageable pageable){
		Page<Pelicula> generoPage = peliculaService.readAll(pageable);
		if(generoPage.hasContent()) {
			return ResponseEntity.ok(generoPage);
		}
		return ResponseEntity.notFound().build();
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Pelicula> buscar(@PathVariable("id") Long id){
		Optional<Pelicula> getPelicula = peliculaService.read(id);
		if(getPelicula.isPresent()) {
			return ResponseEntity.ok(getPelicula.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Pelicula> guardar(@Valid @RequestBody PeliculaDTO generoDTO){
		Pelicula gen = peliculaService.create(generoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(gen);		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Pelicula> update(@PathVariable("id") Long id, @Valid @RequestBody PeliculaDTO peliculaDTO){
		Pelicula pelicula = peliculaService.update(id, peliculaDTO);		
		return ResponseEntity.ok(pelicula);		
	}

	@PutMapping("/{id}/disable")
	public ResponseEntity<Pelicula> delete(@PathVariable("id") Long id){
		Pelicula pp = peliculaService.disableOneById(id);
		return ResponseEntity.ok(pp);
	}

}
