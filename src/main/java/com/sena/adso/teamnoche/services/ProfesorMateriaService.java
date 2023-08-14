package com.sena.adso.teamnoche.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.adso.teamnoche.entity.ProfesorMateria;
import com.sena.adso.teamnoche.interfaces.IProfesorMateriaService;
import com.sena.adso.teamnoche.repository.ProfesorMateriaRepository;

@Service
public class ProfesorMateriaService implements IProfesorMateriaService {

	@Autowired
	private ProfesorMateriaRepository repository;
	
	@Override
	public List<ProfesorMateria> getAll() {
		return repository.findAllCustom();
	}

	@Override
	public Optional<ProfesorMateria> getById(Long id) {
		return repository.findByIdCustom(id);
	}

	@Override
	public ProfesorMateria save(ProfesorMateria profesormateria) {
		return repository.save(profesormateria);
	}

	@Override
	public void update(Long id, ProfesorMateria profesormateria) {
		Optional<ProfesorMateria> profesormateriaO = repository.findById(id);
		if(profesormateriaO.isEmpty()) return;
		
		ProfesorMateria profesormateriaDatabase = profesormateriaO.get();
		profesormateriaDatabase.setMateria(profesormateria.getMateria());
		profesormateriaDatabase.setProfesor(profesormateria.getProfesor());
		
		repository.save(profesormateriaDatabase);	
	}

	@Override
	public void delete(Long id) {
		Optional<ProfesorMateria> profesormateriaO = repository.findById(id);
		if(profesormateriaO.isEmpty()) return;
		
		ProfesorMateria profesormateriaDatabase = profesormateriaO.get();
		
		repository.delete(profesormateriaDatabase);
	}

}
