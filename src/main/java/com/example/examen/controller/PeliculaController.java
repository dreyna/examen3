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

import com.example.examen.entity.Pelicula;
import com.example.examen.serviceImpl.PeliculaServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
	@Autowired
	private PeliculaServiceImpl peliculaServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<Pelicula>> listar(){
		try {
			List<Pelicula> peliculas = peliculaServiceImpl.reaAll();
			if(peliculas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(peliculas, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Pelicula> buscar(@PathVariable("id") Long id){
		Optional<Pelicula> getGenero = peliculaServiceImpl.read(id);
		if(getGenero.isPresent()) {
			return new ResponseEntity<Pelicula>(getGenero.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Pelicula> guardar(@Valid @RequestBody Pelicula genero){
		try {
			Pelicula gen = peliculaServiceImpl.create(genero);
			return new ResponseEntity<Pelicula>(gen, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Pelicula> update(@PathVariable("id") Long id, @Valid @RequestBody Pelicula pelicula){
		Optional<Pelicula> genData = peliculaServiceImpl.read(id);		
		if(genData.isPresent()) {
			Pelicula gen = genData.get();
			gen.setNombre(pelicula.getNombre());
			return new ResponseEntity<>(peliculaServiceImpl.update(gen), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
@DeleteMapping("/{id}")
public ResponseEntity<Pelicula> delete(@PathVariable("id") Long id){
	try {
		peliculaServiceImpl.delete(id);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

}
