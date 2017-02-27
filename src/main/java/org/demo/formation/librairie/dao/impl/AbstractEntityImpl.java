package org.demo.formation.librairie.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.demo.formation.librairie.dao.IAbstractEntityDAO;
import org.demo.formation.librairie.entity.common.IEntity;
import org.demo.formation.librairie.util.PersistenceSingleton;

public abstract class AbstractEntityImpl<TypeID,E extends IEntity<TypeID>> implements IAbstractEntityDAO<TypeID,E>{

	final Class<E> typeParameterClass;


	public AbstractEntityImpl(Class<E> typeParameterClass){
		this.typeParameterClass = typeParameterClass; 
	} 

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TypeID createUpdateEntity(E entity) {
		this.setEntityIdIfNecessary(entity);
		String entityKey = typeParameterClass.getSimpleName() + entity.getEntityId();
		HashMap<String, IEntity<TypeID>> mapEntity =  (HashMap<String, IEntity<TypeID>>) PersistenceSingleton.getInstance().getStoreData();
		mapEntity.put(entityKey, entity);
		PersistenceSingleton.getInstance().setStoreData(mapEntity); 
		return entity.getEntityId();
	}

	@SuppressWarnings("unchecked")
	public E getEntityById(TypeID idEntity) {
		HashMap<String, IEntity<TypeID>> mapEntity =  (HashMap<String, IEntity<TypeID>>) PersistenceSingleton.getInstance().getStoreData();
		for(Entry<String, IEntity<TypeID>> entry : mapEntity.entrySet()) {
			String entityKey = typeParameterClass.getSimpleName() + idEntity; 
		    String key = entry.getKey();
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
		HashMap<String, IEntity<TypeID>> mapEntity = (HashMap<String, IEntity<TypeID>>) PersistenceSingleton.getInstance().getStoreData();
		for(Entry<String, IEntity<TypeID>> entry : mapEntity.entrySet()) {
		    String key = entry.getKey();
		    E value = (E)entry.getValue();
		    if (key.contains(typeParameterClass.getSimpleName())){
		    	entityList.add(value);
		    }
		}
		return entityList;  
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void deleteById(TypeID idToDelete) {
		HashMap<String, IEntity<TypeID>> mapEntity = (HashMap<String, IEntity<TypeID>>) PersistenceSingleton.getInstance().getStoreData();
		String entityKey = typeParameterClass.getSimpleName() + idToDelete;
		mapEntity.remove(entityKey);
		PersistenceSingleton.getInstance().setStoreData(mapEntity); 
	}
	
	public abstract void setEntityIdIfNecessary(E entity);
}
