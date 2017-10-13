package com.g1.projetfinalserveur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g1.projetfinalserveur.metier.Enfant;
import com.g1.projetfinalserveur.metier.Responsable;
import com.g1.projetfinalserveur.service.ResponsableIservice;

/**
 * Handles requests for the application home page.
 */
@CrossOrigin
@RestController
public class ResponsableController {
	@Autowired
	private ResponsableIservice service;

	public ResponsableIservice getService() {
		return service;
	}

	public void setService(ResponsableIservice service) {
		this.service = service;
	}

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
		service.deleteEnfant(idEnfant);
	}

	@RequestMapping(value = "/getEnfant")
	public Enfant getEnfant(long idEnfant) {
		return service.getEnfant(idEnfant);
	}

	@RequestMapping(value = "/listEnfant")
	public List<Enfant> list(long idUser) {
		return service.findAllEnfantResponsable(idUser);
	}

	@RequestMapping(value = "/linkEnfant")
	public void linkEnfant(long idUser, long idEnfant) {

		Enfant e;
		e = service.getEnfant(idEnfant);
		e.setMonResponsable(service.getResponsable(idUser));
		service.updateEnfant(e);
	}

}
