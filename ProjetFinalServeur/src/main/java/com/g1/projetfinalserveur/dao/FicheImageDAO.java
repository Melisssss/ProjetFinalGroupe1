package com.g1.projetfinalserveur.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g1.projetfinalserveur.metier.FicheImage;

public interface FicheImageDAO extends JpaRepository<FicheImage, Long>{

}
