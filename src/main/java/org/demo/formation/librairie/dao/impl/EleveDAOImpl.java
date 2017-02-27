package org.demo.formation.librairie.dao.impl;

import java.util.Date;
import java.util.List;

import org.demo.formation.librairie.dao.IEleveDAO;
import org.demo.formation.librairie.entity.Eleve;
import org.demo.formation.librairie.util.DepartementEnum;
import org.demo.formation.librairie.util.GenreEnum;

public class EleveDAOImpl  extends AbstractEntityImpl<Long,Eleve> implements IEleveDAO{

	public EleveDAOImpl() { 
		super(Eleve.class); 
		initUserList();
		//Juste pour initialiser la liste des cours via le constructeur
	}

	public Eleve getUserByEmailAndPassword(String email, String password) {
		List<Eleve> userList = this.findAll();
		for (Eleve currentUser : userList) {
			if (currentUser.getEmail().equalsIgnoreCase(email) && currentUser.getPassword().equalsIgnoreCase(password)){
				return currentUser;
			}
		}
		return null;
	}

	public Boolean verifSiEmailExiste(Long idUser, String email) {
		List<Eleve> userList = this.findAll();
		if (idUser != null){
			for (Eleve currentUser : userList) {
				if (currentUser.getEmail().equalsIgnoreCase(email)
						&& !currentUser.getIdEleve().equals(idUser)){
					return true;
				}
			}
		}else {
			for (Eleve currentUser : userList) {
				if (currentUser.getEmail().equalsIgnoreCase(email)){
					return true;
				}
			}
		}
		return false;
	}


	private void initUserList(){
		List<Eleve> liste = this.findAll();
		if (liste == null || liste.size() == 0){
			Eleve user = new Eleve();
			user.setNom("GUERIN");
			user.setPrenom("Laurent");
			user.setEmail("admin@sogeti.com");
			user.setCodePostal(81000);
			user.setDateInscription(new Date());
			user.setPassword("admin");
			user.setSexe(GenreEnum.GENRE_HOMME.getCodeGenre());
			user.setCodeDepartement(DepartementEnum.DEP_INFORMATIQUE.getCodeDepartement());
			user.setIdEleve(0L);
			this.createUpdateEntity(user);

			Eleve user2 = new Eleve();
			user2.setNom("TARTEMPION");
			user2.setPrenom("Gregoire");
			user2.setEmail("tartempion.gregoire@yahoo.fr");
			user2.setCodePostal(95000);
			user2.setDateInscription(new Date());
			user2.setPassword("tgreg");
			user2.setSexe(GenreEnum.GENRE_HOMME.getCodeGenre());
			user2.setCodeDepartement(DepartementEnum.DEP_ENTRETIEN.getCodeDepartement());
			this.createUpdateEntity(user2);

			Eleve user3 = new Eleve();
			user3.setNom("ZOME");
			user3.setPrenom("Christophe");
			user3.setEmail("christophe.zome@sogeti.com");
			user3.setCodePostal(35700);
			user3.setDateInscription(new Date());
			user3.setPassword("czo");
			user3.setSexe(GenreEnum.GENRE_HOMME.getCodeGenre());
			user3.setCodeDepartement(DepartementEnum.DEP_INFORMATIQUE.getCodeDepartement());
			user3.setIdEleve(1985L);
			this.createUpdateEntity(user3);

			Eleve user4 = new Eleve();
			user4.setNom("DIARD");
			user4.setPrenom("Solene");
			user4.setEmail("solene.diard@sogeti.com");
			user4.setCodePostal(44340);
			user4.setDateInscription(new Date());
			user4.setPassword("sod");
			user4.setSexe(GenreEnum.GENRE_FEMME.getCodeGenre());
			user4.setCodeDepartement(DepartementEnum.DEP_INFORMATIQUE.getCodeDepartement());
			this.createUpdateEntity(user4);
		}
	}

	@Override
	public void setEntityIdIfNecessary(Eleve entity) {
		if (entity.getEntityId() == null){
			long nextId = System.nanoTime();
			entity.setEntityId((nextId));
		}
	}
}
