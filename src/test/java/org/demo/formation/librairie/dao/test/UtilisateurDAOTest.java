package org.demo.formation.librairie.dao.test;

import java.util.Date;
import java.util.List;

import org.demo.formation.librairie.dao.IUtilisateurDAO;
import org.demo.formation.librairie.dao.impl.UtilisateurDAOImpl;
import org.demo.formation.librairie.entity.Utilisateur;
import org.demo.formation.librairie.util.DepartementEnum;
import org.demo.formation.librairie.util.GenreEnum;
import org.junit.Assert;
import org.junit.Test;

public class UtilisateurDAOTest {

	private IUtilisateurDAO utilisateurDAO = new UtilisateurDAOImpl();
	
	@Test
	public void testRecupAll(){
		List<Utilisateur> listeUtilisateur = this.utilisateurDAO.findAll();
		for (Utilisateur userCourant : listeUtilisateur) {
			System.out.println(userCourant);
		}
		Assert.assertTrue(listeUtilisateur.size() >0);
	}
	
	@Test
	public void testInsert(){
		Utilisateur user = new Utilisateur();
		user.setNom("LE PEN");
		user.setPrenom("Marine");
		user.setEmail("marine.lepen@fn.fr");
		user.setCodePostal(81000);
		user.setDateInscription(new Date());
		user.setPassword("lepen");
		user.setSexe(GenreEnum.GENRE_FEMME.getCodeGenre());
		user.setCodeDepartement(DepartementEnum.DEP_INFORMATIQUE.getCodeDepartement());
		Utilisateur userCree =  this.utilisateurDAO.createUpdateEntity(user);
		Assert.assertNotNull(userCree.getIdUtilisateur() != null);
	}
	
	@Test
	public void testRechercheUserParEmailAndPassword(){
		Utilisateur userCherche = this.utilisateurDAO.getUserByEmailAndPassword("czo", "passw");
		Assert.assertNull(userCherche);
		userCherche = this.utilisateurDAO.getUserByEmailAndPassword("christophe.zome@sogeti.com", "pwd_esic");
		Assert.assertNotNull(userCherche);
	}
	
	@Test
	public void testRechercheExistenceEmail(){
		Boolean isUserExiste = this.utilisateurDAO.verifSiEmailExiste(null, "czo");
		Assert.assertFalse(isUserExiste);
		isUserExiste = this.utilisateurDAO.verifSiEmailExiste(null, "christophe.zome@sogeti.com");
		Assert.assertTrue(isUserExiste);
		isUserExiste = this.utilisateurDAO.verifSiEmailExiste(1985L, "christophe.zome@sogeti.com");
		Assert.assertFalse(isUserExiste);
	}
}
