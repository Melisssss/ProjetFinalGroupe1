package com.g1.projetfinalserveur.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.g1.projetfinalserveur.metier.Enfant;




@Repository
public interface EnfantDao extends JpaRepository<Enfant, Long> {
	@Query("select e from Enfant e where e.monResponsable.idUser = :x")
	List<Enfant> findAllEnfantResponsable(@Param("x") long idUser);
}
