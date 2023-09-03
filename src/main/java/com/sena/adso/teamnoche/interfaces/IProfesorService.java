package com.sena.adso.teamnoche.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.adso.teamnoche.dtos.ProfesorDatatableDto;
import com.sena.adso.teamnoche.entity.Profesor;

public interface IProfesorService {
	
	Page<ProfesorDatatableDto> getDatatable(Pageable pageable, String searchText);

	List<Profesor> getAll();
	
	Profesor getById(Long id) throws Exception;
	
	Profesor save (Profesor profesor);
	
	void update (Long id, Profesor profesor) throws Exception;
	
	void delete (Long id) throws Exception;
	
}
