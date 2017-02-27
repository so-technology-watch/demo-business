package org.demo.formation.librairie.service;

import org.demo.formation.librairie.exception.DemoBusinessException;
import org.demo.formation.librairie.service.view.EleveView;

public interface IEleveService extends IAbstractService<Long,EleveView>{
	/**
	 * Recupère un utilisateur par son email et password
	 * @param email : Email pour lequel on souhaiter recuperer l'utilisateur correspondant
	 * @param password : Mot de passe de l'utilisateur recherché
	 * @return
	 */
	public EleveView getUserByEmailAndPassword(String email,String password);
	/**
	 * Verif qu'un email n'existe pas déjà en base
	 * @param idUser : Identifiant fourni dans le cas d'une mise à jour
	 * @param email : Email dont on cherche l'existence en base
	 * @return
	 */
	public Boolean verifSiEmailExiste(Long idUser,String email);
	/**
	 * Methode permettant de creer ou modifier un utilisateur
	 * @param userACreerOuModifier : Utilisateur à creer ou à modifier
	 */
	public EleveView creerOuMetAJourUtilisateur(EleveView userACreerOuModifier) throws DemoBusinessException;
}
