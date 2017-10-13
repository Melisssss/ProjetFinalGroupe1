package com.g1.projetfinalserveur.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.g1.projetfinalserveur.metier.FicheVaccin;

public interface FicheVaccinDAO extends JpaRepository<FicheVaccin, Long>{
	@Query("SELECT fv FROM FicheVaccin fv WHERE fv.monEnfant.idEnfant = :x")
	List<FicheVaccin> findAllFicheVaccinEnfant(@Param("x") long idEnfant);
}
