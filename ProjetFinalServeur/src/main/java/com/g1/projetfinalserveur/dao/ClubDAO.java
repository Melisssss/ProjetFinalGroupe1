package com.g1.projetfinalserveur.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g1.projetfinalserveur.metier.EtablissementClub;

public interface ClubDAO extends JpaRepository<EtablissementClub, Long>{

}
