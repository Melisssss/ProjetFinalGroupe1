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
	

	// ********************responsable****************************
	
	@RequestMapping(value = "/saveResponsable", method=RequestMethod.POST)
	public Responsable saveResponsable(@RequestBody Responsable r) {
		service.createResponsable(r);
		return r;
	}
	@RequestMapping(value = "/updateResponsable", method=RequestMethod.POST)
	public Responsable updateResponsable(@RequestBody Responsable r) {
		service.updateResponsable(r);
		return r;
	}
	@RequestMapping(value = "/getResponsable")
	public Responsable getResponsable(long idUser) {
		return service.getResponsable(idUser);

	}
	
//	public Enfant linkEnfantResponsable(long idResponsable) {
//		Enfant e = new Enfant();
//		Responsable r = service.getResponsable(idResponsable);
//		e.setMonResponsable(r);
//		return service.updateEnfant(e);
//	}
	@RequestMapping(value = "/linkConnexionResponsable")
	public void linkConnexionResponsable(long idResponsable, long idConnexion) {
		Responsable r;
		r = service.getResponsable(idResponsable);
		r.setMaConnexion(service.getConnexion(idConnexion));
		service.updateResponsable(r);
	}
	
	
	// ****************************enfant****************************
	

	@RequestMapping(value = "/saveEnfant", method=RequestMethod.POST)
	public Enfant saveEnfant(@RequestBody Enfant e) {
		service.createEnfant(e);
		return e;
	}
	@RequestMapping(value = "/updateEnfant", method=RequestMethod.POST)
	public Enfant updateEnfant(@RequestBody Enfant e) {
		service.updateEnfant(e);
		return e;
	}

	@RequestMapping(value = "/deleteEnfant", method=RequestMethod.POST)
	public void deleteEnfant(@RequestBody long idEnfant) {
		Enfant e = service.getEnfant(idEnfant);
		service.deleteEnfant(e);
	}

	@RequestMapping(value = "/getEnfant")
	public Enfant getEnfant(long idEnfant) {
		return service.getEnfant(idEnfant);
	}
	@RequestMapping(value = "/linkEnfantResponsable")
	public void linkEnfantResponsable(long idResponsable, long idEnfant) {
		Enfant e = new Enfant();
		e = service.getEnfant(idEnfant);
		Responsable r = service.getResponsable(idResponsable);
		e.setMonResponsable(r);
		service.updateEnfant(e);
	}
	@RequestMapping(value = "/listEnfantResponsable")
	public List<Enfant> list(long idUser) {
		return service.findAllEnfantResponsable(idUser);
	}
	@RequestMapping(value = "/findAllEnfantEtablissement")
	public List<Enfant> findAllEnfantEtablissement(long idEtablissement) {
		return serviceE.findAllEnfantEtablissement(idEtablissement);
	}

	
	// ***********************************fichePrincipale*********************
	
	
	@RequestMapping(value = "/saveFichePrincipale", method=RequestMethod.POST)
	public FichePrincipale saveFichePrincipale(@RequestBody  FichePrincipale fp) {
		service.createFichePrincipale(fp);
		return fp;
	}
	@RequestMapping(value = "/updateFichePrincipale", method=RequestMethod.POST )
	public FichePrincipale updateFichePrincipale(@RequestBody FichePrincipale fp) {
		service.updateFichePrincipale(fp);
		return fp;
	}
	@RequestMapping(value = "/getFichePrincipal", method=RequestMethod.POST)
	public FichePrincipale getFichePrincipal(@RequestBody long idFiche) {
		return service.getFichePrincipale(idFiche);
	}
	@RequestMapping(value = "/listFichePrincipaleEnfant", method=RequestMethod.POST)
	public List<FichePrincipale> listFichePrincipale(@RequestBody long idEnfant) {
		return service.findAllFichePrincipaleEnfant(idEnfant);
	}
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
	}

	@RequestMapping(value = "/findAllFichePrincipaleEtablissement")
	public List<FichePrincipale> findAllFichePrincipaleEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub
		return serviceE.findAllFichePrincipaleEtablissement(idEtablissement);
	}
	
	// ***************************ficheMedical**************************

	@RequestMapping(value = "/saveFicheMedical", method=RequestMethod.POST)
	public FicheMedical saveFicheMedical(@RequestBody FicheMedical fm) {
		service.createFicheMedical(fm);
		return fm;
	}
	@RequestMapping(value = "/updateFicheMedical", method=RequestMethod.POST)
	public FicheMedical updateFicheMedical(@RequestBody FicheMedical fm) {
		service.updateFicheMedical(fm);
		return fm;
	}
	@RequestMapping(value = "/getFicheMedical", method=RequestMethod.POST)
	public FicheMedical getFicheMedical(@RequestBody long idFiche) {
		return service.getFicheMedical(idFiche);
	}
	@RequestMapping(value = "/listFicheMedicalEnfant", method=RequestMethod.POST)
	public List<FicheMedical> listFicheMedical(@RequestBody long idEnfant) {
		return service.findAllFicheMedicalEnfant(idEnfant);
	}
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

	@RequestMapping(value = "/findAllFicheMedicalEtablissement")
	public List<FicheMedical> findAllFicheMedicalEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub
		return serviceE.findAllFicheMedicalEtablissement(idEtablissement);
	}
	
	//**************************ficheVaccin***************************************
	
	
	@RequestMapping(value = "/saveFicheVaccin", method=RequestMethod.POST)
	public FicheVaccin saveFicheVaccin(@RequestBody FicheVaccin fv) {
		service.createFicheVaccin(fv);
		return fv;
	}
	@RequestMapping(value = "/updateFicheVaccin", method=RequestMethod.POST)
	public FicheVaccin updateFicheVaccin(@RequestBody FicheVaccin fv) {
		service.updateFicheVaccin(fv);
		return fv;
	}
	@RequestMapping(value = "/getFicheVaccin", method=RequestMethod.POST)
	public FicheVaccin getFicheVaccin(@RequestBody long idFiche) {
		return service.getFicheVaccin(idFiche);
	}
	@RequestMapping(value = "/listFicheVaccinEnfant", method=RequestMethod.POST)
	public List<FicheVaccin> listFicheVaccin(@RequestBody long idEnfant) {
		return service.findAllFicheVaccinEnfant(idEnfant);
	}
	@RequestMapping(value = "/linkFicheVaccinEnfant", method=RequestMethod.POST)
	public void linkFicheVaccinEnfant(@RequestBody long idEnfant, long idFiche) {

		FicheVaccin fv;
		fv = service.getFicheVaccin(idFiche);
		fv.setMonEnfant(service.getEnfant(idEnfant));
		service.updateFicheVaccin(fv);
	}
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

	@RequestMapping(value = "/findAllFicheVaccinEtablissement")
	public List<FicheVaccin> findAllFicheVaccinEtablissement(long idEtablissement) {
		// TODO Auto-generated method stub
		return serviceE.findAllFicheVaccinEtablissement(idEtablissement);
	}
	//********************************ficheImage*********************


	@RequestMapping(value = "/saveFicheImage", method=RequestMethod.POST)
	public FicheImage saveFicheImage(@RequestBody FicheImage fi) {
		service.createFicheImage(fi);
		return fi;
	}
	@RequestMapping(value = "/updateFicheImage", method=RequestMethod.POST)
	public FicheImage updateFicheImage(@RequestBody FicheImage fi) {
		service.updateFicheImage(fi);
		return fi;
	}
	@RequestMapping(value = "/getFicheImage", method=RequestMethod.POST)
	public FicheImage getFicheImage(@RequestBody long idFiche) {
		return service.getFicheImage(idFiche);
	}
	@RequestMapping(value = "/listFicheImageEnfant", method=RequestMethod.POST)
	public List<FicheImage> listFicheImage(@RequestBody long idEnfant) {
		return service.findAllFicheImageEnfant(idEnfant);
	}
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
	
	// **********************************EtablissementEcole***************
	@RequestMapping(value = "/saveEtablissementEcole", method=RequestMethod.POST)
	public EtablissementEcole saveEtablissementEcole(@RequestBody EtablissementEcole ee) {
		serviceE.createEcole(ee);
		return ee;
	}
	@RequestMapping(value = "/listEtablissementEcole")
	public List<EtablissementEcole> listEtablissementEcole() {
		return serviceE.findEcoles();
	}
	@RequestMapping(value = "/getEtablissementEcole", method=RequestMethod.POST)
	public EtablissementEcole getEtablissementEcole(@RequestBody long idEtablissement) {
		return serviceE.getEcole(idEtablissement);
	}
	
	
	
	@RequestMapping(value = "/linkEtablissementEcoleEnfant")
	public void linkEtablissementEcoleEnfant(long idEnfant, long idEtablissement) {
		Enfant e;
		e = service.getEnfant(idEnfant);
		e.getMesEtablissementsEnfant().add(serviceE.getEcole(idEtablissement));
		service.updateEnfant(e);
	}
	@RequestMapping(value = "/findAllEcoleFiche")
	public List<EtablissementEcole> findAllEcoleFiche(long idFiche) {
		// TODO Auto-generated method stub
		return service.findAllEcoleFiche(idFiche);
	}
	@RequestMapping(value = "/findAllEcoleEnfant")
	public List<EtablissementEcole> findAllEcoleEnfant(@Param("x") long idEnfant){
		return service.findAllEcoleEnfant(idEnfant);
	}

	
	// *************connexion************************//

	@RequestMapping(value = "/createConnexion")
	public Connexion CreateConnexion(Connexion c) {
		 service.createConnexion(c);
		 return service.getConnexion(c.getIdConnexion());
	}
	
	@RequestMapping(value = "/findResponsable")
	public Responsable findResponsable(Connexion c) {
		 return service.findResponsable(c.getLogin(),c.getMdp());
	}
	
	@RequestMapping(value = "/findMaConnexion")
	public  Connexion findMaConnexion(Connexion c) {
		 return service.findMaConnexion(c.getLogin(),c.getMdp());
	}
	@RequestMapping(value = "/findObjectConnexion")
	public Object findObjectConnexion(String login,String mdp) {
		return service.findObjectConnexion(login, mdp);
		
	}
	

}
