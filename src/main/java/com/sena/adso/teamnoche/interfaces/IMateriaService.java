package com.sena.adso.teamnoche.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.adso.teamnoche.dtos.MateriaDatatableDto;
import com.sena.adso.teamnoche.entity.Materia;

public interface IMateriaService {
	
		Page<MateriaDatatableDto> getDatatable(Pageable pageable, String searchText);
	
		List<Materia> getAll();
		
		Materia getById(Long id) throws Exception;
		
		Materia save (Materia materia);
		
		void update (Long id, Materia materia) throws Exception;
		
		void delete (Long id) throws Exception;

}
