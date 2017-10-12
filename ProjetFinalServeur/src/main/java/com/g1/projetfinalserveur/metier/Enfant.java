package com.g1.projetfinalserveur.metier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "prototype")
@Component
@Entity
public class Enfant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idEnfant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Responsable monResponsable;
	
	@OneToMany(mappedBy = "monEnfant", fetch = FetchType.LAZY)
	private List<Fiche> mesFiches;
}
