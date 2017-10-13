package com.g1.projetfinalserveur.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "prototype")
@Component
@Entity
@DiscriminatorValue(value = "FICHE_PRINCIPALE")
public class FichePrincipale extends Fiche {
	private String adresse;
	private String codePostal;
	private String ville;
	private String telMaison;
	private String email;
	private String regimeCantine;
	private String statutGarderie;
	private String statutEtude;
	private String statutSortie;
	private String transport;
	private boolean pension;
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTelMaison() {
		return telMaison;
	}
	public void setTelMaison(String telMaison) {
		this.telMaison = telMaison;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegimeCantine() {
		return regimeCantine;
	}
	public void setRegimeCantine(String regimeCantine) {
		this.regimeCantine = regimeCantine;
	}
	public String getStatutGarderie() {
		return statutGarderie;
	}
	public void setStatutGarderie(String statutGarderie) {
		this.statutGarderie = statutGarderie;
	}
	public String getStatutEtude() {
		return statutEtude;
	}
	public void setStatutEtude(String statutEtude) {
		this.statutEtude = statutEtude;
	}
	public String getStatutSortie() {
		return statutSortie;
	}
	public void setStatutSortie(String statutSortie) {
		this.statutSortie = statutSortie;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public boolean isPension() {
		return pension;
	}
	public void setPension(boolean pension) {
		this.pension = pension;
	}


	
	
}
