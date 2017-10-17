package com.g1.projetfinalserveur.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Scope(value = "prototype")
@Component
@Entity
public class Enfant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idEnfant;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Responsable monResponsable;

	@JsonIgnore
	@OneToMany(mappedBy = "monEnfant", fetch = FetchType.LAZY)
	private Set<Fiche> mesFiches;

	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "enfant_user", joinColumns = @JoinColumn(name = "mesEnfants_idEnfant", referencedColumnName = "idEnfant"), inverseJoinColumns = @JoinColumn(name = "mesEtablissementsEnfant_idUser", referencedColumnName ="idUser"))
	private Set<Etablissement> mesEtablissementsEnfant;

	private String nom;
	private String prenom;
	private String dateDeNaissance;

	public Set<Etablissement> getMesEtablissementsEnfant() {
		return mesEtablissementsEnfant;
	}

	public void setMesEtablissementsEnfant(Set<Etablissement> mesEtablissementsEnfant) {
		this.mesEtablissementsEnfant = mesEtablissementsEnfant;
	}

	public long getIdEnfant() {
		return idEnfant;
	}

	public void setIdEnfant(long idEnfant) {
		this.idEnfant = idEnfant;
	}

	public Responsable getMonResponsable() {
		return monResponsable;
	}

	public void setMonResponsable(Responsable monResponsable) {
		this.monResponsable = monResponsable;
	}

	public Set<Fiche> getMesFiches() {
		return mesFiches;
	}

	public void setMesFiches(Set<Fiche> mesFiches) {
		this.mesFiches = mesFiches;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
}
