package com.example.examen.serviceImpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.examen.dto.GeneroDTO;
import com.example.examen.entity.Genero;
import com.example.examen.entity.Pelicula;
import com.example.examen.exception.ObjectNotFoundException;
import com.example.examen.repository.GeneroRepository;
import com.example.examen.service.GeneroService;
@Service
public class GeneroServiceImpl implements GeneroService{
	@Autowired
	private GeneroRepository generoRepository;

	@Override
	public Genero create(GeneroDTO genero) {
		// TODO Auto-generated method stub
		Genero g = new Genero();
		g.setNombre(genero.getNombre());
		g.setStatus(Genero.GeneroStatus.ENABLE);
		return generoRepository.save(g);
	}

	@Override
	public Genero update(Long id, GeneroDTO genero) {
		// TODO Auto-generated method stub
		Genero gUpdate = generoRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("Genero not Foud with id: "+id));
		gUpdate.setNombre(genero.getNombre());
		return generoRepository.save(gUpdate);
	}

	@Override
	public Genero disableOneById(Long id) {
		// TODO Auto-generated method stub
		Genero g = generoRepository.findById(id)
				.orElseThrow(()->new ObjectNotFoundException("Genero not Foud with id: "+id));
		g.setStatus(Genero.GeneroStatus.DISABLE);
		return generoRepository.save(g);
	}

	@Override
	public Optional<Genero> read(Long id) {
		// TODO Auto-generated method stub
		return generoRepository.findById(id);
	}

	@Override
	public Page<Genero> readAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return generoRepository.findAll(pageable);
	}

	

}
