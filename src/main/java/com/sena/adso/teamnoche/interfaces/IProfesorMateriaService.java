package com.sena.adso.teamnoche.interfaces;

import java.util.List;
import java.util.Optional;
import com.sena.adso.teamnoche.entity.ProfesorMateria;

public interface IProfesorMateriaService  {

	List<ProfesorMateria> getAll();
	
	Optional<ProfesorMateria> getById(Long id);
	
	ProfesorMateria save (ProfesorMateria profesormateria);
	
	void update (Long id, ProfesorMateria profesormateria);
	
	void delete (Long id);
}
