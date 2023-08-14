package com.sena.adso.teamnoche.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sena.adso.teamnoche.entity.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
	
	@Query(value = "SELECT * FROM profesores WHERE deleted_at IS NULL", nativeQuery = true)
	List<Profesor> findAllCustom();

	@Query(value = "SELECT * FROM profesores WHERE id = ?1 AND deleted_at IS NULL", nativeQuery = true)
	Optional<Profesor> findByIdCustom(Long id);

}
