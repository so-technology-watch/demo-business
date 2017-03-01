package org.demo.formation.librairie.service.impl;

import java.util.List;

import org.demo.formation.librairie.dao.IAbstractEntityDAO;
import org.demo.formation.librairie.entity.common.IEntity;
import org.demo.formation.librairie.service.IAbstractService;
import org.demo.formation.librairie.service.mapper.common.IDemoMapper;

public abstract class AbstractServiceImpl<TypeID,E extends IEntity<TypeID>,ViewType, IDAO extends IAbstractEntityDAO<TypeID,E>> implements IAbstractService<TypeID,ViewType> {

	private IDAO myDAO = null;
	private IDemoMapper<ViewType, E> mapper = null;

	public TypeID createUpdateView(ViewType view) {
		// TODO Auto-generated method stub
		E entity = mapper.mapEntityFromView(view);
		return this.myDAO.createUpdateEntity(entity); 
	}

	public ViewType getViewById(TypeID idEntity) {
		// TODO Auto-generated method stub
		E entity = this.myDAO.getEntityById(idEntity);
		if (entity != null){
			ViewType view = this.mapper.mapViewFromEntity(entity);
			return view;
		}
		return null;
	}

	public List<ViewType> findAll() {
		// TODO Auto-generated method stub
		List<E> list = this.myDAO.findAll();
		List<ViewType> viewList = this.mapper.mapListViewFromListEntity(list);
		return viewList;
	}

	public void deleteById(TypeID idToDelete) {
		// TODO Auto-generated method stub
		this.myDAO.deleteById(idToDelete);
	}

	public void setMyDAO(IDAO myDAO) {
		this.myDAO = myDAO;
	}

	public void setMapper(IDemoMapper<ViewType, E> mapper) {
		this.mapper = mapper;
	}

}
