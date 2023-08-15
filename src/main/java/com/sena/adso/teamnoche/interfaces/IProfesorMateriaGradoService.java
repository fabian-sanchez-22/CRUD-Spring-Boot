package com.sena.adso.teamnoche.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.adso.teamnoche.entity.ProfesorMateriaGrado;

public interface IProfesorMateriaGradoService {
	
	List<ProfesorMateriaGrado> getAll();
	
	Optional<ProfesorMateriaGrado> getById(Long id);
	
	ProfesorMateriaGrado save (ProfesorMateriaGrado profesormateriagrado);
	
	void update (Long id, ProfesorMateriaGrado profesormateriagrado);
	
	void delete (Long id);

}
