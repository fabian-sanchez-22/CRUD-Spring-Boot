package com.sena.adso.teamnoche.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.adso.teamnoche.entity.ProfesorMateriaGrado;

@Repository
public interface ProfesorMateriaGradoRepository  extends JpaRepository<ProfesorMateriaGrado, Long> {

	@Query(value = "SELECT * FROM profesores_materias_grados", nativeQuery = true)
	List<ProfesorMateriaGrado> findAllCustom();
	
	@Query(value = "SELECT * FROM profesores_materias_grados WHERE id = ?1", nativeQuery = true)
	Optional<ProfesorMateriaGrado> findByIdCustom(Long id);
	
}
