package org.demo.formation.librairie.dao;

import java.util.List;

import org.demo.formation.librairie.entity.common.IEntity;
/**
 * Interface parametrique exposant les services CRUD du socle
 * @author CHZOME
 *
 * @param <E> : Type param�trique representant la classe M�tier manipulee
 */
public interface IAbstractEntityDAO<E extends IEntity> {

	/**
	 * Cree ou met � jour une entit�
	 * @param entity : Entit� � mettre � jour
	 * @return
	 */
	public E createUpdateEntity(E entity);
	/**
	 * Recupere une entit� par son identifiant
	 * @param idEntity : Identifiant technique de l'entit� � r�cuperer
	 * @return
	 */
	public E getEntityById(Long idEntity);
	/**
	 * Recup�re l'ensemble des entit�s en base
	 * @return
	 */
	public List<E> findAll();
	/**
	 * Supprimer une entit� par son identifiant
	 * @param idToDelete : Identifiant de l'entit� � supprimer
	 */
	public void deleteById(Long idToDelete); 
}
