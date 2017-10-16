package com.g1.projetfinalserveur.service;

import java.util.List;
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

public interface IserviceEtablissement {
	
		//POUR LES ClubS
		public EtablissementClub createClub (EtablissementClub ec);
		public List<EtablissementClub> findClubs();
		public void deleteClub(EtablissementClub ec);
		public EtablissementClub updateClub(EtablissementClub ec);
		public EtablissementClub getClub(long idClub);
		
		//POUR LES Ecole
		public EtablissementEcole createEcole (EtablissementEcole ee);
		public List<EtablissementEcole> findEcoles();
		public void deleteEcole(EtablissementEcole ee);
		public EtablissementEcole updateEcole(EtablissementEcole ee);
		public EtablissementEcole getEcole(long idEcole);
		
		//POUR LES Centre Loisir
		public EtablissementCentreLoisir createCentreLoisirs (EtablissementCentreLoisir ecl);
		public List<EtablissementCentreLoisir> findCentreLoisirs();
		public void deleteCentreLoisirs(EtablissementCentreLoisir ecl);
		public EtablissementCentreLoisir updateCentreLoisirs(EtablissementCentreLoisir ecl);
		public EtablissementCentreLoisir getCentreLoisirs(long idCentreLoisir);
		
//		//Connexion
//
//		public void createConnexion(Connexion c);	 
//		public void deleteConnexion(Connexion c);
//		public Connexion updateConnexion(Connexion c);
//		public Connexion getConnexion(long idConnexion);
//		public Connexion findMaConnexion(String login,String mdp);
//		public Object findObjectConnexion(String login,String mdp);
//		public Etablissement connexionEtablissement(String login,String mdp);	
		// Demande
		
		public void createDemande(Demande d);
		public void deleteDemande(Demande d);
		public Demande updateDemande(Demande d);
		public Demande getDemande(long idDemande);
		public List<Demande> findAllDemandeEtablissement(long idEtablissement);
		
		//Method ManyToMany
	
		public List<Enfant> findAllEnfantEtablissement(long idEtablissement);
		public List<FicheImage> findAllFicheImageEtablissement(long idEtablissement);
		public List<FicheMedical> findAllFicheMedicalEtablissement(long idEtablissement);
		public List<FichePrincipale> findAllFichePrincipaleEtablissement(long idEtablissement);
		public List<FicheVaccin> findAllFicheVaccinEtablissement(long idEtablissement);	
		
		public Object getFiche (long idFiche);
		public Object getEtablissement (long idEtablissement);
		public List<Enfant> findAllEnfant();
		public List<Fiche> findAllFicheEnfant(long idEnfant);
		public List<Fiche> findAllFicheEtablissement(long idEtablissement);
}
