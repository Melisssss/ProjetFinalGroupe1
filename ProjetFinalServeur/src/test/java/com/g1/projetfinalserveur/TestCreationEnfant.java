package com.g1.projetfinalserveur;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.g1.projetfinalserveur.dao.EnfantDAO;
import com.g1.projetfinalserveur.dao.ResponsableDAO;
import com.g1.projetfinalserveur.metier.Enfant;
import com.g1.projetfinalserveur.metier.Responsable;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TestCreationEnfant {
	@Autowired
	EnfantDAO enfantDao;
	@Autowired
	ResponsableDAO responsableDao;

	@Test
	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCreateEnfant() {
		Enfant e = new Enfant();
		e.setNom("PER");
		e.setPrenom("Xavi");
		e.setDateDeNaissance("02022000");
		enfantDao.save(e);
	}
	
	@Test
	public void testCreateResponsable() {
		Responsable r = new Responsable();
		r.setNom("Responsable");
		r.setPrenom("Resp");
		r.setAdresse("adresse1");
		r.setCodePostal("zinzinland");
		r.setVille("zinzin");
		Responsable rtest = responsableDao.save(r);
		System.out.println(rtest.equals(r));
	}
	
	@Test
	public void testUpdateResponsable() {
		Responsable r = responsableDao.findById(2L).get();
		r.setNom("Nouveau NOM");
		responsableDao.saveAndFlush(r);
	}
	@Test
	public void testDeleteResponsable() {
		Responsable r = responsableDao.findById(2L).get();
		r.setNom("Nouveau NOM");
		responsableDao.delete(r);
	}
}
