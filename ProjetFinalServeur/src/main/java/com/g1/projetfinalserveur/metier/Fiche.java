package com.g1.projetfinalserveur.metier;

import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "prototype")
@Component
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_FICHE")
public abstract class Fiche {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idFiche;

	@ManyToOne(fetch = FetchType.LAZY)
	private Enfant monEnfant;

	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Etablissement> mesEtablissements;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Famille maFamille;
	
	
	public Famille getMaFamille() {
		return maFamille;
	}

	public void setMaFamille(Famille maFamille) {
		this.maFamille = maFamille;
	}

	public long getIdFiche() {
		return idFiche;
	}

	public void setIdFiche(long idFiche) {
		this.idFiche = idFiche;
	}

	public Enfant getMonEnfant() {
		return monEnfant;
	}

	public void setMonEnfant(Enfant monEnfant) {
		this.monEnfant = monEnfant;
	}

	public Set<Etablissement> getMesEtablissements() {
		return mesEtablissements;
	}

	public void setMesEtablissements(Set<Etablissement> mesEtablissements) {
		this.mesEtablissements = mesEtablissements;
	}

}
