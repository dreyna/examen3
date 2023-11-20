package com.example.examen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.entity.Genero;
import com.example.examen.serviceImpl.GeneroServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/generos")
public class GeneroController {
	@Autowired
	private GeneroServiceImpl generoServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<Genero>> listar(){
		try {
			List<Genero> generos = generoServiceImpl.reaAll();
			if(generos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(generos, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Genero> buscar(@PathVariable("id") Long id){
		Optional<Genero> getGenero = generoServiceImpl.read(id);
		if(getGenero.isPresent()) {
			return new ResponseEntity<Genero>(getGenero.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Genero> guardar(@Valid @RequestBody Genero genero){
		try {
			Genero gen = generoServiceImpl.create(genero);
			return new ResponseEntity<Genero>(gen, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Genero> update(@PathVariable("id") Long id, @Valid @RequestBody Genero genero){
		Optional<Genero> genData = generoServiceImpl.read(id);		
		if(genData.isPresent()) {
			Genero gen = genData.get();
			gen.setNombre(genero.getNombre());
			return new ResponseEntity<Genero>(generoServiceImpl.update(gen), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
@DeleteMapping("/{id}")
public ResponseEntity<Genero> delete(@PathVariable("id") Long id){
	try {
		generoServiceImpl.delete(id);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

}
