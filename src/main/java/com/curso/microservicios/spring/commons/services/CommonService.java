package com.curso.microservicios.spring.commons.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommonService<E> {

	public Iterable<E> findall();

	public Page<E> findall(Pageable pageable);

	public Optional<E> findbyId(Long id);

	public E save(E entity);

	public void deleteById(Long id);

}
