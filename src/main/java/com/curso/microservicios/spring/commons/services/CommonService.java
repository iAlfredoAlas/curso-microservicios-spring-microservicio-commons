package com.curso.microservicios.spring.commons.services;

import java.util.Optional;


public interface CommonService<E> {

	public Iterable<E> findall();
	
	public Optional<E> findbyId(Long id);
	
	public E save(E entity);
	
	public void deleteById(Long id);
	
}
