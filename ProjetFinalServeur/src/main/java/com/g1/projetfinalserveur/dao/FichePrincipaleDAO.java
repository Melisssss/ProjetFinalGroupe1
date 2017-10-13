package com.g1.projetfinalserveur.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.g1.projetfinalserveur.metier.FichePrincipale;

@Repository
public interface FichePrincipaleDAO extends JpaRepository<FichePrincipale, Long>{
	@Query("SELECT fp FROM FichePrincipale fp WHERE fp.monEnfant.idEnfant = :x")
	List<FichePrincipale> findAllFichePrincipaleEnfant(@Param("x") long idEnfant);
}
