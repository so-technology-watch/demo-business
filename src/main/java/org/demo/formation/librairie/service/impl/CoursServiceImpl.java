package org.demo.formation.librairie.service.impl;

import org.demo.formation.librairie.dao.ICoursDAO;
import org.demo.formation.librairie.dao.impl.CoursDAOImpl;
import org.demo.formation.librairie.entity.Cours;
import org.demo.formation.librairie.service.ICoursService;
import org.demo.formation.librairie.service.mapper.CoursMapper;
import org.demo.formation.librairie.service.view.CoursView;

public class CoursServiceImpl extends AbstractServiceImpl<Long,Cours,CoursView,ICoursDAO> implements ICoursService{

	private ICoursDAO coursDAO = null;
	private CoursMapper coursMapper;

	
	public CoursServiceImpl(){
		this.coursDAO = new CoursDAOImpl();
		this.coursMapper = new CoursMapper();
		//DAO requis par l'Abstract DAO
		this.setMyDAO(coursDAO);
		this.setMapper(coursMapper);
	}


	public void setCoursDAO(ICoursDAO coursDAO) {
		this.coursDAO = coursDAO;
	}
	
} 
