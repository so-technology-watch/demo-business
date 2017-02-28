package org.demo.formation.librairie.dao.impl;

import java.util.List;

import org.demo.formation.librairie.dao.ICoursDAO;
import org.demo.formation.librairie.entity.Cours;

public class CoursDAOImpl extends AbstractEntityImpl<Long,Cours> implements ICoursDAO{

	public CoursDAOImpl() {
		super(Cours.class); 
		this.initCours();
	}
	
	
	private void initCours(){
		List<Cours> liste = this.findAll();
		if (liste == null || liste.size() == 0){
		Cours c1 = new Cours(System.nanoTime(), "MATHEMATIQUES", 30);
		Cours c2 = new Cours(0L, "INFORMATIQUE", 70);
		Cours c3 = new Cours(System.nanoTime(), "PHILOSOPHIE", 25);
		Cours c4 = new Cours(System.nanoTime(), "ANGLAIS", 35);
		Cours c5 = new Cours(System.nanoTime(), "COMMUNICATION", 60);
		this.createUpdateEntity(c1);
		this.createUpdateEntity(c2);
		this.createUpdateEntity(c3);
		this.createUpdateEntity(c4);
		this.createUpdateEntity(c5);
		}
	}


	@Override
	public void setEntityIdIfNecessary(Cours entity) {
		if (entity.getEntityId() == null){
			long nextId = System.nanoTime();
			entity.setEntityId((nextId));
		}
	}
}
