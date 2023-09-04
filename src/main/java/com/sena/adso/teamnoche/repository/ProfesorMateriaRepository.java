package com.sena.adso.teamnoche.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.adso.teamnoche.dtos.ProfesorMateriaDatatableDto;
import com.sena.adso.teamnoche.entity.ProfesorMateria;

@Repository
public interface ProfesorMateriaRepository extends JpaRepository<ProfesorMateria, Long> {

	@Query(value = "SELECT id, materia_id, profesor_id FROM profesores_materias WHERE id LIKE CONCAT('%', :searchText, '%')", nativeQuery = true)
	Page<ProfesorMateriaDatatableDto> getDatatable(Pageable pageable, String searchText);
	
	@Query(value = "SELECT * FROM profesores_materias", nativeQuery = true)
	List<ProfesorMateria> findAllCustom();
	
	@Query(value = "SELECT * FROM profesores_materias WHERE id = ?1", nativeQuery = true)
	Optional<ProfesorMateria> findByIdCustom(Long id);
}
