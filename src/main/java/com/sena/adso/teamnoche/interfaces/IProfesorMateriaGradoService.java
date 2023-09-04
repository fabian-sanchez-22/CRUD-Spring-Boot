package com.sena.adso.teamnoche.interfaces;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.adso.teamnoche.dtos.ProfesorMateriaGradoDatatableDto;
import com.sena.adso.teamnoche.entity.ProfesorMateriaGrado;

public interface IProfesorMateriaGradoService {
	
	Page<ProfesorMateriaGradoDatatableDto> getDatatable(Pageable pageable, String searchText);
	
	List<ProfesorMateriaGrado> getAll();
	
	ProfesorMateriaGrado getById(Long id) throws Exception;
	
	ProfesorMateriaGrado save (ProfesorMateriaGrado profesormateriagrado);
	
	void update (Long id, ProfesorMateriaGrado profesormateriagrado) throws Exception;
	
	void delete (Long id) throws Exception;

}
