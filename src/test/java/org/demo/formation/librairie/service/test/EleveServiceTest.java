package org.demo.formation.librairie.service.test;

import java.util.List;

import org.demo.formation.librairie.bean.provider.FactoryServiceProvider;
import org.demo.formation.librairie.service.IEleveService;
import org.demo.formation.librairie.service.impl.EleveServiceImpl;
import org.demo.formation.librairie.service.view.EleveView;
import org.junit.Assert;
import org.junit.Test;


public class EleveServiceTest {

	
	
	private IEleveService userService = FactoryServiceProvider.getService(EleveServiceImpl.class);
	
	@Test
	public void testGetAllUser(){
		List<EleveView> listeUsers = this.userService.findAll();
		for (EleveView currentUser : listeUsers) {
			System.out.println(currentUser);
		}
		Assert.assertTrue(listeUsers.size() >0);
	}
	
	@Test
	public void testLoginUser(){
		EleveView user = this.userService.getUserByEmailAndPassword("christophe.zome@sogeti.com", "czo");
		Assert.assertTrue(user != null);
		user = this.userService.getUserByEmailAndPassword("christophe.zome@sogeti.com", "cfvb");
		Assert.assertFalse(user != null);
	}
}
