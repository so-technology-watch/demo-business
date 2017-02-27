package org.demo.formation.librairie.service;

import java.util.List;

/**
 * 
 * @author chzome
 *
 * @param <TypeID> : Type de l'Identifiant à manipuler
 * @param <View>  : Type de la vue à manipuler
 */
public interface IAbstractService<TypeID,View> {
	/**
	 * Cree ou met à jour une entité
	 * @param entity : Entité à mettre à jour
	 * @return
	 */
	public TypeID createUpdateView(View entity);
	/**
	 * Recupere une entité par son identifiant
	 * @param idEntity : Identifiant technique de l'entité à récuperer
	 * @return
	 */
	public View getViewById(TypeID idEntity);
	/**
	 * Recupère l'ensemble des entités en base
	 * @return
	 */
	public List<View> findAll();
	/**
	 * Supprimer une entité par son identifiant
	 * @param idToDelete : Identifiant de l'entité à supprimer
	 */
	public void deleteById(TypeID idToDelete); 
}
