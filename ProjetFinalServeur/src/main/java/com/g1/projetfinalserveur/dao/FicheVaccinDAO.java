package com.g1.projetfinalserveur.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g1.projetfinalserveur.metier.FicheVaccin;

public interface FicheVaccinDAO extends JpaRepository<FicheVaccin, Long>{

}
