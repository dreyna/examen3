package com.example.examen.serviceImpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.examen.dto.PeliculaDTO;
import com.example.examen.entity.Genero;
import com.example.examen.entity.Pelicula;
import com.example.examen.exception.ObjectNotFoundException;
import com.example.examen.repository.PeliculaRepository;
import com.example.examen.service.PeliculaService;
@Service
public class PeliculaServiceImpl implements PeliculaService{
	@Autowired
	private PeliculaRepository peliculaRepository;

	@Override
	public Pelicula create(PeliculaDTO pelicula) {
		// TODO Auto-generated method stub
		Pelicula p = new Pelicula();
		p.setNombre(pelicula.getNombre());
		p.setDescripcion(pelicula.getDescripcion());
		p.setStatus(Pelicula.PeliculaStatus.ENABLE);
		Genero gg = new Genero();
		gg.setId(pelicula.getIdgenero());
		
		p.setGenero(gg);
		
		return peliculaRepository.save(p);
	}

	@Override
	public Optional<Pelicula> read(Long id) {
		// TODO Auto-generated method stub
		return peliculaRepository.findById(id);
	}

	
	@Override
	public Pelicula update(Long id, PeliculaDTO peliculaDTO) {
		// TODO Auto-generated method stub
		Pelicula pUpdate = peliculaRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("Pelicula not Foud with id: "+id));
		pUpdate.setNombre(peliculaDTO.getNombre());
		pUpdate.setDescripcion(peliculaDTO.getDescripcion());		
		return peliculaRepository.save(pUpdate);
	}

	@Override
	public Page<Pelicula> readAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return peliculaRepository.findAll(pageable);
	}

	@Override
	public Pelicula disableOneById(Long id) {
		// TODO Auto-generated method stub
				Pelicula p = peliculaRepository.findById(id)
						.orElseThrow(()->new ObjectNotFoundException("Pelicula not Foud with id: "+id));
				p.setStatus(Pelicula.PeliculaStatus.DISABLE);
				return peliculaRepository.save(p);
	}




}
