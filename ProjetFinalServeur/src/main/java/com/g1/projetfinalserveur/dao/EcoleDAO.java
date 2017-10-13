package com.g1.projetfinalserveur.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g1.projetfinalserveur.metier.EtablissementEcole;
@Repository
public interface EcoleDAO extends JpaRepository<EtablissementEcole, Long>{

}
