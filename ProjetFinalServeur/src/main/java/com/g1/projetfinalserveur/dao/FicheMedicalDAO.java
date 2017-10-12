package com.g1.projetfinalserveur.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.g1.projetfinalserveur.metier.FicheMedical;


public interface FicheMedicalDao extends JpaRepository<FicheMedical, Long>{
	@Query("select f from FicheMedical f where f.monEnfant.idEnfant = :x")
	List<FicheMedical> findAllFIcheMedicalEnfant(@Param("x") long idEnfant);
}
