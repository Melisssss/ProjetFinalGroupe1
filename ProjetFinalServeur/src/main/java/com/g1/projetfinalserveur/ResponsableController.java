package com.g1.projetfinalserveur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.g1.projetfinalserveur.metier.Connexion;
import com.g1.projetfinalserveur.metier.Demande;
import com.g1.projetfinalserveur.metier.Enfant;
import com.g1.projetfinalserveur.metier.EtablissementCentreLoisir;
import com.g1.projetfinalserveur.metier.EtablissementEcole;
import com.g1.projetfinalserveur.metier.Fiche;
import com.g1.projetfinalserveur.metier.FicheImage;
import com.g1.projetfinalserveur.metier.FicheMedical;
import com.g1.projetfinalserveur.metier.FichePrincipale;
import com.g1.projetfinalserveur.metier.FicheVaccin;
import com.g1.projetfinalserveur.metier.Mere;
import com.g1.projetfinalserveur.metier.Pere;
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

	public IserviceResponsable getService() {
		return service;
	}
	public void setService(IserviceResponsable service) {
		this.service = service;
	}
	public IserviceEtablissement getServiceE() {
		return serviceE;
	}
	public void setServiceE(IserviceEtablissement serviceE) {
		this.serviceE = serviceE;
	}
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
	@RequestMapping(value="/listResponsable")
	public List<Responsable> findResponsables(Responsable r){
		return service.findResponsables();
	}
	@RequestMapping(value = "/deleteResponsable", method=RequestMethod.POST)
	public void deleteResponsable(@RequestParam long idResponsable) {
		Responsable r = service.getResponsable(idResponsable);
		service.deleteResponsable(r);
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
	@RequestMapping(value="/listEnfant")
	public List<Enfant> findEnfants (@RequestBody Enfant e){
		return service.findEnfants();
	}
//	@RequestMapping(value = "/deleteEnfant", method=RequestMethod.DELETE)
//	public void deleteEnfant(@RequestParam long idEnfant) {
//		Enfant e = service.getEnfant(idEnfant);
//		service.deleteEnfant(e);
//	}
	@RequestMapping(value = "/deleteEnfant", method=RequestMethod.DELETE)
	public void deleteEnfant(long idEnfant) {
//		Enfant e = service.getEnfant(idEnfant);
		service.deleteEnfant(idEnfant);;
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

	// ****************************Famille****************************
	@RequestMapping(value="/saveMere", method=RequestMethod.POST)
	public Mere saveMere(@RequestBody Mere m){
		service.createMere(m);
		return m;
	}
	@RequestMapping(value="/updateMere", method=RequestMethod.POST)
	public Mere updateMere(@RequestBody Mere m) {
		service.updateMere(m);
		return m;
	}
	@RequestMapping(value="/deleteMere", method=RequestMethod.POST)
	public void deleteMere(@RequestParam long idMere) {
		Mere m = service.getMere(idMere);
		service.deleteMere(m);
	}
	@RequestMapping(value="/getMere")
	public Mere getMere(long idMere) {
		return service.getMere(idMere);
	}
	
	@RequestMapping(value="/savePere", method=RequestMethod.POST)
	public Pere savePere(@RequestBody Pere p){
		service.createPere(p);
		return p;
	}
	@RequestMapping(value="/updatePere", method=RequestMethod.POST)
	public Pere updatePere(@RequestBody Pere p) {
		service.updatePere(p);
		return p;
	}
	@RequestMapping(value="/deletePere", method=RequestMethod.POST)
	public void deletePere(@RequestParam long idPere) {
		Pere p = service.getPere(idPere);
		service.deletePere(p);
	}
	@RequestMapping(value="/getPere")
	public Pere getPere(long idPere) {
		return service.getPere(idPere);
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
	@RequestMapping(value = "/deleteFichePrincipale", method=RequestMethod.POST)
	public void deleteFichePrincipale(@RequestParam long idFichePrincipale) {
		FichePrincipale  fp = service.getFichePrincipale(idFichePrincipale);
		service.deleteFichePrincipale(fp);
	}
	@RequestMapping(value = "/getFichePrincipal", method=RequestMethod.POST)
	public FichePrincipale getFichePrincipal(@RequestBody long idFiche) {
		return service.getFichePrincipale(idFiche);
	}
	@RequestMapping(value="/listFichePrincipale")
	public List<FichePrincipale> findFichePrincipales(FichePrincipale fp){
		return service.findFichePrincipales();
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
	
	// ***********************************ficheMedical*********************
	
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
	@RequestMapping(value = "/deleteFicheMedical", method=RequestMethod.POST)
	public void deleteFicheMedical(@RequestParam long idFicheMedical) {
		FicheMedical  fm = service.getFicheMedical(idFicheMedical);
		service.deleteFicheMedical(fm);
	}
	@RequestMapping(value = "/getFicheMedical", method=RequestMethod.POST)
	public FicheMedical getFicheMedical(@RequestBody long idFiche) {
		return service.getFicheMedical(idFiche);
	}
	@RequestMapping(value="/listFicheMedical")
	public List<FicheMedical> findFicheMedicals(FicheMedical fm){
		return service.findFicheMedicals();
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
	
	// ***********************************ficheVaccin*********************
	
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
	@RequestMapping(value = "/deleteFicheVaccin", method=RequestMethod.POST)
	public void deleteFicheVaccin(@RequestParam long idFicheVaccin) {
		FicheVaccin  fv = service.getFicheVaccin(idFicheVaccin);
		service.deleteFicheVaccin(fv);
	}
	@RequestMapping(value = "/getFicheVaccin", method=RequestMethod.POST)
	public FicheVaccin getFicheVaccin(@RequestBody long idFiche) {
		return service.getFicheVaccin(idFiche);
	}
	@RequestMapping(value="/listFicheVaccin")
	public List<FicheVaccin> findFicheVaccins(FicheVaccin fv){
		return service.findFicheVaccins();
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
	
	// ***********************************ficheImage*********************
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
	@RequestMapping(value = "/deleteFicheImage", method=RequestMethod.POST)
	public void deleteFicheImage(@RequestParam long idFicheImage) {
		FicheImage  fi = service.getFicheImage(idFicheImage);
		service.deleteFicheImage(fi);
	}
	@RequestMapping(value = "/getFicheImage", method=RequestMethod.POST)
	public FicheImage getFicheImage(@RequestBody long idFiche) {
		return service.getFicheImage(idFiche);
	}
	@RequestMapping(value="/listFicheImage")
	public List<FicheImage> findFicheImages(FicheImage fi){
		return service.findFicheImages();
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
	
	// ***********************************ECOLE*********************
	
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
	
	// ****************EtablissementCentreLoisir********************//

	@RequestMapping(value = "/saveEtablissementCentreLoisir")
	public EtablissementCentreLoisir saveEtablissementCentreLoisir(EtablissementCentreLoisir ee) {
		serviceE.createCentreLoisir(ee);
		return ee;
	}

	@RequestMapping(value = "/updateEtablissementCentreLoisir")
	public EtablissementCentreLoisir updateEtablissementCentreLoisir(EtablissementCentreLoisir cl) {
		serviceE.updateCentreLoisir(cl);
		return cl;
	}

	@RequestMapping(value = "/listEtablissementCentreLoisir")
	public List<EtablissementCentreLoisir> listEtablissementCentreLoisir() {
		return serviceE.findCentreLoisirs();
	}

	@RequestMapping(value = "/getEtablissementCentreLoisir")
	public EtablissementCentreLoisir getEtablissementCentreLoisir(long idEtablissement) {
		return serviceE.getCentreLoisir(idEtablissement);
	}

	@RequestMapping(value = "/linkEtablissementCentreLoisirEnfant")
	public void linkEtablissementCentreLoisirEnfant(long idEnfant, long idEtablissement) {
		Enfant e;
		e = service.getEnfant(idEnfant);
		e.getMesEtablissementsEnfant().add(serviceE.getCentreLoisir(idEtablissement));
		service.updateEnfant(e);
	}

	@RequestMapping(value = "/findAllCentreLoisirFiche")
	public List<EtablissementCentreLoisir> findAllCentreLoisirFiche(long idFiche) {
		// TODO Auto-generated method stub
		return service.findAllCentreLoisirFiche(idFiche);
	}

	@RequestMapping(value = "/findAllCentreLoisirEnfant")
	public List<EtablissementCentreLoisir> findAllCentreLoisirEnfant(@Param("x") long idEnfant) {
		return service.findAllCentreLoisirEnfant(idEnfant);
	}

	// *******************Demande*********************************//

		@RequestMapping(value = "/saveDemande")
		public Demande saveDemande(Demande ee) {
			serviceE.createDemande(ee);
			return ee;
		}

		@RequestMapping(value = "/getDemande")
		public Demande getDemande(long idDemande) {
			return serviceE.getDemande(idDemande);
		}

		@RequestMapping(value = "/findAllDemandeEtablissement")
		public List<Demande> findAllDemandeEtablissement(long idEtablissement) {
			return serviceE.findAllDemandeEtablissement(idEtablissement);
		}

		@RequestMapping(value = "/updateDemande")
		public Demande updateDemande(Demande d) {
			serviceE.updateDemande(d);
			return d;
		}

	
		// *************connexion************************//

		@RequestMapping(value = "/createConnexion")
		public Connexion CreateConnexion(Connexion c) {
			service.createConnexion(c);
			return service.getConnexion(c.getIdConnexion());
		}

		@RequestMapping(value = "/findResponsable")
		public Responsable findResponsable(Connexion c) {
			return service.findResponsable(c.getLogin(), c.getMdp());
		}

		@RequestMapping(value = "/findMaConnexion")
		public Connexion findMaConnexion(Connexion c) {
			return service.findMaConnexion(c.getLogin(), c.getMdp());
		}

		@RequestMapping(value = "/findObjectConnexion")
		public Object findObjectConnexion(String login, String mdp) {
			return service.findObjectConnexion(login, mdp);

		}
		
		// *************AnnuleAttribution************************//
		
		@RequestMapping(value = "/annuleAttributionFicheEtablissement")

		public void annuleAttributionFichePrincipaleEtablissement(long idFiche, long idEtablissement) {
			Object f;
			Object e;
			e = service.getEtablissement(idEtablissement);
			f = service.getFiche(idFiche);
			
			((Fiche) f).getMesEtablissementsFiche().remove(e);
			
			try {
				service.updateFichePrincipale((FichePrincipale) f);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				
			}
			try {
				service.updateFicheMedical((FicheMedical) f);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				
			}
			try {
				service.updateFicheVaccin((FicheVaccin) f);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				
			}
			try {
				service.updateFicheImage((FicheImage) f);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				
			}

		}
		// ****************************************//
		@RequestMapping(value = "/getFiche")
		public Object getFiche(long idFiche) {
			return service.getFiche(idFiche);
		}
		
		@RequestMapping(value = "/getEtablissement")
		public Object getEtablissement(long idEtablissement) {
			return service.getEtablissement(idEtablissement);
		}

	

}
