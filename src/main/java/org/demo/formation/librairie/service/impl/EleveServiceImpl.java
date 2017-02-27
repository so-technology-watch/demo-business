package org.demo.formation.librairie.service.impl;


import org.apache.commons.lang.StringUtils;
import org.demo.formation.librairie.dao.IEleveDAO;
import org.demo.formation.librairie.dao.impl.EleveDAOImpl;
import org.demo.formation.librairie.entity.Eleve;
import org.demo.formation.librairie.exception.DemoBusinessException;
import org.demo.formation.librairie.service.IEleveService;
import org.demo.formation.librairie.service.mapper.EleveMapper;
import org.demo.formation.librairie.service.view.EleveView;

/**
 * 
 * @author CHZOME
 *
 */
//@Named("userServiceBean")
public class EleveServiceImpl extends AbstractServiceImpl<Long,Eleve,EleveView, IEleveDAO> implements IEleveService{

	private IEleveDAO userDAO = null;
	private EleveMapper eleveMapper;

	public EleveServiceImpl(){ 
		this.userDAO = new EleveDAOImpl();
		this.eleveMapper = new EleveMapper();
		//DAO requis par l'Abstract DAO
		this.setMyDAO(userDAO);
		this.setMapper(eleveMapper);
	}
 
	public EleveView getUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		Eleve eleve = this.userDAO.getUserByEmailAndPassword(email, password);
		EleveView eleveView = this.eleveMapper.mapViewFromEntity(eleve);
		return eleveView;
	}

	public Boolean verifSiEmailExiste(Long idUser, String email) {
		// TODO Auto-generated method stub
		return this.userDAO.verifSiEmailExiste(idUser, email);
	}

	public EleveView creerOuMetAJourUtilisateur(EleveView userACreerOuModifier) throws DemoBusinessException {
		if (userACreerOuModifier != null){
			String email = userACreerOuModifier.getEmail();
			if (StringUtils.isNotBlank(email)){
				Boolean isEmailExiste = this.userDAO.verifSiEmailExiste(userACreerOuModifier.getIdEleve(), email);
				if (isEmailExiste){
					String messsagErreur = String.format("L'email que vous avez renseigné [%s] semble etre deja pris...", email);
					throw new DemoBusinessException(messsagErreur);
				}
			}
			Eleve eleveEntity = this.eleveMapper.mapEntityFromView(userACreerOuModifier);
			Long idUser = this.userDAO.createUpdateEntity(eleveEntity);
			userACreerOuModifier.setIdEleve(idUser);
		}
		return userACreerOuModifier;
	}

	public void setUserDAO(IEleveDAO userDAO) {
		this.userDAO = userDAO;
	}
}
