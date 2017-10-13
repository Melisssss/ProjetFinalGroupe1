package com.g1.projetfinalserveur.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g1.projetfinalserveur.metier.FicheMedical;

public interface FicheMedicalDAO extends JpaRepository<FicheMedical, Long>{

}
