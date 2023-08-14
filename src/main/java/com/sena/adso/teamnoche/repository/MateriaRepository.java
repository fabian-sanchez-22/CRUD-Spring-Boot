package com.sena.adso.teamnoche.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.adso.teamnoche.entity.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {
	
@Query(value = "SELECT * FROM materias WHERE deleted_at IS NULL", nativeQuery = true)
List<Materia> findAllCustom();

@Query(value = "SELECT * FROM materias WHERE id = ?1 AND deleted_at IS NULL", nativeQuery = true)
Optional<Materia> findByIdCustom(Long id);

}
