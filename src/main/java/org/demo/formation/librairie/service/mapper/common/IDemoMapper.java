package org.demo.formation.librairie.service.mapper.common;

import java.util.List;

/**
 * 
 * @author chzome
 *
 * @param <View> : Type de la Vue à mapper
 * @param <Entity> : Type de l'entité à mapper
 */
public interface IDemoMapper<View,Entity> {

	/**
	 * Methode permettant de mapper une vue depuis une entité
	 * @param ent : Entité à mapper vers la vue
	 * @return
	 */
	public View mapViewFromEntity(Entity ent);
	/**
	 * Permet de mapper une vue vers une entité
	 * @param view : Vue à mapper vers l'entité
	 * @return
	 */
	public Entity mapEntityFromView(View view);
	
	/**
	 * Map Entity List to View List
	 * @param list : Entity List to Map
	 * @return
	 */
	public List<View> mapListViewFromListEntity(List<Entity> list);
	/**
	 * Map View List to Entity List
	 * @param list : View List to map
	 * @return
	 */
	public List<Entity> mapListEntityFromListView(List<View> list);
}
