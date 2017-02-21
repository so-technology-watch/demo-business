package org.demo.formation.librairie.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.demo.formation.librairie.dao.IAbstractEntityDAO;
import org.demo.formation.librairie.entity.common.IEntity;
import org.demo.formation.librairie.util.PersistenceSingleton;

public class AbstractEntityImpl<E extends IEntity> implements IAbstractEntityDAO<E>{

	final Class<E> typeParameterClass;


	public AbstractEntityImpl(Class<E> typeParameterClass){
		this.typeParameterClass = typeParameterClass;
	} 

	public E createUpdateEntity(E entity) {
		if (entity.getEntityId() == null){
			long nextId = System.nanoTime();
			entity.setEntityId(nextId);
		}
		String entityKey = typeParameterClass.getSimpleName() + entity.getEntityId();
		HashMap<String, IEntity> mapEntity =  PersistenceSingleton.getInstance().getStoreData();
		mapEntity.put(entityKey, entity);
		PersistenceSingleton.getInstance().setStoreData(mapEntity); 
		return entity;
	}

	public E getEntityById(Long idEntity) {
		HashMap<String, IEntity> mapEntity =  PersistenceSingleton.getInstance().getStoreData();
		for(Entry<String, IEntity> entry : mapEntity.entrySet()) {
			String entityKey = typeParameterClass.getSimpleName() + idEntity;
		    String key = entry.getKey();
		    @SuppressWarnings("unchecked")
			E value = (E)entry.getValue();
		    if (key.equals(entityKey)){
		    	return value;
		    }
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() { 
		List<E> entityList = new ArrayList<E>();
		HashMap<String, IEntity> mapEntity = PersistenceSingleton.getInstance().getStoreData();
		for(Entry<String, IEntity> entry : mapEntity.entrySet()) {
		    String key = entry.getKey();
		    E value = (E)entry.getValue();
		    if (key.contains(typeParameterClass.getSimpleName())){
		    	entityList.add(value);
		    }
		}
		return entityList; 
	}

	public void deleteById(Long idToDelete) {
		HashMap<String, IEntity> mapEntity = PersistenceSingleton.getInstance().getStoreData();
		String entityKey = typeParameterClass.getSimpleName() + idToDelete;
		mapEntity.remove(entityKey);
		PersistenceSingleton.getInstance().setStoreData(mapEntity); 
	}
}
