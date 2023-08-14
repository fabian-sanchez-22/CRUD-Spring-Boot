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

import com.sena.adso.teamnoche.entity.Aprendiz;
import com.sena.adso.teamnoche.services.AprendizService;

@RestController
@RequestMapping("aprendices")
public class AprendizController {

	@Autowired
	private AprendizService service;
	
	@GetMapping
	public ResponseEntity<List<Aprendiz>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Optional<Aprendiz>> getById(@PathVariable Long id){
		Optional<Aprendiz> aprendiz = service.getById(id);
		
		return ResponseEntity.ok(aprendiz);
	}
	
	@PostMapping
	public ResponseEntity<Aprendiz> save (@RequestBody Aprendiz aprendiz){
		Aprendiz aprendizDatabase = service.save(aprendiz);
		return ResponseEntity.ok(aprendizDatabase);
	}
	
	@PutMapping("{id}")
	    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Aprendiz aprendiz) {
	        service.update(id, aprendiz);
	        return ResponseEntity.ok("Registro actualizado");
	    }
	   
	@DeleteMapping("{id}")
	    public ResponseEntity<String> delete(@PathVariable Long id) {
	        service.delete(id);
	        return ResponseEntity.ok("Registro eliminado");
	    }
}
