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
import com.g1.projetfinalserveur.metier.Enfant;
import com.g1.projetfinalserveur.metier.EtablissementCentreLoisir;
import com.g1.projetfinalserveur.metier.EtablissementClub;
import com.g1.projetfinalserveur.metier.EtablissementEcole;
import com.g1.projetfinalserveur.metier.FicheImage;
import com.g1.projetfinalserveur.metier.FicheMedical;
import com.g1.projetfinalserveur.metier.FichePrincipale;
import com.g1.projetfinalserveur.metier.FicheVaccin;
import com.g1.projetfinalserveur.metier.Responsable;

@Service
public class ServiceImplement implements IserviceResponsable, IserviceEtablissement {

	@Autowired
	EnfantDAO enfantDao;
	@Autowired
	ResponsableDAO responsableDao;
	@Autowired
	ClubDAO clubDao;
	@Autowired
	EcoleDAO ecoleDao;
	@Autowired
	CentreLoisirDAO centreLoisirDao;
	@Autowired
	FicheImageDAO ficheImageDao;
	@Autowired
	FicheMedicalDAO ficheMedicalDao;
	@Autowired
	FichePrincipaleDAO fichePrincipaleDao;
	@Autowired
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
	public Responsable updateResponsable(Responsable r) {
		// TODO Auto-generated method stub
		return responsableDao.saveAndFlush(r);
	}
	@Override
	public List<Enfant> findAllEnfantResponsable(long idUser) {
		// TODO Auto-generated method stub
		return enfantDao.findAllEnfantResponsable(idUser);
	}
	
	
	@Override
	public void createClub(EtablissementClub ec) {
		// TODO Auto-generated method stub
		clubDao.save(ec);
	}
	@Override
	public List<EtablissementClub> findClubs() {
		// TODO Auto-generated method stub
		return clubDao.findAll();
	}
	@Override
	public void deleteClub(EtablissementClub ec) {
		// TODO Auto-generated method stub
		clubDao.delete(ec);
	}
	@Override
	public EtablissementClub updateClub(EtablissementClub ec) {
		// TODO Auto-generated method stub
		return clubDao.saveAndFlush(ec);
	}
		@Override
	public void createEcole(EtablissementEcole ee) {
		// TODO Auto-generated method stub
		ecoleDao.save(ee);
	}
	@Override
	public List<EtablissementEcole> findEcoles() {
		// TODO Auto-generated method stub
		return ecoleDao.findAll();
	}
	@Override
	public void deleteEcole(EtablissementEcole ee) {
		// TODO Auto-generated method stub
		ecoleDao.delete(ee);
	}
	@Override
	public EtablissementEcole updateEcole(EtablissementEcole ee) {
		// TODO Auto-generated method stub
		return ecoleDao.saveAndFlush(ee);
	}
	//test
	@Override
	public void createCentreLoisir(EtablissementCentreLoisir ecl) {
		// TODO Auto-generated method stub
		centreLoisirDao.save(ecl);
	}
	@Override
	public List<EtablissementCentreLoisir> findCentreLoisirs() {
		// TODO Auto-generated method stub
		return centreLoisirDao.findAll();
	}
	@Override
	public void deleteCentreLoisir(EtablissementCentreLoisir ecl) {
		// TODO Auto-generated method stub
		centreLoisirDao.delete(ecl);
	}
	@Override
	public EtablissementCentreLoisir updateCentreLoisir(EtablissementCentreLoisir ecl) {
		// TODO Auto-generated method stub
		return centreLoisirDao.saveAndFlush(ecl);
	}
	
	
	@Override
	public void createEnfant(Enfant e) {
		// TODO Auto-generated method stub
		enfantDao.save(e);
	}
	@Override
	public void deleteEnfant(Enfant e) {
		// TODO Auto-generated method stub
		enfantDao.delete(e);
	}
	@Override
	public Enfant updateEnfant(Enfant e) {
		// TODO Auto-generated method stub
		return enfantDao.saveAndFlush(e);
	}
	@Override
	public Enfant getEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return enfantDao.getOne(idEnfant);
	}
	
	
	@Override
	public void createFichePrincipale(FichePrincipale fp) {
		// TODO Auto-generated method stub
		fichePrincipaleDao.save(fp);
	}
	@Override
	public List<FichePrincipale> findAllFichePrincipaleEnfant() {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.findAll();
	}
	@Override
	public void deleteFichePrincipale(FichePrincipale fp) {
		// TODO Auto-generated method stub
		fichePrincipaleDao.delete(fp);
	}
	@Override
	public FichePrincipale updateFichePrincipale(FichePrincipale fp) {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.saveAndFlush(fp);
	}
	@Override
	public FichePrincipale getFichePrincipale(long idFiche) {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.getOne(idFiche);
	}
	
	@Override
	public void createFicheMedical(FicheMedical fm) {
		// TODO Auto-generated method stub
		ficheMedicalDao.save(fm);
	}
	@Override
	public List<FicheMedical> findAllFicheMedicalEnfant() {
		// TODO Auto-generated method stub
		return ficheMedicalDao.findAll();
	}
	@Override
	public void deleteFicheMedical(FicheMedical fm) {
		// TODO Auto-generated method stub
		ficheMedicalDao.delete(fm);
	}
	@Override
	public FicheMedical updateFicheMedical(FicheMedical fm) {
		// TODO Auto-generated method stub
		return ficheMedicalDao.saveAndFlush(fm);
	}
	@Override
	public FicheMedical getFicheMedical(long idFiche) {
		// TODO Auto-generated method stub
		return ficheMedicalDao.getOne(idFiche);
	}
	
	@Override
	public void createFicheVaccin(FicheVaccin fv) {
		// TODO Auto-generated method stub
		ficheVaccinDao.save(fv);
	}
	@Override
	public List<FicheVaccin> findAllFicheVaccinEnfant() {
		// TODO Auto-generated method stub
		return ficheVaccinDao.findAll();
	}
	@Override
	public void deleteFicheVaccin(FicheVaccin fv) {
		// TODO Auto-generated method stub
		ficheVaccinDao.delete(fv);
	}
	@Override
	public FicheVaccin updateFicheVaccin(FicheVaccin fv) {
		// TODO Auto-generated method stub
		return ficheVaccinDao.saveAndFlush(fv);
	}
	@Override
	public FicheVaccin getFicheVaccin(long idFiche) {
		// TODO Auto-generated method stub
		return ficheVaccinDao.getOne(idFiche);
	}
	
	@Override
	public void createFicheImage(FicheImage fi) {
		// TODO Auto-generated method stub
		ficheImageDao.save(fi);
	}
	@Override
	public List<FicheImage> findAllFicheImageEnfant() {
		// TODO Auto-generated method stub
		return ficheImageDao.findAll();
	}
	@Override
	public void deleteFicheImage(FicheImage fi) {
		// TODO Auto-generated method stub
		ficheImageDao.delete(fi);
	}
	@Override
	public FicheImage updateFicheImage(FicheImage fi) {
		// TODO Auto-generated method stub
		return ficheImageDao.saveAndFlush(fi);
	}
	@Override
	public FicheImage getFicheImage(long idFiche) {
		// TODO Auto-generated method stub
		return ficheImageDao.getOne(idFiche);
	}


}
