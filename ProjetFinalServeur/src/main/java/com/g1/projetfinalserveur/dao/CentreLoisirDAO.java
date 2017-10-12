package com.g1.projetfinalserveur.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g1.projetfinalserveur.metier.EtablissementCentreLoisir;

public interface CentreLoisirDAO extends JpaRepository<EtablissementCentreLoisir, Long>{

}
