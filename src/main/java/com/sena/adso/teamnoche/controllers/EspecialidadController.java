package com.sena.adso.teamnoche.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.adso.teamnoche.dtos.ApiResponseDto;
import com.sena.adso.teamnoche.dtos.EspecialidadDatatableDto;
import com.sena.adso.teamnoche.entity.Especialidad;
import com.sena.adso.teamnoche.services.EspecialidadService;

// 1
@RestController
@RequestMapping ("especialidades")
public class EspecialidadController {
	


	@Autowired
	private EspecialidadService service;
	
	
	@GetMapping("/datatable")
	public ResponseEntity<?>  datatable (@RequestParam(name = "page") Integer page,
										@RequestParam(name = "size") Integer size,
										@RequestParam(name = "column_order") String columnOrder,
										@RequestParam(name = "column_direction") String columnDirection,
										@RequestParam(name = "search", required = false) String search){
	
	try {
		List<Order> orders = new ArrayList<>();
		
		orders.add(new Order(columnDirection.equals("asc") ? Direction.ASC : Direction.DESC, columnOrder));
		
		Page<EspecialidadDatatableDto> data = service.getDatatable(PageRequest.of(page, size, Sort.by(orders)), search == null ? "" : search);
		return ResponseEntity.ok(data);
		
	} catch (Exception e) {
		return ResponseEntity.internalServerError().body(e.getMessage());
	}
	}
	

	
	@GetMapping
	public ResponseEntity<ApiResponseDto<List<Especialidad>>> getAll(){
		try {
			List<Especialidad> especialidades = service.getAll();
			return ResponseEntity.ok(new ApiResponseDto<List<Especialidad>>("OK", true, especialidades));
			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<List<Especialidad>>(e.getMessage(), false, null));
		}
		
	}
	
	
	// http://localhost:9000/especialidades/1
	@GetMapping("{id}")
	public ResponseEntity <?> getById(@PathVariable Long id){
		
		try {
			Especialidad especialidad = service.getById(id);
			return ResponseEntity.ok(especialidad); 
			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
		
	}
	
	//post y put pueden enviar datos a traves de la url o del cuerpo de la peticion
	@PostMapping
	public ResponseEntity<?> save (@RequestBody Especialidad especialidad){
		try {
			Especialidad especialidadDatabase = service.save(especialidad);
			return ResponseEntity.ok(especialidadDatabase);
			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
		
	}
	
	//crear el actualizar y eliminar aqui en el controlador 
	// put y delete 
	// putmapping, pathvariable, id y nombre, se envian dos valores, uno por la url y otro por el body
	//id por ulr y nombre por body 
	
	
    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Especialidad especialidad) {
    	try {
    		service.update(id, especialidad);
            return ResponseEntity.ok("Registro actualizado");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
        
    }
    
    //deletemapping
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
    	try {
    		service.delete(id);
            return ResponseEntity.ok("Registro eliminado");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
        
    }
	
}
