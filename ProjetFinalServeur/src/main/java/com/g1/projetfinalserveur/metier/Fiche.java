package com.g1.projetfinalserveur.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value="prototype")
@Component
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Fiche {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long idFiche;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Enfant monEnfant;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Etablissement> mesEtablissement = new HashSet<Etablissement>();
}
