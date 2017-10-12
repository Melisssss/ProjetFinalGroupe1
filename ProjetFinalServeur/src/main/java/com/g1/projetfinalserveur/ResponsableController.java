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
import com.g1.projetfinalserveur.service.IserviceResponsable;

/**
 * Handles requests for the application home page.
 */
@CrossOrigin
@RestController
public class ResponsableController {
	@Autowired
	private IserviceResponsable service;

	public IserviceResponsable getService() {
		return service;
	}

	public void setService(IserviceResponsable service) {
		this.service = service;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @return
	 */
	
	// responsable
	
	@RequestMapping(value = "/saveResponsable", method = RequestMethod.POST)
	public Responsable save(@RequestBody Responsable r) {
		service.createResponsable(r);
		return r;
	}

	
	@RequestMapping(value = "/updateResponsable")
	public Responsable update(Responsable r) {
		service.updateResponsable(r);
		return r;
	}
	
	// enfant
	
	@RequestMapping(value = "/saveEnfant")
	public Enfant save(Enfant e) {
		service.createEnfant(e);
		return e;
	}

	
	@RequestMapping(value = "/updateEnfant")
	public Enfant update(Enfant e) {
		service.updateEnfant(e);
		return e;
	}
	
	@RequestMapping(value = "/DeleteEnfant")
	public void delete(long idEnfant) {
		service.deleteEnfant(idEnfant);
	}
	
	@RequestMapping(value = "/getEnfant")
	public Enfant get(long idEnfant) {
		return service.getEnfant(idEnfant);
	}
	
	@RequestMapping(value = "/listEnfant")
	public List<Enfant> list(long idUser) {
		return service.findAllEnfantResponsable(idUser);
	}
}
