package com.sena.adso.teamnoche.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.adso.teamnoche.entity.Materia;
import com.sena.adso.teamnoche.interfaces.IMateriaService;
import com.sena.adso.teamnoche.repository.MateriaRepository;

@Service
public class MateriaService implements IMateriaService {
	
	@Autowired
	private MateriaRepository repository;

	@Override
	public List<Materia> getAll() {
		return repository.findAllCustom() ;
	}

	@Override
	public Optional<Materia> getById(Long id) {
		return repository.findByIdCustom(id);
	}

	@Override
	public Materia save(Materia materia) {
		materia.setCreatedAt(LocalDateTime.now());
		return repository.save(materia);
	}

	@Override
	public void update(Long id, Materia materia) {
		Optional<Materia> materiaO = repository.findById(id);
		if (materiaO.isEmpty()) return;
		
		Materia materiaDatabase = materiaO.get();
		materiaDatabase.setNombre(materia.getNombre());
		materiaDatabase.setUpdatedAt(LocalDateTime.now());
		
		repository.save(materiaDatabase);
	}

	@Override
	public void delete(Long id) {
		Optional<Materia> materiaO = repository.findById(id);
		if (materiaO.isEmpty()) return;
		
		Materia materiaDatabase = materiaO.get();
		materiaDatabase.setDeletedAt(LocalDateTime.now());
		
		repository.save(materiaDatabase);
		
	}

	
	
}
