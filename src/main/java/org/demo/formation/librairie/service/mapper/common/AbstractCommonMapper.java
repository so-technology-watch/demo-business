package org.demo.formation.librairie.service.mapper.common;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public abstract class AbstractCommonMapper<View,Entity> implements IDemoMapper<View, Entity> {

	ModelMapper modelMapper = new ModelMapper();
	
	

	public View mapViewFromEntity(Entity ent) {
		return modelMapper.map(ent, this.getViewClass());
	}

	public Entity mapEntityFromView(View view) {
		// TODO Auto-generated method stub
		return modelMapper.map(view, this.getEntityClass());
	}
	
	public List<View> mapListViewFromListEntity(List<Entity> list) {
		List<View> viewList = new ArrayList<View>();
		if (list != null && list.size() >0){
			for (Entity entity : list) {
				View v = this.mapViewFromEntity(entity);
				viewList.add(v);
			}
		}
		return viewList;
	}

	public List<Entity> mapListEntityFromListView(List<View> list) {
		List<Entity> entityList = new ArrayList<Entity>();
		if (list != null && list.size() >0)
		for (View view : list) {
			Entity ent = this.mapEntityFromView(view);
			entityList.add(ent);
		}
		return entityList;
	}
	
	/**
	 * Get View Class
	 * @return
	 */
	public abstract Class<View> getViewClass();
	/**
	 * Get entity Class
	 * @return
	 */
	public abstract Class<Entity> getEntityClass();
}
