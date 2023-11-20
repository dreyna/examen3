package com.example.examen.service;

import java.util.List;
import java.util.Optional;

public interface Operaciones<T> {

	T create(T t);
	T update(T t);
	Optional<T> read(Long id);
	void delete(Long id);
	List<T> reaAll();
}
