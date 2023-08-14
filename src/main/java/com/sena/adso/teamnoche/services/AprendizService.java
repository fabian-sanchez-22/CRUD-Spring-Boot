package com.sena.adso.teamnoche.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.adso.teamnoche.entity.Aprendiz;
import com.sena.adso.teamnoche.interfaces.IAprendizService;
import com.sena.adso.teamnoche.repository.AprendizRepository;

@Service
public class AprendizService implements IAprendizService {

	@Autowired
	private AprendizRepository repository;
	
	@Override
	public List<Aprendiz> getAll() {
		return repository.findAllCustom();
	}

	@Override
	public Optional<Aprendiz> getById(Long id) {
		return repository.findByIdCustom(id);
	}

	@Override
	public Aprendiz save(Aprendiz aprendiz) {
		aprendiz.setCreatedAt(LocalDateTime.now());
		return repository.save(aprendiz);
	}

	@Override
	public void update(Long id, Aprendiz aprendiz) {
		Optional<Aprendiz> aprendizO = repository.findById(id);
		if (aprendizO.isEmpty()) return;
		
		Aprendiz aprendizDatabase = aprendizO.get();
		aprendizDatabase.setNombres(aprendiz.getNombres());
		aprendizDatabase.setApellidos(aprendiz.getApellidos());
		aprendizDatabase.setGrado(aprendiz.getGrado());
		aprendizDatabase.setUpdatedAt(LocalDateTime.now());
		 
		repository.save(aprendizDatabase);
	}

	@Override
	public void delete(Long id) {
		Optional<Aprendiz> aprendizO = repository.findById(id);
		if(aprendizO.isEmpty()) return;
		
		Aprendiz aprendizDatabase = aprendizO.get();
		aprendizDatabase.setDeletedAt(LocalDateTime.now());
		
		repository.save(aprendizDatabase);
		
	}



}
