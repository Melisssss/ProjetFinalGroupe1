package com.g1.projetfinalserveur.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g1.projetfinalserveur.metier.Pere;

@Repository
public interface PereDAO extends JpaRepository<Pere, Long>{

}
