package com.g1.projetfinalserveur.metier;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "prototype")
@Component
@Entity
@DiscriminatorValue(value = "CLUB")
public class EtablissementClub extends Etablissement{
	private String nomClub;

	public String getNomClub() {
		return nomClub;
	}

	public void setNomClub(String nomClub) {
		this.nomClub = nomClub;
	}
}
