package com.sena.adso.teamnoche.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.adso.teamnoche.dtos.AprendizDatatableDto;
import com.sena.adso.teamnoche.entity.Aprendiz;

@Repository
public interface AprendizRepository extends JpaRepository<Aprendiz, Long> {

	@Query(value = "SELECT id, nombres, apellidos FROM aprendices WHERE nombres LIKE CONCAT('%', :searchText, '%')", nativeQuery = true)
	Page<AprendizDatatableDto> getDatatable(Pageable pageable, String searchText);
	
	@Query(value = "SELECT * FROM aprendices WHERE deleted_at IS NULL", nativeQuery = true)
	List<Aprendiz> findAllCustom();
	
	@Query(value = "SELECT * FROM aprendices WHERE id = ?1 AND deleted_at IS NULL", nativeQuery = true)
	Optional<Aprendiz> findByIdCustom(Long id);
	
}
