package org.demo.formation.librairie.service.impl;

import java.util.List;

import org.demo.formation.librairie.dao.IAbstractEntityDAO;
import org.demo.formation.librairie.entity.common.IEntity;
import org.demo.formation.librairie.service.IAbstractService;

public abstract class AbstractServiceImpl<E extends IEntity, IDAO extends IAbstractEntityDAO<E>> implements IAbstractService<E> {

	private IDAO myDAO = null;
	
	public E createUpdateEntity(E entity) {
		// TODO Auto-generated method stub
		return this.myDAO.createUpdateEntity(entity);
	}

	public E getEntityById(Long idEntity) {
		// TODO Auto-generated method stub
		return this.myDAO.getEntityById(idEntity);
	}

	public List<E> findAll() {
		// TODO Auto-generated method stub
		return this.myDAO.findAll();
	}

	public void deleteById(Long idToDelete) {
		// TODO Auto-generated method stub
		this.myDAO.deleteById(idToDelete);
	}

	public void setMyDAO(IDAO myDAO) {
		this.myDAO = myDAO;
	}

}
