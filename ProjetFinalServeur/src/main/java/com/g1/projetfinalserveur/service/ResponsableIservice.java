package com.g1.projetfinalserveur.service;
import java.util.List;
import com.g1.projetfinalserveur.metier.Enfant;
import com.g1.projetfinalserveur.metier.Responsable;

public interface ResponsableIservice {

	// Responsable
	public void createResponsable(Responsable r);

	public Responsable getResponsable(long idUser);

	public Responsable updateResponsable(Responsable r);

	// Enfant

	public void createEnfant(Enfant e);

	public void deleteEnfant(long idEnfant);

	public Enfant getEnfant(long idEnfant);

	public Enfant updateEnfant(Enfant e);

	public List<Enfant> findAllEnfantResponsable(long idUser);

	/*
	 * //FichePrincipale public void createFichePrincipale(FichePrincipale f);
	 * 
	 * public void deleteFichePrincipale(long idFiche);
	 * 
	 * public FichePrincipale getFichePrincipale(long idFiche);
	 * 
	 * public FichePrincipale updateFichePrincipale(FichePrincipale f);
	 * 
	 * public List<FichePrincipale> findAllFichePrincipaleEnfant(long idEnfant);
	 * 
	 * //FicheMedical public void createFicheMedical(FicheMedical e);
	 * 
	 * public void deleteFicheMedical(long idFiche);
	 * 
	 * public FicheMedical getFicheMedical(long idFiche);
	 * 
	 * public FicheMedical updateFicheMedical(FicheMedical f);
	 * 
	 * public List<FicheMedical> findAllFicheMedicalEnfant(long idEnfant);
	 * 
	 * //FicheVaccin public void createFicheVaccin(FicheVaccin f);
	 * 
	 * public void deleteFicheVaccin(long idFiche);
	 * 
	 * public FicheVaccin getFicheVaccin(long idFiche);
	 * 
	 * public FicheVaccin updateFicheVaccin(FicheVaccin f);
	 * 
	 * public List<FicheVaccin> findAllFicheVaccinEnfant(long idEnfant);
	 * 
	 * //FicheImage public void createFicheImage(FicheImage f);
	 * 
	 * public void deleteFicheImage(long idFiche);
	 * 
	 * public FicheImage getFicheImage(long idFiche);
	 * 
	 * public FicheImage updateFicheImage(FicheImage f);
	 * 
	 * public List<FicheImage> findAllFicheImageEnfant(long idEnfant);
	 */
}
