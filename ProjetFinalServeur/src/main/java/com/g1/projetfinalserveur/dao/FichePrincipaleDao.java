package com.g1.projetfinalserveur.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.g1.projetfinalserveur.metier.FichePrincipale;

public interface FichePrincipaleDAO extends JpaRepository<FichePrincipale, Long> {
	@Query("select f from FichePrincipale f where f.monEnfant.idEnfant = :x")
	List<FichePrincipale> findAllFichePrincipaleEnfant(@Param("x") long idEnfant);
}
