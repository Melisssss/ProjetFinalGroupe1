package com.g1.projetfinalserveur.service;

import java.util.List;

import com.g1.projetfinalserveur.metier.EtablissementCentreLoisir;
import com.g1.projetfinalserveur.metier.EtablissementClub;
import com.g1.projetfinalserveur.metier.EtablissementEcole;

public interface IserviceEtablissement {
	
	//POUR LES ClubS
		public void createClub (EtablissementClub ec);
		public List<EtablissementClub> findClubs();
		public void deleteClub(EtablissementClub ec);
		public EtablissementClub updateClub(EtablissementClub ec);
		public EtablissementClub getClub(long idClub);
		
		//POUR LES Ecole
		public void createEcole (EtablissementEcole ee);
		public List<EtablissementEcole> findEcoles();
		public void deleteEcole(EtablissementEcole ee);
		public EtablissementEcole updateEcole(EtablissementEcole ee);
		public EtablissementEcole getEcole(long idEcole);
		
		//POUR LES Centre Loisir
		public void createCentreLoisir (EtablissementCentreLoisir ecl);
		public List<EtablissementCentreLoisir> findCentreLoisirs();
		public void deleteCentreLoisir(EtablissementCentreLoisir ecl);
		public EtablissementCentreLoisir updateCentreLoisir(EtablissementCentreLoisir ecl);
		public EtablissementCentreLoisir getCentreLoisir(long idCentreLoisir);

}
