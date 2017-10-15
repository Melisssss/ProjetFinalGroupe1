package com.g1.projetfinalserveur.service;

import java.util.List;

import com.g1.projetfinalserveur.metier.Connexion;
import com.g1.projetfinalserveur.metier.Enfant;
import com.g1.projetfinalserveur.metier.EtablissementCentreLoisir;
import com.g1.projetfinalserveur.metier.EtablissementClub;
import com.g1.projetfinalserveur.metier.EtablissementEcole;
import com.g1.projetfinalserveur.metier.Famille;
import com.g1.projetfinalserveur.metier.FicheImage;
import com.g1.projetfinalserveur.metier.FicheMedical;
import com.g1.projetfinalserveur.metier.FichePrincipale;
import com.g1.projetfinalserveur.metier.FicheVaccin;
import com.g1.projetfinalserveur.metier.Mere;
import com.g1.projetfinalserveur.metier.Pere;
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
	
	//PERE
	public Pere createPere(Pere p);	 
	public void deletePere(Pere p);
	public Pere updatePere(Pere p);
	public Pere getPere(long idPere);
	
	//Mere
	public Mere createMere(Mere m);	 
	public void deleteMere(Mere m);
	public Mere updateMere(Mere m);
	public Mere getMere(long idMere);
	
	//Famille
	
	public void createFamille(Famille f);	 
	public void deleteFamille(Famille f);
	public Famille updateFamille(Famille f);
	public Famille getFamille(long idFamille);
	
	//Connexion
	public void createConnexion(Connexion c);	 
	public void deleteConnexion(Connexion c);
	public Connexion updateConnexion(Connexion c);
	public Connexion getConnexion(long idConnexion);
	public Connexion findMaConnexion(String login,String mdp);
	public Object findObjectConnexion(String login,String mdp);
	public Responsable findResponsable(String login,String mdp);
	
	//Method ManyToMany
	
	public List<EtablissementCentreLoisir> findAllCentreLoisirFiche(long idFiche);
	public List<EtablissementEcole> findAllEcoleFiche(long idFiche);
	public List<EtablissementClub> findAllClubFiche(long idFiche);

	public List<EtablissementCentreLoisir> findAllCentreLoisirEnfant(long idEnfant);
	public List<EtablissementClub> findAllClubEnfant(long idEnfant);
	public List<EtablissementEcole> findAllEcoleEnfant(long idEnfant);
}
