package com.g1.projetfinalserveur.service;

import java.util.List;

import com.g1.projetfinalserveur.metier.EtablissementCentreLoisir;
import com.g1.projetfinalserveur.metier.EtablissementClub;
import com.g1.projetfinalserveur.metier.EtablissementEcole;
import com.g1.projetfinalserveur.metier.Responsable;

public interface Iuser {
	
	//POUR LES RESPONSABLES
	public void createResponsable (Responsable r);
	public List<Responsable> findResponsables();
	public void deleteResponsable(Responsable r);
	public void updateResponsable(Responsable r);

	//POUR LES ClubS
	public void createClub (EtablissementClub c);
	public List<EtablissementClub> findClubs();
	public void deleteClub(EtablissementClub c);
	public void updateClub(EtablissementClub c);
	
	//POUR LES Ecole
	public void createEcole (EtablissementEcole e);
	public List<EtablissementEcole> findEcoles();
	public void deleteEcole(EtablissementEcole e);
	public void updateEcole(EtablissementEcole e);
	
	//POUR LES Centre Loisir
	public void createCentreLoisir (EtablissementCentreLoisir cl);
	public List<EtablissementCentreLoisir> findCentreLoisirs();
	public void deleteCentreLoisir(EtablissementCentreLoisir cl);
	public void updateCentreLoisir(EtablissementCentreLoisir cl);


}
