package com.sena.adso.teamnoche.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.adso.teamnoche.dtos.AprendizDatatableDto;
import com.sena.adso.teamnoche.entity.Aprendiz;

public interface IAprendizService {
	
	Page<AprendizDatatableDto> getDatatable(Pageable pageable, String searchText);

	List<Aprendiz> getAll();
	
	Aprendiz getById(Long id) throws Exception;
	
	Aprendiz save (Aprendiz aprendiz);
	
	void update (Long id, Aprendiz aprendiz) throws Exception;
	
	void delete (Long id) throws Exception;
	
}
