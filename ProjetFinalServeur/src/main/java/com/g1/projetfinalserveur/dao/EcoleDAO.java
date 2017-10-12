package com.g1.projetfinalserveur.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g1.projetfinalserveur.metier.EtablissementEcole;

public interface EcoleDAO extends JpaRepository<EtablissementEcole, Long>{

}
