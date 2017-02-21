package org.demo.formation.librairie.service.impl;


import org.apache.commons.lang.StringUtils;
import org.demo.formation.librairie.dao.IUtilisateurDAO;
import org.demo.formation.librairie.dao.impl.UtilisateurDAOImpl;
import org.demo.formation.librairie.entity.Utilisateur;
import org.demo.formation.librairie.exception.DemoBusinessException;
import org.demo.formation.librairie.service.IUtilisateurService;

/**
 * 
 * @author CHZOME
 *
 */
//@Named("userServiceBean")
public class UtilisateurServiceImpl extends AbstractServiceImpl<Utilisateur, IUtilisateurDAO> implements IUtilisateurService{

	private IUtilisateurDAO userDAO = null;

	public UtilisateurServiceImpl(){
		this.userDAO = new UtilisateurDAOImpl();
		//DAO requis par l'Abstract DAO
		this.setMyDAO(userDAO);
	}
 
	public Utilisateur getUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return this.userDAO.getUserByEmailAndPassword(email, password);
	}

	public Boolean verifSiEmailExiste(Long idUser, String email) {
		// TODO Auto-generated method stub
		return this.userDAO.verifSiEmailExiste(idUser, email);
	}

	public Utilisateur creerOuMetAJourUtilisateur(Utilisateur userACreerOuModifier) throws DemoBusinessException {
		if (userACreerOuModifier != null){
			String email = userACreerOuModifier.getEmail();
			if (StringUtils.isNotBlank(email)){
				Boolean isEmailExiste = this.userDAO.verifSiEmailExiste(userACreerOuModifier.getIdUtilisateur(), email);
				if (isEmailExiste){
					String messsagErreur = String.format("L'email que vous avez renseigné [%s] semble etre deja pris...", email);
					throw new DemoBusinessException(messsagErreur);
				}
			}
			userACreerOuModifier = this.userDAO.createUpdateEntity(userACreerOuModifier);
		}
		return userACreerOuModifier;
	}

	public void setUserDAO(IUtilisateurDAO userDAO) {
		this.userDAO = userDAO;
	}
}
