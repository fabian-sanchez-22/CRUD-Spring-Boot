package com.sena.adso.teamnoche.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.adso.teamnoche.entity.Aprendiz;

public interface IAprendizService {

	List<Aprendiz> getAll();
	
	Optional<Aprendiz> getById(Long id);
	
	Aprendiz save (Aprendiz aprendiz);
	
	void update (Long id, Aprendiz aprendiz );
	
	void delete (Long id);
}
