package com.g1.projetfinalserveur.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.g1.projetfinalserveur.dao.EnfantDAO;
import com.g1.projetfinalserveur.dao.FicheImageDAO;
import com.g1.projetfinalserveur.dao.FicheMedicalDAO;
import com.g1.projetfinalserveur.dao.FichePrincipaleDAO;
import com.g1.projetfinalserveur.dao.FicheVaccinDAO;
import com.g1.projetfinalserveur.dao.ResponsableDAO;
import com.g1.projetfinalserveur.metier.Enfant;
import com.g1.projetfinalserveur.metier.Responsable;

@Service
public class ResponsableServiceImpl implements ResponsableIservice {

	@Autowired
	ResponsableDAO responsableDao;
	@Autowired
	EnfantDAO enfantDao;
	@Autowired
	FicheMedicalDAO ficheMediacleDao;
	@Autowired
	FicheVaccinDAO ficheVaccinDao;
	@Autowired
	FichePrincipaleDAO fichePrincipaleDao;
	@Autowired
	FicheImageDAO ficheImageDao;

	// getter & setter
	public ResponsableDAO getResponsableDao() {
		return responsableDao;
	}

	public void setResponsableDao(ResponsableDAO responsableDao) {
		this.responsableDao = responsableDao;
	}

	public EnfantDAO getEnfantDao() {
		return enfantDao;
	}

	public void setEnfantDao(EnfantDAO enfantDao) {
		this.enfantDao = enfantDao;
	}

	public FicheMedicalDAO getFicheMediacleDao() {
		return ficheMediacleDao;
	}

	public void setFicheMediacleDao(FicheMedicalDAO ficheMediacleDao) {
		this.ficheMediacleDao = ficheMediacleDao;
	}

	public FicheVaccinDAO getFicheVaccinDao() {
		return ficheVaccinDao;
	}

	public void setFicheVaccinDao(FicheVaccinDAO ficheVaccinDao) {
		this.ficheVaccinDao = ficheVaccinDao;
	}

	public FichePrincipaleDAO getFichePrincipaleDao() {
		return fichePrincipaleDao;
	}

	public void setFichePrincipaleDao(FichePrincipaleDAO fichePrincipaleDao) {
		this.fichePrincipaleDao = fichePrincipaleDao;
	}

	public FicheImageDAO getFicheImageDao() {
		return ficheImageDao;
	}

	public void setFicheImageDao(FicheImageDAO ficheImageDao) {
		this.ficheImageDao = ficheImageDao;
	}

	// methode responsable
	@Override
	public void createResponsable(Responsable r) {
		// TODO Auto-generated method stub
		responsableDao.save(r);
	}

	@Override
	public Responsable getResponsable(long idUser) {
		// TODO Auto-generated method stub
		return responsableDao.findById(idUser).get();
	}

	@Override
	public Responsable updateResponsable(Responsable r) {
		// TODO Auto-generated method stub
		return responsableDao.saveAndFlush(r);
	}

	// methode enfant
	@Override
	public void createEnfant(Enfant e) {
		// TODO Auto-generated method stub
		enfantDao.save(e);
	}

	@Override
	public void deleteEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		enfantDao.deleteById(idEnfant);
	}

	@Override
	public Enfant getEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return enfantDao.findById(idEnfant).get();
	}

	@Override
	public Enfant updateEnfant(Enfant e) {
		// TODO Auto-generated method stub
		return enfantDao.saveAndFlush(e);
	}

	@Override
	public List<Enfant> findAllEnfantResponsable(long idUser) {
		// TODO Auto-generated method stub
		return enfantDao.findAllEnfantResponsable(idUser);
	}

}
