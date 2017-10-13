package com.g1.projetfinalserveur.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.g1.projetfinalserveur.metier.FicheImage;

public interface FicheImageDAO extends JpaRepository<FicheImage, Long> {
	@Query("select f from FicheImage f where f.monEnfant.idEnfant = :x")
	List<FicheImage> findAllFicheImageEnfant(@Param("x") long idEnfant);
}
