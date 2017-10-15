package com.g1.projetfinalserveur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g1.projetfinalserveur.dao.CentreLoisirDAO;
import com.g1.projetfinalserveur.dao.ClubDAO;
import com.g1.projetfinalserveur.dao.ConnexionDAO;
import com.g1.projetfinalserveur.dao.EcoleDAO;
import com.g1.projetfinalserveur.dao.EnfantDAO;
import com.g1.projetfinalserveur.dao.FamilleDAO;
import com.g1.projetfinalserveur.dao.FicheImageDAO;
import com.g1.projetfinalserveur.dao.FicheMedicalDAO;
import com.g1.projetfinalserveur.dao.FichePrincipaleDAO;
import com.g1.projetfinalserveur.dao.FicheVaccinDAO;
import com.g1.projetfinalserveur.dao.MereDAO;
import com.g1.projetfinalserveur.dao.PereDAO;
import com.g1.projetfinalserveur.dao.ResponsableDAO;
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
	@Autowired
	PereDAO pereDao;
	@Autowired
	MereDAO mereDao;
	@Autowired
	ConnexionDAO connexionDao;	
	@Autowired
	FamilleDAO familleDao;
	//******CRUD RESPONSABLE
	@Override
	public Responsable createResponsable(Responsable r) {
		// TODO Auto-generated method stub
		return responsableDao.save(r);
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
	public Responsable getResponsable(long idResponsable) {
		// TODO Auto-generated method stub
		return responsableDao.findById(idResponsable).get();
	}	
	
	//*****CRUD CLUB
	@Override
	public EtablissementClub createClub(EtablissementClub ec) {
		// TODO Auto-generated method stub
		return clubDao.save(ec);
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
	public EtablissementClub getClub(long idClub) {
		// TODO Auto-generated method stub
		return clubDao.findById(idClub).get();
	}

	//*****CRUD ECOLE
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
		@Override
	public EtablissementEcole createEcole(EtablissementEcole ee) {
		// TODO Auto-generated method stub
		return ecoleDao.save(ee);
	}
	@Override
	public EtablissementEcole getEcole(long idEcole) {
		// TODO Auto-generated method stub
		return ecoleDao.findById(idEcole).get();
	}
	
	//*****CRUD CENTRE LOISIR
	@Override
	public EtablissementCentreLoisir createCentreLoisir(EtablissementCentreLoisir ecl) {
		// TODO Auto-generated method stub
		return centreLoisirDao.save(ecl);
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
	public EtablissementCentreLoisir getCentreLoisir(long idCentreLoisir) {
		// TODO Auto-generated method stub
		return centreLoisirDao.findById(idCentreLoisir).get();
	}
	
	//*****CRUD ENFANT
	@Override
	public Enfant createEnfant(Enfant e) {
		// TODO Auto-generated method stub
		return enfantDao.save(e);
	}
	@Override
	public List<Enfant> findAllEnfantResponsable(long idUser) {
		// TODO Auto-generated method stub
		return enfantDao.findAllEnfantResponsable(idUser);
	}
	public List<Enfant> findEnfants (){
		return enfantDao.findAll();
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
		return enfantDao.findById(idEnfant).get();
	}
	
	//*****CRUD FICHE PRINCIPALE
	@Override
	public FichePrincipale createFichePrincipale(FichePrincipale fp) {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.save(fp);
	}
	public List<FichePrincipale> findFichePrincipales(){
		return fichePrincipaleDao.findAll();
	}
	@Override
	public List<FichePrincipale> findAllFichePrincipaleEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.findAllFichePrincipaleEnfant(idEnfant);
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
	public FichePrincipale getFichePrincipale(long idFichePrincipal) {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.findById(idFichePrincipal).get();
	}
	
	//*****CRUD FICHE MEDICAL
	@Override
	public FicheMedical createFicheMedical(FicheMedical fm) {
		// TODO Auto-generated method stub
		return ficheMedicalDao.save(fm);
	}
	@Override
	public List<FicheMedical> findFicheMedicals(){
		return ficheMedicalDao.findAll();
	}
	public List<FicheMedical> findAllFicheMedicalEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return ficheMedicalDao.findAllFicheMedicalEnfant(idEnfant);
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
	public FicheMedical getFicheMedical(long idFicheMedical) {
		// TODO Auto-generated method stub
		return ficheMedicalDao.findById(idFicheMedical).get();
	}
	
	//*****CRUD FICHE VACCIN
	@Override
	public FicheVaccin createFicheVaccin(FicheVaccin fv) {
		// TODO Auto-generated method stub
		return ficheVaccinDao.save(fv);
	}
	@Override
	public List<FicheVaccin> findFicheVaccins(){
		return ficheVaccinDao.findAll();
	}
	public List<FicheVaccin> findAllFicheVaccinEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return ficheVaccinDao.findAllFicheVaccinEnfant(idEnfant);
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
	public FicheVaccin getFicheVaccin(long idFicheVaccin) {
		// TODO Auto-generated method stub
		return ficheVaccinDao.findById(idFicheVaccin).get();
	}
	
	//CRUD FICHE IMAGE
	@Override
	public FicheImage createFicheImage(FicheImage fi) {
		// TODO Auto-generated method stub
		return ficheImageDao.save(fi);
	}
	@Override
	public List<FicheImage> findFicheImages(){
		return ficheImageDao.findAll();
	}
	public List<FicheImage> findAllFicheImageEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return ficheImageDao.findAllFicheImageEnfant(idEnfant);
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
	public FicheImage getFicheImage(long idFicheImage) {
		// TODO Auto-generated method stub
		return ficheImageDao.findById(idFicheImage).get();
	}
	
	//CRUD PERE
	@Override
	public Pere createPere(Pere p) {
		// TODO Auto-generated method stub
		return pereDao.save(p);
	}
	@Override
	public void deletePere(Pere p) {
		// TODO Auto-generated method stub
		pereDao.delete(p);
	}
	@Override
	public Pere updatePere(Pere p) {
		// TODO Auto-generated method stub
		return pereDao.saveAndFlush(p);
	}
	@Override
	public Pere getPere(long idPere) {
		// TODO Auto-generated method stub
		return pereDao.findById(idPere).get();
	}
	
	//CRUD MERE
	@Override
	public Mere createMere(Mere m) {
		// TODO Auto-generated method stub
		return mereDao.save(m);
	}
	@Override
	public void deleteMere(Mere m) {
		// TODO Auto-generated method stub
		mereDao.delete(m);
	}
	@Override
	public Mere updateMere(Mere m) {
		// TODO Auto-generated method stub
		return mereDao.saveAndFlush(m);
	}
	@Override
	public Mere getMere(long idMere) {
		// TODO Auto-generated method stub
		return mereDao.findById(idMere).get();
	}
	
	
	@Override
	public Connexion findByMaConnexion(String login, String mdp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	// CRUD CONNEXION
	@Override
	public void createConnexion(Connexion c) {
		// TODO Auto-generated method stub
		connexionDao.save(c);
	}

	@Override
	public void deleteConnexion(Connexion m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Connexion updateConnexion(Connexion m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connexion getConnexion(long idConnexion) {
		// TODO Auto-generated method stub
		return connexionDao.findById(idConnexion).get();
	}

	@Override
	public Connexion findMaConnexion(String login, String mdp) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object findObjectConnexion(String login, String mdp) {
		// TODO Auto-generated method stub
		return connexionDao.findObjectConnexion(login, mdp);
	}
	@Override
	public Responsable findResponsable(String login, String mdp) {
		// TODO Auto-generated method stub
		return connexionDao.findResponsable(login, mdp);
	}

	@Override
	public List<EtablissementEcole> findAllEcoleFiche(long idFiche) {
		// TODO Auto-generated method stub
		return ecoleDao.findAllEcoleFiche(idFiche);
	}
	@Override
	public List<Enfant> findAllEnfantEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub
		return enfantDao.findAllEnfantEtablissement(idEtablissement);
	}

	@Override
	public List<FicheImage> findAllFicheImageEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub
		return ficheImageDao.findAllFicheImageEtablissement(idEtablissement);
	}

	@Override
	public List<FicheMedical> findAllFicheMedicalEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub
		return ficheMedicalDao.findAllFicheMedicalEtablissement(idEtablissement);
	}

	@Override
	public List<FicheVaccin> findAllFicheVaccinEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub
		return ficheVaccinDao.findAllFicheVaccinEtablissement(idEtablissement);
	}

	@Override
	public List<EtablissementCentreLoisir> findAllCentreLoisirFiche(long idFiche) {
		// TODO Auto-generated method stub
		return centreLoisirDao.findAllCentreLoisirFiche(idFiche);
	}

	@Override
	public List<EtablissementClub> findAllClubFiche(long idFiche) {
		// TODO Auto-generated method stub
		return clubDao.findAllClubFiche(idFiche);
	}

	@Override
	public List<EtablissementCentreLoisir> findAllCentreLoisirEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return centreLoisirDao.findAllCentreLoisirEnfant(idEnfant);
	}

	@Override
	public List<EtablissementClub> findAllClubEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return clubDao.findAllClubEnfant(idEnfant);
	}

	@Override
	public List<EtablissementEcole> findAllEcoleEnfant(long idEnfant) {
		// TODO Auto-generated method stub
		return ecoleDao.findAllEcoleEnfant(idEnfant);
	}

	@Override
	public List<FichePrincipale> findAllFichePrincipaleEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub
		return fichePrincipaleDao.findAllFichePrincipaleEtablissement(idEtablissement);
	}

	// CRUD FAMILLE

	@Override
	public void createFamille(Famille f) {
		// TODO Auto-generated method stub
		familleDao.save(f);
	}

	@Override
	public void deleteFamille(Famille f) {
		// TODO Auto-generated method stub
		familleDao.delete(f);
	}

	@Override
	public Famille updateFamille(Famille f) {
		// TODO Auto-generated method stub
		return familleDao.saveAndFlush(f);
	}

	@Override
	public Famille getFamille(long idFamille) {
		// TODO Auto-generated method stub
		return familleDao.findById(idFamille).get();
	}

}
