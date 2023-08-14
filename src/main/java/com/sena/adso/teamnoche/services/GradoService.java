package com.sena.adso.teamnoche.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.adso.teamnoche.entity.Grado;
import com.sena.adso.teamnoche.interfaces.IGradoService;
import com.sena.adso.teamnoche.repository.GradoRepository;

@Service
public class GradoService implements IGradoService {

	@Autowired
	private GradoRepository repository;
	
	@Override
	public List<Grado> getAll() {
		return repository.findAllCustom() ;
	}

	@Override
	public Optional<Grado> getById(Long id) {
		return repository.findByIdCustom(id);
	}

	@Override
	public Grado save(Grado grado) {
		grado.setCreatedAt(LocalDateTime.now());
		return repository.save(grado);
	}

	@Override
	public void update(Long id, Grado grado) {
		Optional<Grado> gradoO = repository.findById(id);
		if (gradoO.isEmpty()) return;
		
		Grado gradoDatabase = gradoO.get();
		gradoDatabase.setNombre(grado.getNombre());
		gradoDatabase.setJornada(grado.getJornada());
		gradoDatabase.setSalon(grado.getSalon());
		gradoDatabase.setUpdatedAt(LocalDateTime.now());
		
		repository.save(gradoDatabase);
	}

	@Override
	public void delete(Long id) {

		Optional<Grado> gradoO = repository.findById(id);
		if(gradoO.isEmpty()) return;
		
		
	Grado gradoDatabase = gradoO.get();
	gradoDatabase.setDeletedAt(LocalDateTime.now());
	
	repository.save(gradoDatabase);
	}

}
