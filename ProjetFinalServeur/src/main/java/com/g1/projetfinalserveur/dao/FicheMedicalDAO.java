package com.g1.projetfinalserveur.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.g1.projetfinalserveur.metier.FicheMedical;

public interface FicheMedicalDAO extends JpaRepository<FicheMedical, Long>{
	@Query("SELECT fm FROM FicheMedical fm WHERE fm.monEnfant.idEnfant = :x")
	List<FicheMedical> findAllFicheMedicalEnfant(@Param("x") long idEnfant);
}
