package org.demo.formation.librairie.service.test;

import java.util.List;

import org.demo.formation.librairie.bean.provider.FactoryServiceProvider;
import org.demo.formation.librairie.service.ICoursService;
import org.demo.formation.librairie.service.impl.CoursServiceImpl;
import org.demo.formation.librairie.service.view.CoursView;
import org.junit.Assert;
import org.junit.Test;

public class CoursServiceTest {


	
	private ICoursService coursService = FactoryServiceProvider.getService(CoursServiceImpl.class);
	
	@Test
	public void testGetAllCours(){
		List<CoursView> listeUsers = this.coursService.findAll();
		for (CoursView currentUser : listeUsers) {
			System.out.println(currentUser);
		}
		Assert.assertTrue(listeUsers.size() >0);
	}
}
