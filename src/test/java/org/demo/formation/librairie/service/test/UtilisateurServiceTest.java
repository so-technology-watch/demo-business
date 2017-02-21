package org.demo.formation.librairie.service.test;

import java.util.List;

import org.demo.formation.librairie.bean.provider.FactoryServiceProvider;
import org.demo.formation.librairie.entity.Utilisateur;
import org.demo.formation.librairie.service.IUtilisateurService;
import org.demo.formation.librairie.service.impl.UtilisateurServiceImpl;
import org.junit.Assert;
import org.junit.Test;


public class UtilisateurServiceTest {

	
	
	private IUtilisateurService userService = FactoryServiceProvider.getService(UtilisateurServiceImpl.class);
	
	@Test
	public void testGetAllUser(){
		List<Utilisateur> listeUsers = this.userService.findAll();
		for (Utilisateur currentUser : listeUsers) {
			System.out.println(currentUser);
		}
		Assert.assertTrue(listeUsers.size() >0);
	}
	
	@Test
	public void testLoginUser(){
		Utilisateur user = this.userService.getUserByEmailAndPassword("christophe.zome@sogeti.com", "czo");
		Assert.assertTrue(user != null);
		user = this.userService.getUserByEmailAndPassword("christophe.zome@sogeti.com", "cfvb");
		Assert.assertFalse(user != null);
	}
}
