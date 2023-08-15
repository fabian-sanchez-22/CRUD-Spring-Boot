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

import com.sena.adso.teamnoche.entity.ProfesorMateriaGrado;
import com.sena.adso.teamnoche.services.ProfesorMateriaGradoService;

@RestController
@RequestMapping ("profesores_materias_grados")
public class ProfesorMateriaGradoController {
	
	@Autowired
	private ProfesorMateriaGradoService service;
	
	@GetMapping
	public ResponseEntity<List<ProfesorMateriaGrado>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Optional<ProfesorMateriaGrado>> getById(@PathVariable Long id){
		Optional<ProfesorMateriaGrado> profesormateriagrado = service.getById(id);
		
		return ResponseEntity.ok(profesormateriagrado);
	}
	
	@PostMapping
	public ResponseEntity<ProfesorMateriaGrado> save (@RequestBody ProfesorMateriaGrado profesormateriagrado){
		ProfesorMateriaGrado profesormateriagradoDatabase = service.save(profesormateriagrado);
		
		return ResponseEntity.ok(profesormateriagradoDatabase);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<String> update (@PathVariable Long id, @RequestBody ProfesorMateriaGrado profesormateriagrado){
		service.update(id, profesormateriagrado);
		
		return ResponseEntity.ok("Registro actualizado");
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete (@PathVariable Long id){
		service.delete(id);
		
		return ResponseEntity.ok("Registro eliminado");
	}
	

}
