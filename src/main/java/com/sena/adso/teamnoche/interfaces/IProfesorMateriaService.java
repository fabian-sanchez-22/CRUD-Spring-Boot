package com.sena.adso.teamnoche.interfaces;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.adso.teamnoche.dtos.ProfesorMateriaDatatableDto;
import com.sena.adso.teamnoche.entity.ProfesorMateria;

public interface IProfesorMateriaService  {
	
	Page<ProfesorMateriaDatatableDto> getDatatable(Pageable pageable, String searchText);

	List<ProfesorMateria> getAll();
	
	ProfesorMateria getById(Long id) throws Exception;
	
	ProfesorMateria save (ProfesorMateria profesormateria);
	
	void update (Long id, ProfesorMateria profesormateria) throws Exception;
	
	void delete (Long id) throws Exception;
}
