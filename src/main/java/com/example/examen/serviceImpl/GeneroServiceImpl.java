package com.example.examen.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen.entity.Genero;
import com.example.examen.repository.GeneroRepository;
import com.example.examen.service.Operaciones;
@Service
public class GeneroServiceImpl implements Operaciones<Genero>{
	@Autowired
	private GeneroRepository generoRepository;

	@Override
	public Genero create(Genero t) {
		// TODO Auto-generated method stub
		return generoRepository.save(t);
	}

	@Override
	public Genero update(Genero t) {
		// TODO Auto-generated method stub
		return generoRepository.save(t);
	}

	@Override
	public Optional<Genero> read(Long id) {
		// TODO Auto-generated method stub
		return generoRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		generoRepository.deleteById(id);
	}

	@Override
	public List<Genero> reaAll() {
		// TODO Auto-generated method stub
		return generoRepository.findAll();
	}

}
