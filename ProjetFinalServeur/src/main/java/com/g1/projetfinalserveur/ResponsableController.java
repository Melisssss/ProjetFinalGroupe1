package com.g1.projetfinalserveur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g1.projetfinalserveur.metier.Enfant;
import com.g1.projetfinalserveur.metier.FichePrincipale;
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

	@RequestMapping(value = "/saveResponsable")
	public Responsable saveResponsable(Responsable r) {
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

	@RequestMapping(value = "/saveEnfant")
	public Enfant saveEnfant(Enfant e) {
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

	@RequestMapping(value = "/linkEnfantResponsable")
	public void linkEnfant(long idUser, long idEnfant) {

		Enfant e;
		e = service.getEnfant(idEnfant);
		e.setMonResponsable(service.getResponsable(idUser));
		service.updateEnfant(e);
	}
	
	// fichePrincipale
	
	@RequestMapping(value = "/saveFichePrincipale")
	public FichePrincipale saveFichePrincipale(FichePrincipale fp) {
		service.createFichePrincipale(fp);
		return fp;
	}
	@RequestMapping(value = "/updateFichePrincipale")
	public FichePrincipale updateFichePrincipale(FichePrincipale fp) {
		service.updateFichePrincipale(fp);
		return fp;
	}
	
	@RequestMapping(value = "/getFicheParticulier")
	public FichePrincipale getParticulier(long idFichePrincipal) {
		return service.getFichePrincipale(idFichePrincipal);
	}
	
	@RequestMapping(value = "/listFichePrincipaleEnfant")
	public List<FichePrincipale> listFichePrincipale(long idEnfant) {
		return service.findAllFichePrincipaleEnfant(idEnfant);
	}
	
	@RequestMapping(value = "/linkFichePrincipaleEnfant")
	public void linkFichePrincipaleEnfant(long idEnfant, long idFichePrincipale) {

		FichePrincipale fp;
		fp = service.getFichePrincipale(idFichePrincipale);
		fp.setMonEnfant(service.getEnfant(idEnfant));
		service.updateFichePrincipale(fp);
	}
	
	@RequestMapping(value = "/linkFichePrincipaleEcole")
	public void linkFichePrincipaleEcole(long idEtablissement, long idFichePrincipale) {

		FichePrincipale fp;
		fp = service.getFichePrincipale(idFichePrincipale);
		fp.getMesEtablissementsFiche().add(serviceE.getEcole(idEtablissement));
		service.updateFichePrincipale(fp);
	}
	
	@RequestMapping(value = "/linkFichePrincipaleClub")
	public void linkFichePrincipaleClub(long idEtablissement, long idFichePrincipale) {

		FichePrincipale fp;
		fp = service.getFichePrincipale(idFichePrincipale);
		fp.getMesEtablissementsFiche().add(serviceE.getClub(idEtablissement));
		service.updateFichePrincipale(fp);
	}
	
	@RequestMapping(value = "/linkFichePrincipaleCentreLoisir")
	public void linkFichePrincipaleCentreLoisir(long idEtablissement, long idFichePrincipale) {

		FichePrincipale fp;
		fp = service.getFichePrincipale(idFichePrincipale);
		fp.getMesEtablissementsFiche().add(serviceE.getCentreLoisir(idEtablissement));
		service.updateFichePrincipale(fp);
	}

}
