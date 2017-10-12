package com.g1.projetfinalserveur.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value="prototype")
@Component
@Entity
@DiscriminatorValue(value = "ETABLISSEMENT")
public class Etablissement extends User {
	@ManyToMany(mappedBy = "mesEtablissements", fetch = FetchType.LAZY)
	private Set<Fiche> mesFiches = new HashSet<Fiche>();
}
