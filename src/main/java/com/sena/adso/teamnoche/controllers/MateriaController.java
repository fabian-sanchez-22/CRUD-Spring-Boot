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

import com.sena.adso.teamnoche.entity.Especialidad;
import com.sena.adso.teamnoche.entity.Materia;
import com.sena.adso.teamnoche.services.MateriaService;

@RestController
@RequestMapping ("materias")

public class MateriaController {

	@Autowired
	private MateriaService service;
	
	@GetMapping
	public ResponseEntity<List<Materia>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Optional<Materia>> getById(@PathVariable Long id){
		Optional<Materia> materia = service.getById(id);
		
		return ResponseEntity.ok(materia);
	}
	
	@PostMapping
	public ResponseEntity<Materia> save (@RequestBody Materia materia){
		Materia materiaDatabase = service.save(materia);
		return ResponseEntity.ok(materiaDatabase);
	}
	
	@PutMapping("{id}")
	    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Materia materia) {
	        service.update(id, materia);
	        return ResponseEntity.ok("Registro actualizado");
	    }
	   
	@DeleteMapping("{id}")
	    public ResponseEntity<String> delete(@PathVariable Long id) {
	        service.delete(id);
	        return ResponseEntity.ok("Registro eliminado");
	    }
	    
}
