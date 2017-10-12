package com.g1.projetfinalserveur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g1.projetfinalserveur.dao.CentreLoisirDAO;
import com.g1.projetfinalserveur.dao.ClubDAO;
import com.g1.projetfinalserveur.dao.EcoleDAO;
import com.g1.projetfinalserveur.dao.EnfantDAO;
import com.g1.projetfinalserveur.dao.FicheImageDAO;
import com.g1.projetfinalserveur.dao.FicheMedicalDAO;
import com.g1.projetfinalserveur.dao.FichePrincipaleDAO;
import com.g1.projetfinalserveur.dao.FicheVaccinDAO;
import com.g1.projetfinalserveur.dao.ResponsableDAO;
import com.g1.projetfinalserveur.metier.EtablissementCentreLoisir;
import com.g1.projetfinalserveur.metier.EtablissementClub;
import com.g1.projetfinalserveur.metier.EtablissementEcole;
import com.g1.projetfinalserveur.metier.Responsable;

@Service
public class ServiceImplement implements Iuser {

	@Autowired
	EnfantDAO enfantDao;
	ResponsableDAO responsableDao;
	ClubDAO clubDao;
	EcoleDAO ecoleDao;
	CentreLoisirDAO centreLoisirDao;
	FicheImageDAO ficheImageDao;
	FicheMedicalDAO ficheMedicalDao;
	FichePrincipaleDAO fichePrincipaleDao;
	FicheVaccinDAO ficheVaccinDao;
	
	
	@Override
	public void createResponsable(Responsable r) {
		// TODO Auto-generated method stub
		responsableDao.save(r);
	}
	@Override
	public List<Responsable> findResponsables() {
		// TODO Auto-generated method stub
		return responsableDao.findAll();
	}
	@Override
	public void deleteResponsable(Responsable r) {
		// TODO Auto-generated method stub
		responsableDao.delete(r);
	}
	@Override
	public void updateResponsable(Responsable r) {
		// TODO Auto-generated method stub
		responsableDao.saveAndFlush(r);
	}
	
	
	@Override
	public void createClub(EtablissementClub c) {
		// TODO Auto-generated method stub
		clubDao.save(c);
	}
	@Override
	public List<EtablissementClub> findClubs() {
		// TODO Auto-generated method stub
		return clubDao.findAll();
	}
	@Override
	public void deleteClub(EtablissementClub c) {
		// TODO Auto-generated method stub
		clubDao.delete(c);
	}
	@Override
	public void updateClub(EtablissementClub c) {
		// TODO Auto-generated method stub
		clubDao.saveAndFlush(c);
	}
	
	
	@Override
	public void createEcole(EtablissementEcole e) {
		// TODO Auto-generated method stub
		ecoleDao.save(e);
	}
	@Override
	public List<EtablissementEcole> findEcoles() {
		// TODO Auto-generated method stub
		return ecoleDao.findAll();
	}
	@Override
	public void deleteEcole(EtablissementEcole e) {
		// TODO Auto-generated method stub
		ecoleDao.delete(e);
	}
	@Override
	public void updateEcole(EtablissementEcole e) {
		// TODO Auto-generated method stub
		ecoleDao.saveAndFlush(e);
	}
	
	//test
	
	@Override
	public void createCentreLoisir(EtablissementCentreLoisir cl) {
		// TODO Auto-generated method stub
		centreLoisirDao.save(cl);
	}
	@Override
	public List<EtablissementCentreLoisir> findCentreLoisirs() {
		// TODO Auto-generated method stub
		return centreLoisirDao.findAll();
	}
	@Override
	public void deleteCentreLoisir(EtablissementCentreLoisir cl) {
		// TODO Auto-generated method stub
		centreLoisirDao.delete(cl);
	}
	@Override
	public void updateCentreLoisir(EtablissementCentreLoisir cl) {
		// TODO Auto-generated method stub
		centreLoisirDao.saveAndFlush(cl);
		
	}


}
