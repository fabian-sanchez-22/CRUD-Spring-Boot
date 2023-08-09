package com.sena.adso.teamnoche.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.adso.teamnoche.entity.Especialidad;

public interface IEspecialidadService {
	
	//Consultar todas las especialidades
List<Especialidad> getAll();

	//Consultar especialidad por ID
Optional<Especialidad> getById(Long id);

	//Guardar Especialidad
Especialidad save (Especialidad especialidad);

	//Actualizar un registri por id
void update (Long id, Especialidad especialidad);

	//Eliminar registro por id
void delete (Long id);
}

