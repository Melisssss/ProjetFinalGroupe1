package com.g1.projetfinalserveur.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.g1.projetfinalserveur.metier.Connexion;
import com.g1.projetfinalserveur.metier.Responsable;

@Repository
public interface ConnexionDAO extends JpaRepository<Connexion, Long> {
	@Query("SELECT c FROM Connexion c where c.login like :x and c.mdp like :y")
	public Connexion findMaConnexion(@Param("x") String login,@Param("y") String mdp);
	
	@Query("SELECT r FROM Responsable r where r.maConnexion.login like :x and r.maConnexion.mdp like :y")
	public Responsable findResponsable(@Param("x") String login,@Param("y") String mdp);
}
