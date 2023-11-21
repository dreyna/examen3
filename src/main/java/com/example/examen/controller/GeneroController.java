package com.example.examen.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.examen.dto.GeneroDTO;
import com.example.examen.entity.Genero;
import com.example.examen.service.GeneroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/generos")
public class GeneroController {
	@Autowired
	private GeneroService generoService;
	
	@GetMapping
	public ResponseEntity<Page<Genero>> listar(Pageable pageable){
			Page<Genero> generos = generoService.readAll(pageable);
			if(generos.hasContent()) {
				return ResponseEntity.ok(generos);
			}
			return ResponseEntity.notFound().build();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Genero> buscar(@PathVariable("id") Long id){
		Optional<Genero> getGenero = generoService.read(id);
		if(getGenero.isPresent()) {
			return new ResponseEntity<Genero>(getGenero.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Genero> guardar(@Valid @RequestBody GeneroDTO generoDTO){
			Genero gen = generoService.create(generoDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(gen);				
	}
	@PutMapping("/{id}")
	public ResponseEntity<Genero> update(@PathVariable("id") Long id, @Valid @RequestBody GeneroDTO generoDTO){
		Genero gene = generoService.update(id, generoDTO);		
		return ResponseEntity.ok(gene);		
	}

	@PutMapping("/{id}/disable")
	public ResponseEntity<Genero> diseble(@PathVariable("id") Long id){
		Genero gg = generoService.disableOneById(id);
		return ResponseEntity.ok(gg);
	}

}
