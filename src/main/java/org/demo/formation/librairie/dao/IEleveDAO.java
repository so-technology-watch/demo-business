package org.demo.formation.librairie.dao;

import org.demo.formation.librairie.entity.Eleve;
/**
 * Interface exposant les services d'acces aux données liées à l'utilisateur
 * @author CHZOME
 *
 */
public interface IEleveDAO extends IAbstractEntityDAO<Long,Eleve>{

	/**
	 * Recupère un utilisateur par son email et password
	 * @param email : Email pour lequel on souhaiter recuperer l'utilisateur correspondant
	 * @param password : Mot de passe de l'utilisateur recherché
	 * @return
	 */
	public Eleve getUserByEmailAndPassword(String email,String password);
	/**
	 * Verif qu'un email n'existe pas déjà en base
	 * @param idUser : Identifiant fourni dans le cas d'une mise à jour
	 * @param email : Email dont on cherche l'existence en base
	 * @return
	 */
	public Boolean verifSiEmailExiste(Long idUser,String email);
}
