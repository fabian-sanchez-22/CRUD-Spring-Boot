package com.sena.adso.teamnoche.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.adso.teamnoche.entity.Especialidad;
import com.sena.adso.teamnoche.services.EspecialidadService;

// 1
@RestController
@RequestMapping ("especialidades")
public class EspecialidadController {

	@Autowired
	private EspecialidadService service;
	
	@GetMapping
	public ResponseEntity<List<Especialidad>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	// http://localhost:9000/especialidades/1
	@GetMapping("{id}")
	public ResponseEntity <Optional<Especialidad>> getById(@PathVariable Long id){
		Optional<Especialidad> especialidad = service.getById(id);
		
		return ResponseEntity.ok(especialidad); 
	}
	
	//post y put pueden enviar datos a traves de la url o del cuerpo de la peticion
	@PostMapping
	public ResponseEntity<Especialidad> save (@RequestBody Especialidad especialidad){
		Especialidad especialidadDatabase = service.save(especialidad);
		return ResponseEntity.ok(especialidadDatabase);
	}
	
	//crear el actualizar y eliminar aqui en el controlador 
	// put y delete 
	// putmapping, pathvariable, id y nombre, se envian dos valores, uno por la url y otro por el body
	//id por ulr y nombre por body 
	
	
    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Especialidad especialidad) {
        service.update(id, especialidad);
        return ResponseEntity.ok("Registro actualizado");
    }
    
    //deletemapping
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Registro eliminado");
    }
	
}
