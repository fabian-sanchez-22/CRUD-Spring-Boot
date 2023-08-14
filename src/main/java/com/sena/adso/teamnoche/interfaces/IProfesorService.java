package com.sena.adso.teamnoche.interfaces;

import java.util.List;
import java.util.Optional;
import com.sena.adso.teamnoche.entity.Profesor;

public interface IProfesorService {

	List<Profesor> getAll();
	
	Optional<Profesor> getById(Long id);
	
	Profesor save (Profesor profesor);
	
	void update (Long id, Profesor profesor);
	
	void delete (Long id);
	
}
