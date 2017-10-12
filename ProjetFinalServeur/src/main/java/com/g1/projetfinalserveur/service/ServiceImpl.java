package com.g1.projetfinalserveur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g1.projetfinalserveur.dao.EnfantDao;
import com.g1.projetfinalserveur.dao.FicheImageDao;
import com.g1.projetfinalserveur.dao.FicheMedicalDao;
import com.g1.projetfinalserveur.dao.FichePrincipaleDao;
import com.g1.projetfinalserveur.dao.FicheVaccinDao;
import com.g1.projetfinalserveur.dao.ResponsableDao;
import com.g1.projetfinalserveur.metier.Enfant;
import com.g1.projetfinalserveur.metier.FicheImage;
import com.g1.projetfinalserveur.metier.FicheMedical;
import com.g1.projetfinalserveur.metier.FichePrincipale;
import com.g1.projetfinalserveur.metier.FicheVaccin;
import com.g1.projetfinalserveur.metier.Responsable;

@Service
public class ServiceImpl implements IserviceResponsable {

	@Autowired
	ResponsableDao responsableDao;
	@Autowired
	EnfantDao enfantDao;
	@Autowired
	FicheMedicalDao ficheMediacleDao;
	@Autowired
	FicheVaccinDao ficheVaccinDao;
	@Autowired
	FichePrincipaleDao fichePrincipaleDao;
	@Autowired
	FicheImageDao ficheImageDao;

	// getter & setter
	public ResponsableDao getResponsableDao() {
		return responsableDao;
	}

	public void setResponsableDao(ResponsableDao responsableDao) {
		this.responsableDao = responsableDao;
	}

	public EnfantDao getEnfantDao() {
		return enfantDao;
	}

	public void setEnfantDao(EnfantDao enfantDao) {
		this.enfantDao = enfantDao;
	}

	public FicheMedicalDao getFicheMediacleDao() {
		return ficheMediacleDao;
	}

	public void setFicheMediacleDao(FicheMedicalDao ficheMediacleDao) {
		this.ficheMediacleDao = ficheMediacleDao;
	}

	public FicheVaccinDao getFicheVaccinDao() {
		return ficheVaccinDao;
	}

	public void setFicheVaccinDao(FicheVaccinDao ficheVaccinDao) {
		this.ficheVaccinDao = ficheVaccinDao;
	}

	public FichePrincipaleDao getFichePrincipaleDao() {
		return fichePrincipaleDao;
	}

	public void setFichePrincipaleDao(FichePrincipaleDao fichePrincipaleDao) {
		this.fichePrincipaleDao = fichePrincipaleDao;
	}

	public FicheImageDao getFicheImageDao() {
		return ficheImageDao;
	}

	public void setFicheImageDao(FicheImageDao ficheImageDao) {
		this.ficheImageDao = ficheImageDao;
	}

	// methode
	
	
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
	
	// methode fichePrincipale
	@Override
	public void createFichePrincipale(FichePrincipale f) {
		// TODO Auto-generated method stub
		fichePrincipaleDao.save(f);
	}

	@Override
	public void deleteFichePrincipale(long idFiche) {
		// TODO Auto-generated method stub
		fichePrincipaleDao.deleteById(idFiche);
	}

	@Override
	public FichePrincipale getFichePrincipale(long idFiche) {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.findById(idFiche).get();
	}

	@Override
	public FichePrincipale updateFichePrincipale(FichePrincipale f) {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.saveAndFlush(f);
	}

	@Override
	public List<FichePrincipale> findAllFichePrincipaleEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.findAllFichePrincipaleEnfant(idEnfant);
	}

	// methode ficheMedical
	
	@Override
	public void createFicheMedical(FicheMedical e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFicheMedical(long idFiche) {
		// TODO Auto-generated method stub

	}

	@Override
	public FicheMedical getFicheMedical(long idFiche) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FicheMedical updateFicheMedical(FicheMedical f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FicheMedical> findAllFicheMedicalEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return null;
	}

	// methode ficheVaccin
	@Override
	public void createFicheVaccin(FicheVaccin f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFicheVaccin(long idFiche) {
		// TODO Auto-generated method stub

	}

	@Override
	public FicheVaccin getFicheVaccin(long idFiche) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FicheVaccin updateFicheVaccin(FicheVaccin f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FicheVaccin> findAllFicheVaccinEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// methode ficheImage
	@Override
	public void createFicheImage(FicheImage f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFicheImage(long idFiche) {
		// TODO Auto-generated method stub

	}

	@Override
	public FicheImage getFicheImage(long idFiche) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FicheImage updateFicheImage(FicheImage f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FicheImage> findAllFicheImageEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return null;
	}

}
