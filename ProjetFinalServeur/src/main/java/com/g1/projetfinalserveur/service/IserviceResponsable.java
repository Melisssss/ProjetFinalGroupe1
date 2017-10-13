package com.g1.projetfinalserveur.service;

import java.util.List;

import com.g1.projetfinalserveur.metier.Enfant;
import com.g1.projetfinalserveur.metier.FicheImage;
import com.g1.projetfinalserveur.metier.FicheMedical;
import com.g1.projetfinalserveur.metier.FichePrincipale;
import com.g1.projetfinalserveur.metier.FicheVaccin;
import com.g1.projetfinalserveur.metier.Mere;
import com.g1.projetfinalserveur.metier.Pere;
import com.g1.projetfinalserveur.metier.Responsable;

public interface IserviceResponsable {
	
	//POUR LES RESPONSABLES
	public void createResponsable (Responsable r);
	public List<Responsable> findResponsables();
	public  void deleteResponsable(Responsable r);
	public Responsable updateResponsable(Responsable r);
	public Responsable getResponsable(long idResponsable);
	
	//POUR LES EnFANTS
	public void createEnfant(Enfant e);
	public List<Enfant> findAllEnfantResponsable(long idUser);
	public void deleteEnfant(Enfant e);
	public Enfant updateEnfant(Enfant e);
	public Enfant getEnfant(long idEnfant);

	
	//FichePrincipale 
	public void createFichePrincipale(FichePrincipale fp);
	public List<FichePrincipale> findAllFichePrincipaleEnfant(long idEnfant);
	public void deleteFichePrincipale(FichePrincipale fp);	
	public FichePrincipale updateFichePrincipale(FichePrincipale fp);
	public FichePrincipale getFichePrincipale(long idFichePrincipal);

	  
	//FicheMedical 
	public void createFicheMedical(FicheMedical fm);	  
	public List<FicheMedical> findAllFicheMedicalEnfant(long idEnfant);	  
	public void deleteFicheMedical(FicheMedical fm);	 
	public FicheMedical updateFicheMedical(FicheMedical fm);
	public FicheMedical getFicheMedical(long idFicheMedical);

	  
	//FicheVaccin 
	public void createFicheVaccin(FicheVaccin fv);
	public List<FicheVaccin> findAllFicheVaccinEnfant(long idEnfant);	  
	public void deleteFicheVaccin(FicheVaccin fv);
	public FicheVaccin updateFicheVaccin(FicheVaccin fv);
	public FicheVaccin getFicheVaccin(long idFicheVaccin);
	  
	  
	//FicheImage
	public void createFicheImage(FicheImage fi);	 
	public List<FicheImage> findAllFicheImageEnfant(long idEnfant);
	public void deleteFicheImage(FicheImage fi);
	public FicheImage updateFicheImage(FicheImage fi);
	public FicheImage getFicheImage(long idFicheImage);
	
	//PERE
	public void createPere(Pere p);	 
	public void deletePere(Pere p);
	public Pere updatePere(Pere p);
	public Pere getPere(long idPere);
	
	//Mere
	public void createMere(Mere m);	 
	public void deleteMere(Mere m);
	public Mere updateMere(Mere m);
	public Mere getMere(long idMere);
	
}
