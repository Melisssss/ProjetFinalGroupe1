package com.g1.projetfinalserveur.metier;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Scope(value = "prototype")
@Component
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Famille {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idFamille;
	private String travail;
	private String telTravail;
	private String portable;
	private String nomResponsable;
	private String telResponsable;
	@JsonIgnore
	@OneToOne(mappedBy="maFamille",fetch = FetchType.LAZY)
	private Fiche maFiche;
	public long getIdFamille() {
		return idFamille;
	}
	public void setIdFamille(long idFamille) {
		this.idFamille = idFamille;
	}
	public String getTravail() {
		return travail;
	}
	public void setTravail(String travail) {
		this.travail = travail;
	}
	public String getTelTravail() {
		return telTravail;
	}
	public void setTelTravail(String telTravail) {
		this.telTravail = telTravail;
	}
	public String getPortable() {
		return portable;
	}
	public void setPortable(String portable) {
		this.portable = portable;
	}
	public String getNomResponsable() {
		return nomResponsable;
	}
	public void setNomResponsable(String nomResponsable) {
		this.nomResponsable = nomResponsable;
	}
	public String getTelResponsable() {
		return telResponsable;
	}
	public void setTelResponsable(String telResponsable) {
		this.telResponsable = telResponsable;
	}
	public Fiche getMaFiche() {
		return maFiche;
	}
	public void setMaFiche(Fiche maFiche) {
		this.maFiche = maFiche;
	}
	
}
