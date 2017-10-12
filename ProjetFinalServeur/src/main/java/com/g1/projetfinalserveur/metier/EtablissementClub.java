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
@DiscriminatorColumn(name = "TYPE_ETABLISSEMENT")
public class EtablissementClub extends Etablissement{
	private String nomclub;

	public String getNomclub() {
		return nomclub;
	}

	public void setNomclub(String nomclub) {
		this.nomclub = nomclub;
	}
	
}
