package com.g1.projetfinalserveur.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "prototype")
@Component
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Etablissement extends User {
	
	@ManyToMany(mappedBy = "mesEtablissementsFiche", fetch = FetchType.EAGER)
	private Set<Fiche> mesFiches;
	
	@ManyToMany(fetch = FetchType.EAGER,mappedBy = "mesEtablissementsEnfant")
	private Set<Enfant> mesEnfants;
	
	
	public Set<Enfant> getMesEnfants() {
		return mesEnfants;
	}

	public void setMesEnfants(Set<Enfant> mesEnfants) {
		this.mesEnfants = mesEnfants;
	}

	public Set<Fiche> getMesFiches() {
		return mesFiches;
	}

	public void setMesFiches(Set<Fiche> mesFiches) {
		this.mesFiches = mesFiches;
	}

}
