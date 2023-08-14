package com.sena.adso.teamnoche.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.adso.teamnoche.entity.Grado;

public interface IGradoService {

	List<Grado> getAll();
	
	Optional<Grado> getById(Long id);
	
	Grado save (Grado grado);
	
	void update (Long id, Grado grado);
	
	void delete (Long id);
}
