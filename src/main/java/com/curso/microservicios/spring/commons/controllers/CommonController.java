package com.curso.microservicios.spring.commons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.curso.microservicios.spring.commons.services.CommonService;

public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	protected S service;

	@GetMapping("/")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findall());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<E> optAlumno = service.findbyId(id);
		if (optAlumno.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optAlumno.get());
	}

	@PostMapping("/")
	public ResponseEntity<?> crear(@RequestBody E entity) {
		E entityDb = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
