package com.sena.adso.teamnoche.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.adso.teamnoche.dtos.ProfesorMateriaGradoDatatableDto;
import com.sena.adso.teamnoche.entity.ProfesorMateriaGrado;
import com.sena.adso.teamnoche.interfaces.IProfesorMateriaGradoService;
import com.sena.adso.teamnoche.repository.ProfesorMateriaGradoRepository;

@Service
public class ProfesorMateriaGradoService implements IProfesorMateriaGradoService {

	@Autowired
	private ProfesorMateriaGradoRepository repository;
	
	@Override
	public Page<ProfesorMateriaGradoDatatableDto> getDatatable(Pageable pageable, String searchText){
	return repository.getDatatable(pageable, searchText);
	}
	
	@Override
	public List<ProfesorMateriaGrado> getAll() {
		return repository.findAllCustom();
	}

	@Override
	public ProfesorMateriaGrado getById(Long id) throws Exception {
		Optional<ProfesorMateriaGrado> proMaGradoO = repository.findById(id);
		if (proMaGradoO.isEmpty()) throw new Exception("No existe.");
		return proMaGradoO.get();
		}

	@Override
	public ProfesorMateriaGrado save(ProfesorMateriaGrado profesormateriagrado) {
		return repository.save(profesormateriagrado);
	}

	@Override
	public void update(Long id, ProfesorMateriaGrado profesormateriagrado) throws Exception {
		Optional<ProfesorMateriaGrado> profesormateriagradoO = repository.findByIdCustom(id);
		if(profesormateriagradoO.isEmpty()) throw new Exception ("No existe.");
		
		ProfesorMateriaGrado profesormateriagradoDatabase = profesormateriagradoO.get();
		profesormateriagradoDatabase.setGrado(profesormateriagrado.getGrado());
		profesormateriagradoDatabase.setProfesor(profesormateriagrado.getProfesor());
		
		repository.save(profesormateriagradoDatabase);
		
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<ProfesorMateriaGrado> profesormateriagradoO = repository.findById(id);
		if(profesormateriagradoO.isEmpty()) return;
		
		ProfesorMateriaGrado profesormateriagradoDatabase = profesormateriagradoO.get();
		repository.delete(profesormateriagradoDatabase);
	}

}
