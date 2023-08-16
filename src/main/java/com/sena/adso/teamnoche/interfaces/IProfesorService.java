package com.sena.adso.teamnoche.interfaces;

import java.util.List;
import com.sena.adso.teamnoche.entity.Profesor;

public interface IProfesorService {

	List<Profesor> getAll();
	
	Profesor getById(Long id) throws Exception;
	
	Profesor save (Profesor profesor);
	
	void update (Long id, Profesor profesor) throws Exception;
	
	void delete (Long id) throws Exception;
	
}
