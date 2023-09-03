package com.sena.adso.teamnoche.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.adso.teamnoche.dtos.GradoDatatableDto;
import com.sena.adso.teamnoche.entity.Grado;

public interface IGradoService {
	
	Page<GradoDatatableDto> getDatatable(Pageable pageable, String searchText);

	List<Grado> getAll();
	
	Grado getById(Long id) throws Exception;
	
	Grado save (Grado grado);
	
	void update (Long id, Grado grado) throws Exception;
	
	void delete (Long id) throws Exception;
}
