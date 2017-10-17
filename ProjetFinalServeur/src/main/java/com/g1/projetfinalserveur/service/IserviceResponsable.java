package com.g1.projetfinalserveur.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.g1.projetfinalserveur.metier.Connexion;
import com.g1.projetfinalserveur.metier.Demande;
import com.g1.projetfinalserveur.metier.Enfant;
import com.g1.projetfinalserveur.metier.Etablissement;
import com.g1.projetfinalserveur.metier.EtablissementCentreLoisir;
import com.g1.projetfinalserveur.metier.EtablissementClub;
import com.g1.projetfinalserveur.metier.EtablissementEcole;
import com.g1.projetfinalserveur.metier.Fiche;
import com.g1.projetfinalserveur.metier.FicheImage;
import com.g1.projetfinalserveur.metier.FicheMedical;
import com.g1.projetfinalserveur.metier.FichePrincipale;
import com.g1.projetfinalserveur.metier.FicheVaccin;

import com.g1.projetfinalserveur.metier.Responsable;

public interface IserviceResponsable {
	
	//POUR LES RESPONSABLES
	public Responsable createResponsable (Responsable r);
	public List<Responsable> findResponsables();
	public  void deleteResponsable(Responsable r);
	public Responsable updateResponsable(Responsable r);
	public Responsable getResponsable(long idResponsable);
	
	//POUR LES EnFANTS
	public Enfant createEnfant(Enfant e);
	public List<Enfant> findEnfants ();
	public List<Enfant> findAllEnfantResponsable(long idUser);
	public void deleteEnfant(Enfant e);
	public Enfant updateEnfant(Enfant e);
	public Enfant getEnfant(long idEnfant);

	
	//FichePrincipale 
	public FichePrincipale createFichePrincipale(FichePrincipale fp);
	public List<FichePrincipale> findFichePrincipales();
	public List<FichePrincipale> findAllFichePrincipaleEnfant(long idEnfant);
	public void deleteFichePrincipale(FichePrincipale fp);	
	public FichePrincipale updateFichePrincipale(FichePrincipale fp);
	public FichePrincipale getFichePrincipale(long idFichePrincipal);
	
	  
	//FicheMedical 
	public FicheMedical createFicheMedical(FicheMedical fm);	
	public List<FicheMedical> findFicheMedicals();
	public List<FicheMedical> findAllFicheMedicalEnfant(long idEnfant);	  
	public void deleteFicheMedical(FicheMedical fm);	 
	public FicheMedical updateFicheMedical(FicheMedical fm);
	public FicheMedical getFicheMedical(long idFicheMedical);

	  
	//FicheVaccin 
	public FicheVaccin createFicheVaccin(FicheVaccin fv);
	public List<FicheVaccin> findFicheVaccins();
	public List<FicheVaccin> findAllFicheVaccinEnfant(long idEnfant);	  
	public void deleteFicheVaccin(FicheVaccin fv);
	public FicheVaccin updateFicheVaccin(FicheVaccin fv);
	public FicheVaccin getFicheVaccin(long idFicheVaccin);
	  
	  
	//FicheImage
	public FicheImage createFicheImage(FicheImage fi);	 
	public List<FicheImage> findFicheImages();
	public List<FicheImage> findAllFicheImageEnfant(long idEnfant);
	public void deleteFicheImage(FicheImage fi);
	public FicheImage updateFicheImage(FicheImage fi);
	public FicheImage getFicheImage(long idFicheImage);
		
	//Connexion
	
	public void createConnexion(Connexion c);	 
	public void deleteConnexion(Connexion c);
	public Connexion updateConnexion(Connexion c);
	public Connexion getConnexion(long idConnexion);
	public Connexion findMaConnexion(String login,String mdp);
	public Object findObjectConnexion(String login,String mdp);
	public Responsable findResponsable(@Param("x") String login,@Param("y") String mdp);
	
//	
	//Demande
	
	public List<Demande> findAllDemandeFiche(long idFiche);
	
	//Method ManyToMany
	
	public List<EtablissementCentreLoisir> findAllCentreLoisirFiche(long idFiche);
	public List<EtablissementEcole> findAllEcoleFiche(long idFiche);
	public List<EtablissementClub> findAllClubFiche(long idFiche);

	public List<EtablissementCentreLoisir> findAllCentreLoisirEnfant(long idEnfant);
	public List<EtablissementClub> findAllClubEnfant(long idEnfant);
	public List<EtablissementEcole> findAllEcoleEnfant(long idEnfant);
	
	
	public Object getFiche (long idFiche);
	public Object getEtablissement (long idEtablissement);
	public List<Fiche> findAllFicheEnfant(long idEnfant);
	
	public List<Etablissement> findAllEtablissementFiche(long idFiche);
}
