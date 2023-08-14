package com.sena.adso.teamnoche.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sena.adso.teamnoche.entity.ProfesorMateria;

@Repository
public interface ProfesorMateriaRepository extends JpaRepository<ProfesorMateria, Long> {

	@Query(value = "SELECT * FROM profesores_materias WHERE deleted_at IS NULL", nativeQuery = true)
	List<ProfesorMateria> findAllCustom();
	
	@Query(value = "SELECT * FROM profesores_materias WHERE id = ?1 AND deleted_at IS NULL", nativeQuery = true)
	Optional<ProfesorMateria> findByIdCustom(Long id);
}
