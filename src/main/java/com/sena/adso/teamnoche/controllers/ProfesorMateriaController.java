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

import com.sena.adso.teamnoche.entity.ProfesorMateria;
import com.sena.adso.teamnoche.services.ProfesorMateriaService;

@RestController
@RequestMapping ("profesores_materias")
public class ProfesorMateriaController {

	@Autowired
	private ProfesorMateriaService service;
	
	@GetMapping
	public ResponseEntity<List<ProfesorMateria>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Optional<ProfesorMateria>> getById(@PathVariable Long id){
		Optional<ProfesorMateria> profesormateria = service.getById(id);
		
		return ResponseEntity.ok(profesormateria);
	}
	
	
	@PostMapping
	public ResponseEntity<ProfesorMateria> save (@RequestBody ProfesorMateria profesormateria){
		ProfesorMateria profesormateriaDatabase = service.save(profesormateria);
		return ResponseEntity.ok(profesormateriaDatabase);
	}
	
	@PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody ProfesorMateria profesormateria) {
        service.update(id, profesormateria);
        return ResponseEntity.ok("Registro actualizado");
    }
	
	@DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Registro eliminado");
    }
}
