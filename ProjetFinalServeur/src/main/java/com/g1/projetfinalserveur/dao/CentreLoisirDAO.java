package com.g1.projetfinalserveur.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.g1.projetfinalserveur.metier.EtablissementCentreLoisir;
@Repository
public interface CentreLoisirDAO extends JpaRepository<EtablissementCentreLoisir, Long>{
	@Query("select distinct cl from EtablissementCentreLoisir cl join cl.mesFiches f where f.idFiche = :x")
	public  List<EtablissementCentreLoisir> findAllCentreLoisirFiche(@Param("x") long idFiche);
	
	@Query( "select distinct cl from EtablissementCentreLoisir cl join cl.mesEnfants e where e.idEnfant = :x" )
	public  List<EtablissementCentreLoisir> findAllCentreLoisirEnfant(@Param("x") long idEnfant);
}
//
////Method ManyToMany
//public List<EtablissementCentreLoisir> findAllCentreLoisirFiche(long idFiche);
//public List<EtablissementEcole> findAllEcoleFiche(long idFiche);
//public List<EtablissementClub> findAllClubFiche(long idFiche);
//
//public List<EtablissementCentreLoisir> findAllCentreLoisirEnfant(long idEnfant);
//public List<EtablissementClub> findAllClubEnfant(long idEnfant);
//public List<EtablissementEcole> findAllEcoleEnfant(long idEnfant);
//
