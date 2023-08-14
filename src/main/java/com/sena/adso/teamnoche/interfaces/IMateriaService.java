package com.sena.adso.teamnoche.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.adso.teamnoche.entity.Materia;

public interface IMateriaService {
	
		List<Materia> getAll();
		
		Optional<Materia> getById(Long id);
		
		Materia save (Materia materia);
		
		void update (Long id, Materia materia);
		
		void delete (Long id);

}
