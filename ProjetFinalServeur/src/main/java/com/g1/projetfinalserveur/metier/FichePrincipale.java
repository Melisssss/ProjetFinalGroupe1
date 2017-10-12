package com.g1.projetfinalserveur.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value="prototype")
@Component
@Entity
@DiscriminatorValue(value = "FICHE_PRINCIPALE")
public class FichePrincipale extends Fiche{
	private String adresse;
	private String codePostal;
	private String ville;
	private String portableMere;
	private String portablePere;
	private String telMaison;
	private String telTravailMere;
	private String telTravailPere;
	private String nomResponsable1;
	private String telResponsable1;
	private String nomResponsable2;
	private String telResponsable2;
	private String email;
	private String travailPere;
	private String travailMere;
	private String regimeCantine;
	private String statutGarderie;
	private String statutEtude;
	private String statutSortie;
	private String transport;
		
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
	public String getPortableMere() {
		return portableMere;
	}
	public void setPortableMere(String portableMere) {
		this.portableMere = portableMere;
	}
	public String getPortablePere() {
		return portablePere;
	}
	public void setPortablePere(String portablePere) {
		this.portablePere = portablePere;
	}
	public String getTelMaison() {
		return telMaison;
	}
	public void setTelMaison(String telMaison) {
		this.telMaison = telMaison;
	}
	public String getTelTravailMere() {
		return telTravailMere;
	}
	public void setTelTravailMere(String telTravailMere) {
		this.telTravailMere = telTravailMere;
	}
	public String getTelTravailPere() {
		return telTravailPere;
	}
	public void setTelTravailPere(String telTravailPere) {
		this.telTravailPere = telTravailPere;
	}
	public String getNomResponsable1() {
		return nomResponsable1;
	}
	public void setNomResponsable1(String nomResponsable1) {
		this.nomResponsable1 = nomResponsable1;
	}
	public String getTelResponsable1() {
		return telResponsable1;
	}
	public void setTelResponsable1(String telResponsable1) {
		this.telResponsable1 = telResponsable1;
	}
	public String getNomResponsable2() {
		return nomResponsable2;
	}
	public void setNomResponsable2(String nomResponsable2) {
		this.nomResponsable2 = nomResponsable2;
	}
	public String getTelResponsable2() {
		return telResponsable2;
	}
	public void setTelResponsable2(String telResponsable2) {
		this.telResponsable2 = telResponsable2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTravailPere() {
		return travailPere;
	}
	public void setTravailPere(String travailPere) {
		this.travailPere = travailPere;
	}
	public String getTravailMere() {
		return travailMere;
	}
	public void setTravailMere(String travailMere) {
		this.travailMere = travailMere;
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
	
	
	
}
