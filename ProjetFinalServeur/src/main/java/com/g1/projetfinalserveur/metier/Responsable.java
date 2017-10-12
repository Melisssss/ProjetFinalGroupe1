package com.g1.projetfinalserveur.metier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Scope(value="prototype")
@Component
@Entity
@DiscriminatorValue(value = "RESPONSABLE")
public class Responsable extends User {
	@OneToMany(mappedBy="monResponsable",fetch=FetchType.LAZY)
	private Set<Enfant> mesEnfants = new HashSet<Enfant>();
}
