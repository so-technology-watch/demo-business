package org.demo.formation.librairie.service;

import java.util.List;

/**
 * 
 * @author chzome
 *
 * @param <TypeID> : Type de l'Identifiant � manipuler
 * @param <View>  : Type de la vue � manipuler
 */
public interface IAbstractService<TypeID,View> {
	/**
	 * Cree ou met � jour une entit�
	 * @param entity : Entit� � mettre � jour
	 * @return
	 */
	public TypeID createUpdateView(View entity);
	/**
	 * Recupere une entit� par son identifiant
	 * @param idEntity : Identifiant technique de l'entit� � r�cuperer
	 * @return
	 */
	public View getViewById(TypeID idEntity);
	/**
	 * Recup�re l'ensemble des entit�s en base
	 * @return
	 */
	public List<View> findAll();
	/**
	 * Supprimer une entit� par son identifiant
	 * @param idToDelete : Identifiant de l'entit� � supprimer
	 */
	public void deleteById(TypeID idToDelete); 
}
