package com.sena.adso.teamnoche.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.adso.teamnoche.entity.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {
@Query(value = "SELECT * FROM materias WHERE deleted_at IS NULL", nativeQuery = true)
List<Materia> findAllCustom();
}
