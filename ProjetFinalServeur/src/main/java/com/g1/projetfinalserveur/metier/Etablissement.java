package com.g1.projetfinalserveur.metier;

import java.util.Set;

import javax.persistence.DiscriminatorColumn;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "prototype")
@Component
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_ETABLISSEMENT")
public abstract class Etablissement extends User {
	@ManyToMany(mappedBy = "mesEtablissements", fetch = FetchType.LAZY)
	private Set<Fiche> mesFiches;

	public Set<Fiche> getMesFiches() {
		return mesFiches;
	}

	public void setMesFiches(Set<Fiche> mesFiches) {
		this.mesFiches = mesFiches;
	}

}
