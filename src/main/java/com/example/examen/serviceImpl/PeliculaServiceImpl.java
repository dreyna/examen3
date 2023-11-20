package com.example.examen.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen.entity.Pelicula;
import com.example.examen.repository.PeliculaRepository;
import com.example.examen.service.Operaciones;
@Service
public class PeliculaServiceImpl implements Operaciones<Pelicula>{
	@Autowired
	private PeliculaRepository peliculaRepository;

	@Override
	public Pelicula create(Pelicula t) {
		// TODO Auto-generated method stub
		return peliculaRepository.save(t);
	}

	@Override
	public Pelicula update(Pelicula t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Pelicula> read(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pelicula> reaAll() {
		// TODO Auto-generated method stub
		return peliculaRepository.findAll();
	}

}
