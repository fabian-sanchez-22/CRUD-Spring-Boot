package com.sena.adso.teamnoche.interfaces;

import java.util.List;

import com.sena.adso.teamnoche.entity.Especialidad;

public interface IEspecialidadService {
	
	//Consultar todas las especialidades
List<Especialidad> getAll();

	//Consultar especialidad por ID
     Especialidad getById(Long id) throws Exception;

	//Guardar Especialidad
Especialidad save (Especialidad especialidad);

	//Actualizar un registri por id
void update (Long id, Especialidad especialidad) throws Exception;

	//Eliminar registro por id
void delete (Long id) throws Exception;
}

