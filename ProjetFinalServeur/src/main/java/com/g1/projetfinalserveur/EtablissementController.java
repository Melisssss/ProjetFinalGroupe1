package com.g1.projetfinalserveur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g1.projetfinalserveur.metier.Connexion;
import com.g1.projetfinalserveur.metier.Demande;
import com.g1.projetfinalserveur.metier.Enfant;
import com.g1.projetfinalserveur.metier.Etablissement;
import com.g1.projetfinalserveur.metier.EtablissementCentreLoisir;
import com.g1.projetfinalserveur.metier.EtablissementClub;
import com.g1.projetfinalserveur.metier.EtablissementEcole;
import com.g1.projetfinalserveur.metier.Fiche;
import com.g1.projetfinalserveur.metier.FicheMedical;
import com.g1.projetfinalserveur.metier.FichePrincipale;
import com.g1.projetfinalserveur.metier.FicheVaccin;
import com.g1.projetfinalserveur.service.IserviceEtablissement;

@CrossOrigin
@RestController
public class EtablissementController {
	@Autowired
	private IserviceEtablissement service;

	// saveEtablissement

	@RequestMapping(value = "/saveCentreLoisirs", method=RequestMethod.POST)
	public EtablissementCentreLoisir saveCentreLoisirs(@RequestBody EtablissementCentreLoisir e) {
		service.createCentreLoisirs(e);
		return e;
	}

	@RequestMapping(value = "/saveEcole", method=RequestMethod.POST)
	public EtablissementEcole saveEcole(@RequestBody EtablissementEcole e) {
		service.createEcole(e);
		return e;
	}

	@RequestMapping(value = "/saveClub", method=RequestMethod.POST)
	public EtablissementClub saveClub(@RequestBody EtablissementClub e) {
		service.createClub(e);
		return e;
	}

	// updateEtablissement

	@RequestMapping(value = "/updateCentreLoisirs", method=RequestMethod.POST)
	public EtablissementCentreLoisir updateCentreLoisirs(@RequestBody EtablissementCentreLoisir e) {
		service.updateCentreLoisirs(e);
		return e;
	}

	@RequestMapping(value = "/updateEcole", method=RequestMethod.POST)
	public EtablissementEcole updateEcole(@RequestBody EtablissementEcole e) {
		service.updateEcole(e);
		return e;
	}

	@RequestMapping(value = "/updateClub", method=RequestMethod.POST)
	public EtablissementClub updateClub(@RequestBody EtablissementClub e) {
		service.updateClub(e);
		return e;
	}

	// deleteEtablissement

	@RequestMapping(value = "/deleteCentreLoisirs", method=RequestMethod.GET)
	public EtablissementCentreLoisir deleteCentreLoisirs(@RequestBody EtablissementCentreLoisir e) {
		service.deleteCentreLoisirs(e);
		return e;
	}

	@RequestMapping(value = "/deleteEcole", method=RequestMethod.GET)
	public EtablissementEcole deleteEcole(@RequestBody EtablissementEcole e) {
		service.deleteEcole(e);
		return e;
	}

	@RequestMapping(value = "/deleteClub", method=RequestMethod.GET)
	public EtablissementClub deleteClub(@RequestBody EtablissementClub e) {
		service.deleteClub(e);
		return e;
	}

	// getEtablissement

	@RequestMapping(value = "/getEtablissement", method=RequestMethod.GET)
	public Object getEtablissement(long idEtablissement) {
		return service.getEtablissement(idEtablissement);
	}

	// findAll

	@RequestMapping(value = "/findAllEnfant", method=RequestMethod.GET)
	public List<Enfant> findAllEnfant() {
		return service.findAllEnfant();
	}

	@RequestMapping(value = "/findAllFicheEnfant", method=RequestMethod.GET)
	public List<Fiche> findAllFicheEnfant(@Param("x") long idEnfant) {
		return service.findAllFicheEnfant(idEnfant);
	}
	// list

	@RequestMapping(value = "/findAllEnfantEtablissement", method=RequestMethod.GET)
	public List<Enfant> findAllEnfantEtablissement(long idEtablissement) {
		return service.findAllEnfantEtablissement(idEtablissement);
	}

	@RequestMapping(value = "/findAllFicheEtablissement", method=RequestMethod.GET)
	public List<Fiche> findAllFicheEtablissement(long idEtablissement) {
		return service.findAllFicheEtablissement(idEtablissement);
	}

	@RequestMapping(value = "/findAllFichePrincipaleEtablissement", method=RequestMethod.GET)
	public List<FichePrincipale> findAllFichePrincipaleEtablissement(long idEtablissement) {
		return service.findAllFichePrincipaleEtablissement(idEtablissement);
	}

	@RequestMapping(value = "/findAllFicheMedicalEtablissement", method=RequestMethod.GET)
	public List<FicheMedical> findAllFicheMedicalEtablissement(long idEtablissement) {
		return service.findAllFicheMedicalEtablissement(idEtablissement);
	}
	
	@RequestMapping(value = "/findAllFicheVaccinEtablissement", method=RequestMethod.GET)
	public List<FicheVaccin> findAllFicheVaccinEtablissement(long idEtablissement) {
		return service.findAllFicheVaccinEtablissement(idEtablissement);
	}
	// demande

	@SuppressWarnings("null")
	@RequestMapping(value = "/createDemande")
	public Demande createDemande(long idFiche,long idEtablissement) {
		Demande d = new Demande();
		service.createDemande(d);
		d.setMaDemandeFiche((Fiche) service.getFiche(idFiche));
		d.setMaDemandeEtablissement((Etablissement) service.getEtablissement(idEtablissement));
		service.updateDemande(d);
		return d;
		
	}

	@RequestMapping(value = "/deleteDemande")
	public void deleteDemande(Demande d) {
		service.deleteDemande(d);
	}

	@RequestMapping(value = "/getDemande")
	public Demande getDemande(long idDemande) {
		return service.getDemande(idDemande);
	}

	@RequestMapping(value = "/findAllDemandeEtablissement")
	public List<Demande> findAllDemandeEtablissement(long idEtablissement) {
		return service.findAllDemandeEtablissement(idEtablissement);
	}

	// connexion

	@RequestMapping(value = "/connexionEtablissement")
	public Etablissement connexionEtablissement(Connexion c) {
		return service.connexionEtablissement(c.getLogin(), c.getMdp());
	}

	@RequestMapping(value = "/createConnexionEtablissement")
	public void createConnexion(Connexion c) {
		service.createConnexion(c);
	}

	@RequestMapping(value = "/linkConnexionEtablissement")
	public void linkConnexionResponsable(long idEtablissement, long idConnexion) {
		Etablissement e;
		e = (Etablissement) service.getEtablissement(idEtablissement);
		e.setMaConnexion(service.getConnexion(idConnexion));
		try {
			service.updateCentreLoisirs((EtablissementCentreLoisir) e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}
		try {
			service.updateEcole((EtablissementEcole) e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}
		try {
			service.updateClub((EtablissementClub) e);
		} catch (Exception e1) {
			// TODO Auto-generated catch block

		}

	}

	@RequestMapping(value = "/updateConnexion")
	public Connexion updateConnexion(Connexion c) {
		return service.updateConnexion(c);
	}
}
