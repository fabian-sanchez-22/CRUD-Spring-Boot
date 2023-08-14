package com.sena.adso.teamnoche.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.adso.teamnoche.entity.Profesor;
import com.sena.adso.teamnoche.interfaces.IProfesorService;
import com.sena.adso.teamnoche.repository.ProfesorRepository;

@Service
public class ProfesorService implements IProfesorService {

	@Autowired
	private ProfesorRepository repository;
	
	@Override
	public List<Profesor> getAll() {
		return repository.findAllCustom();
	}

	@Override
	public Optional<Profesor> getById(Long id) {
		return repository.findByIdCustom(id);
	}

	@Override
	public Profesor save(Profesor profesor) {
		profesor.setCreatedAt(LocalDateTime.now());
		return repository.save(profesor);
	}

	@Override
	public void update(Long id, Profesor profesor) {
		Optional<Profesor> profesorO = repository.findById(id);
		if(profesorO.isEmpty()) return;
		
		Profesor profesorDatabase = profesorO.get();
		profesorDatabase.setNombres(profesor.getNombres());
		profesorDatabase.setApellidos(profesor.getApellidos());
		profesorDatabase.setEspecialidad(profesor.getEspecialidad());
		profesorDatabase.setUpdatedAt(LocalDateTime.now());
		
		repository.save(profesorDatabase);
	}

	@Override
	public void delete(Long id) {
		Optional<Profesor> profesorO = repository.findById(id);
		if(profesorO.isEmpty()) return;
		
		Profesor profesorDatabase = profesorO.get();
		profesorDatabase.setDeletedAt(LocalDateTime.now());
		
		repository.save(profesorDatabase);
	}

}
