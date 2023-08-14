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

import com.sena.adso.teamnoche.entity.Grado;
import com.sena.adso.teamnoche.services.GradoService;

@RestController
@RequestMapping ("grados")

public class GradoController {

	@Autowired
	private GradoService service;
	
	@GetMapping
	public ResponseEntity<List<Grado>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Optional<Grado>> getById(@PathVariable Long id){
		Optional<Grado> grado = service.getById(id);
		
		return ResponseEntity.ok(grado);
	}
	
	@PostMapping
	public ResponseEntity<Grado> save (@RequestBody Grado grado){
		Grado gradoDatabase = service.save(grado);
		return ResponseEntity.ok(gradoDatabase);
	}
	
	@PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Grado grado) {
        service.update(id, grado);
        return ResponseEntity.ok("Registro actualizado");
    }
	
	@DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Registro eliminado");
    }
}
