package com.g1.projetfinalserveur.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Scope(value="prototype")
@Component
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long idUser;
	@NotEmpty
	private String login;
	@NotEmpty
	private String mdp;
	@NotEmpty
	private String nom;
	@NotEmpty
	private String adresse;
	@NotEmpty
	private String codePostal;
	@NotEmpty
	private String ville;	
}
