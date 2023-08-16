package com.sena.adso.teamnoche.interfaces;

import java.util.List;

import com.sena.adso.teamnoche.entity.Materia;

public interface IMateriaService {
	
		List<Materia> getAll();
		
		Materia getById(Long id) throws Exception;
		
		Materia save (Materia materia);
		
		void update (Long id, Materia materia) throws Exception;
		
		void delete (Long id) throws Exception;

}
