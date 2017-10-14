package com.g1.projetfinalserveur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g1.projetfinalserveur.metier.Enfant;
import com.g1.projetfinalserveur.metier.EtablissementEcole;
import com.g1.projetfinalserveur.metier.FicheImage;
import com.g1.projetfinalserveur.metier.FicheMedical;
import com.g1.projetfinalserveur.metier.FichePrincipale;
import com.g1.projetfinalserveur.metier.FicheVaccin;
import com.g1.projetfinalserveur.metier.Mere;
import com.g1.projetfinalserveur.metier.Responsable;
import com.g1.projetfinalserveur.service.IserviceEtablissement;
import com.g1.projetfinalserveur.service.IserviceResponsable;


/**
 * Handles requests for the application home page.
 */
@CrossOrigin
@RestController
public class ResponsableController {
	@Autowired
	private IserviceResponsable service;
	@Autowired
	private IserviceEtablissement serviceE;
	

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @return
	 */
	

	// responsable
	
	

	@RequestMapping(value = "/saveResponsable", method=RequestMethod.POST)
	public Responsable saveResponsable(@RequestBody Responsable r) {
		service.createResponsable(r);
		return r;
	}

	@RequestMapping(value = "/updateResponsable")
	public Responsable updateResponsable(Responsable r) {
		service.updateResponsable(r);
		return r;
	}

	@RequestMapping(value = "/getResponsable")
	public Responsable getResponsable(long idUser) {
		return service.getResponsable(idUser);

	}
	
	

	// enfant
	
	
	

	@RequestMapping(value = "/saveEnfant", method=RequestMethod.POST)
	public Enfant saveEnfant(@RequestBody Enfant e) {
		service.createEnfant(e);
		return e;
	}

	@RequestMapping(value = "/updateEnfant")
	public Enfant updateEnfant(Enfant e) {
		service.updateEnfant(e);
		return e;
	}

	@RequestMapping(value = "/deleteEnfant")
	public void deleteEnfant(long idEnfant) {
		
	}

	@RequestMapping(value = "/getEnfant")
	public Enfant getEnfant(long idEnfant) {
		return service.getEnfant(idEnfant);
	}

	@RequestMapping(value = "/listEnfantResponsable")
	public List<Enfant> list(long idUser) {
		return service.findAllEnfantResponsable(idUser);
	}


	
	// fichePrincipale
	
	
	@RequestMapping(value = "/saveFichePrincipale", method=RequestMethod.POST)
	public FichePrincipale saveFichePrincipale(@RequestBody  FichePrincipale fp) {
		service.createFichePrincipale(fp);
		return fp;
	}
	@RequestMapping(value = "/updateFichePrincipale")
	public FichePrincipale updateFichePrincipale(FichePrincipale fp) {
		service.updateFichePrincipale(fp);
		return fp;
	}
	@RequestMapping(value = "/getFichePrincipal")
	public FichePrincipale getFichePrincipal(long idFiche) {
		return service.getFichePrincipale(idFiche);
	}
	@RequestMapping(value = "/listFichePrincipaleEnfant")
	public List<FichePrincipale> listFichePrincipale(long idEnfant) {
		return service.findAllFichePrincipaleEnfant(idEnfant);
	}
	/*
	@RequestMapping(value = "/linkFichePrincipaleEnfant")
	public void linkFichePrincipaleEnfant(long idEnfant, long idFiche) {

		FichePrincipale fp;
		fp = service.getFichePrincipale(idFiche);
		fp.setMonEnfant(service.getEnfant(idEnfant));
		service.updateFichePrincipale(fp);
	}
	
	@RequestMapping(value = "/linkFichePrincipaleEcole")
	public void linkFichePrincipaleEcole(long idEtablissement, long idFiche) {

		FichePrincipale fp;
		fp = service.getFichePrincipale(idFiche);
		fp.getMesEtablissementsFiche().add(serviceE.getEcole(idEtablissement));
		service.updateFichePrincipale(fp);
	}*/
	
	
	
	
	
	// ficheMedical

	
	
	
	@RequestMapping(value = "/saveFicheMedical", method=RequestMethod.POST)
	public FicheMedical saveFicheMedical(@RequestBody FicheMedical fm) {
		service.createFicheMedical(fm);
		return fm;
	}
	@RequestMapping(value = "/updateFicheMedical")
	public FicheMedical updateFicheMedical(FicheMedical fm) {
		service.updateFicheMedical(fm);
		return fm;
	}
	
	@RequestMapping(value = "/getFicheMedical")
	public FicheMedical getFicheMedical(long idFiche) {
		return service.getFicheMedical(idFiche);
	}
	
	@RequestMapping(value = "/listFicheMedicalEnfant")
	public List<FicheMedical> listFicheMedical(long idEnfant) {
		return service.findAllFicheMedicalEnfant(idEnfant);
	}
	/*
	@RequestMapping(value = "/linkFicheMedicalEnfant")
	public void linkFicheMedicalEnfant(long idEnfant, long idFiche) {

		FicheMedical fm;
		fm = service.getFicheMedical(idFiche);
		fm.setMonEnfant(service.getEnfant(idEnfant));
		service.updateFicheMedical(fm);
	}
	
	@RequestMapping(value = "/linkFicheMedicalEcole")
	public void linkFicheMedicalEcole(long idEtablissement, long idFiche) {

		FicheMedical fm;
		fm = service.getFicheMedical(idFiche);
		fm.getMesEtablissementsFiche().add(serviceE.getEcole(idEtablissement));
		service.updateFicheMedical(fm);
	}
	
	@RequestMapping(value = "/linkFicheMedicalClub")
	public void linkFicheMedicalClub(long idEtablissement, long idFiche) {

		FicheMedical fm;
		fm = service.getFicheMedical(idFiche);
		fm.getMesEtablissementsFiche().add(serviceE.getClub(idEtablissement));
		service.updateFicheMedical(fm);
	}
	
	@RequestMapping(value = "/linkFicheMedicalCentreLoisir")
	public void linkFicheMedicalCentreLoisir(long idEtablissement, long idFiche) {

		FicheMedical fm;
		fm = service.getFicheMedical(idFiche);
		fm.getMesEtablissementsFiche().add(serviceE.getCentreLoisir(idEtablissement));
		service.updateFicheMedical(fm);
	}
	*/
	
	
	
	
	
	//ficheVaccin
	
	
	
	
	
	@RequestMapping(value = "/saveFicheVaccin", method=RequestMethod.POST)
	public FicheVaccin saveFicheVaccin(@RequestBody FicheVaccin fv) {
		service.createFicheVaccin(fv);
		return fv;
	}
	@RequestMapping(value = "/updateFicheVaccin")
	public FicheVaccin updateFicheVaccin(FicheVaccin fv) {
		service.updateFicheVaccin(fv);
		return fv;
	}
	
	@RequestMapping(value = "/getFicheVaccin")
	public FicheVaccin getFicheVaccin(long idFiche) {
		return service.getFicheVaccin(idFiche);
	}
	
	@RequestMapping(value = "/listFicheVaccinEnfant")
	public List<FicheVaccin> listFicheVaccin(long idEnfant) {
		return service.findAllFicheVaccinEnfant(idEnfant);
	}
	
	@RequestMapping(value = "/linkFicheVaccinEnfant")
	public void linkFicheVaccinEnfant(long idEnfant, long idFiche) {

		FicheVaccin fv;
		fv = service.getFicheVaccin(idFiche);
		fv.setMonEnfant(service.getEnfant(idEnfant));
		service.updateFicheVaccin(fv);
	}
	/*
	@RequestMapping(value = "/linkFicheVaccinEcole")
	public void linkFicheVaccinEcole(long idEtablissement, long idFiche) {

		FicheVaccin fv;
		fv = service.getFicheVaccin(idFiche);
		fv.getMesEtablissementsFiche().add(serviceE.getEcole(idEtablissement));
		service.updateFicheVaccin(fv);
	}
	
	@RequestMapping(value = "/linkFicheVaccinClub")
	public void linkFicheVaccinClub(long idEtablissement, long idFiche) {

		FicheVaccin fv;
		fv = service.getFicheVaccin(idFiche);
		fv.getMesEtablissementsFiche().add(serviceE.getClub(idEtablissement));
		service.updateFicheVaccin(fv);
	}
	
	@RequestMapping(value = "/linkFicheVaccinCentreLoisir")
	public void linkFicheVaccinCentreLoisir(long idEtablissement, long idFiche) {

		FicheVaccin fv;
		fv = service.getFicheVaccin(idFiche);
		fv.getMesEtablissementsFiche().add(serviceE.getCentreLoisir(idEtablissement));
		service.updateFicheVaccin(fv);
	}
	*/
	
	
	//ficheImage
	
	

	@RequestMapping(value = "/saveFicheImage", method=RequestMethod.POST)
	public FicheImage saveFicheImage(@RequestBody FicheImage fi) {
		service.createFicheImage(fi);
		return fi;
	}
	@RequestMapping(value = "/updateFicheImage")
	public FicheImage updateFicheImage(FicheImage fi) {
		service.updateFicheImage(fi);
		return fi;
	}
	
	@RequestMapping(value = "/getFicheImage")
	public FicheImage getFicheImage(long idFiche) {
		return service.getFicheImage(idFiche);
	}
	
	@RequestMapping(value = "/listFicheImageEnfant")
	public List<FicheImage> listFicheImage(long idEnfant) {
		return service.findAllFicheImageEnfant(idEnfant);
	}
	/*
	@RequestMapping(value = "/linkFicheImageEnfant")
	public void linkFicheImageEnfant(long idEnfant, long idFiche) {

		FicheImage fi;
		fi = service.getFicheImage(idFiche);
		fi.setMonEnfant(service.getEnfant(idEnfant));
		service.updateFicheImage(fi);
	}
	
	@RequestMapping(value = "/linkFicheImageEcole")
	public void linkFicheImageEcole(long idEtablissement, long idFiche) {

		FicheImage fi;
		fi = service.getFicheImage(idFiche);
		fi.getMesEtablissementsFiche().add(serviceE.getEcole(idEtablissement));
		service.updateFicheImage(fi);
	}
	
	@RequestMapping(value = "/linkFicheImageClub")
	public void linkFicheImageClub(long idEtablissement, long idFiche) {

		FicheImage fi;
		fi = service.getFicheImage(idFiche);
		fi.getMesEtablissementsFiche().add(serviceE.getClub(idEtablissement));
		service.updateFicheImage(fi);
	}
	
	@RequestMapping(value = "/linkFicheImageCentreLoisir")
	public void linkFicheImageCentreLoisir(long idEtablissement, long idFiche) {

		FicheImage fi;
		fi = service.getFicheImage(idFiche);
		fi.getMesEtablissementsFiche().add(serviceE.getCentreLoisir(idEtablissement));
		service.updateFicheImage(fi);
	}
	*/
	// EtablissementEcole
	
	@RequestMapping(value = "/saveEtablissementEcole", method=RequestMethod.POST)
	public EtablissementEcole saveEtablissementEcole(@RequestBody EtablissementEcole ee) {
		serviceE.createEcole(ee);
		return ee;
	}
	
	@RequestMapping(value = "/listEtablissementEcole")
	public List<EtablissementEcole> listEtablissementEcole() {
		return serviceE.findEcoles();
	}
	
	@RequestMapping(value = "/getEtablissementEcole")
	public EtablissementEcole getEtablissementEcole(long idEtablissement) {
		return serviceE.getEcole(idEtablissement);
	}
	
	
	
	@RequestMapping(value = "/linkEtablissementEcoleEnfant")
	public void linkEtablissementEcoleEnfant(long idEnfant, long idEtablissement) {
		
		Enfant e;
		e = service.getEnfant(idEnfant);
		e.getMesEtablissementsEnfant().add(serviceE.getEcole(idEtablissement));
		service.updateEnfant(e);

	}
	
	/*@RequestMapping(value = "/listFichePrincipaleEtablissement")
	public List<FichePrincipale> listFichePrincipaleEtablissement (long idEtablissement) {
		//return serviceE.findFichePrincpaleEtablissement(long idEtablissement);
	}*/	
}
