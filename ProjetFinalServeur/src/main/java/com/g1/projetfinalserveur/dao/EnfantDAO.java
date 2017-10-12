package com.g1.projetfinalserveur.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g1.projetfinalserveur.metier.Enfant;

public interface EnfantDAO extends JpaRepository<Enfant, Long>{

}
