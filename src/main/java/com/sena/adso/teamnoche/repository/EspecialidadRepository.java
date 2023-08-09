package com.sena.adso.teamnoche.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sena.adso.teamnoche.entity.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
	@Query(value= " SELECT * FROM especialidades WHERE deleted_at IS NULL", nativeQuery = true)
	List<Especialidad> findAllCustom();

}
