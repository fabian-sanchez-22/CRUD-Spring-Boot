package com.sena.adso.teamnoche.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.adso.teamnoche.dtos.ProfesorDatatableDto;
import com.sena.adso.teamnoche.entity.Profesor;
import com.sena.adso.teamnoche.interfaces.IProfesorService;
import com.sena.adso.teamnoche.repository.ProfesorRepository;

@Service
public class ProfesorService implements IProfesorService {

	@Autowired
	private ProfesorRepository repository;
	
	@Override
	public Page<ProfesorDatatableDto> getDatatable(Pageable pageable, String searchText){
		return repository.getDatatable(pageable, searchText);
	}
	
	@Override
	public List<Profesor> getAll() {
		return repository.findAllCustom();
	}

	@Override
	public Profesor getById(Long id) throws Exception {
		Optional<Profesor> profesorO = repository.findById(id);
		if(profesorO.isEmpty()) throw new Exception("el profesor no existe");
		return profesorO.get();
	}

	@Override
	public Profesor save(Profesor profesor) {
		profesor.setCreatedAt(LocalDateTime.now());
		return repository.save(profesor);
	}

	@Override
	public void update(Long id, Profesor profesor) throws Exception {
		Optional<Profesor> profesorO = repository.findByIdCustom(id);
		if(profesorO.isEmpty()) throw new Exception ("El profesor no existe");
		
		Profesor profesorDatabase = profesorO.get();
		profesorDatabase.setNombres(profesor.getNombres());
		profesorDatabase.setApellidos(profesor.getApellidos());
		profesorDatabase.setEspecialidad(profesor.getEspecialidad());
		profesorDatabase.setUpdatedAt(LocalDateTime.now());
		
		repository.save(profesorDatabase);
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<Profesor> profesorO = repository.findByIdCustom(id);
		if(profesorO.isEmpty()) return;
		
		Profesor profesorDatabase = profesorO.get();
		profesorDatabase.setDeletedAt(LocalDateTime.now());
		
		repository.save(profesorDatabase);
	}

}
