package com.sena.adso.teamnoche.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sena.adso.teamnoche.entity.Profesor;
import com.sena.adso.teamnoche.services.ProfesorService;

@RestController
@RequestMapping ("profesores")

public class ProfesorController {

	@Autowired
	private ProfesorService service;
	
	@GetMapping
	public ResponseEntity<List<Profesor>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Optional<Profesor>> getById(@PathVariable Long id){
		Optional<Profesor> profesor = service.getById(id);
		
		return ResponseEntity.ok(profesor);
	}
	
	@PostMapping
	public ResponseEntity<Profesor> save (@RequestBody Profesor profesor){
		Profesor profesorDatabase = service.save(profesor);
		return ResponseEntity.ok(profesorDatabase);
	}
	
	@PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Profesor profesor) {
        service.update(id, profesor);
        return ResponseEntity.ok("Registro actualizado");
    }
	
	@DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Registro eliminado");
    }
}
