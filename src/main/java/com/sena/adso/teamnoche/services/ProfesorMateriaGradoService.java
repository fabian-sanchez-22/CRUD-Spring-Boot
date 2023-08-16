package com.sena.adso.teamnoche.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.adso.teamnoche.entity.ProfesorMateriaGrado;
import com.sena.adso.teamnoche.interfaces.IProfesorMateriaGradoService;
import com.sena.adso.teamnoche.repository.ProfesorMateriaGradoRepository;

@Service
public class ProfesorMateriaGradoService implements IProfesorMateriaGradoService {

	@Autowired
	private ProfesorMateriaGradoRepository repository;
	
	@Override
	public List<ProfesorMateriaGrado> getAll() {
		return repository.findAllCustom();
	}

	@Override
	public Optional<ProfesorMateriaGrado> getById(Long id) {
		return repository.findByIdCustom(id);
	}

	@Override
	public ProfesorMateriaGrado save(ProfesorMateriaGrado profesormateriagrado) {
		return repository.save(profesormateriagrado);
	}

	@Override
	public void update(Long id, ProfesorMateriaGrado profesormateriagrado) {
		Optional<ProfesorMateriaGrado> profesormateriagradoO = repository.findByIdCustom(id);
		if(profesormateriagradoO.isEmpty()) return;
		
		ProfesorMateriaGrado profesormateriagradoDatabase = profesormateriagradoO.get();
		profesormateriagradoDatabase.setGrado(profesormateriagrado.getGrado());
		profesormateriagradoDatabase.setProfesor(profesormateriagrado.getProfesor());
		
		repository.save(profesormateriagradoDatabase);
		
	}

	@Override
	public void delete(Long id) {
		Optional<ProfesorMateriaGrado> profesormateriagradoO = repository.findById(id);
		if(profesormateriagradoO.isEmpty()) return;
		
		ProfesorMateriaGrado profesormateriagradoDatabase = profesormateriagradoO.get();
		repository.delete(profesormateriagradoDatabase);
	}

}
