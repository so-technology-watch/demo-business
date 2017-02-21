package org.demo.formation.librairie.dao.impl;

import java.util.Date;
import java.util.List;

import org.demo.formation.librairie.dao.IUtilisateurDAO;
import org.demo.formation.librairie.entity.Utilisateur;
import org.demo.formation.librairie.util.DepartementEnum;
import org.demo.formation.librairie.util.GenreEnum;
import org.demo.formation.librairie.util.PersistenceSingleton;

public class UtilisateurDAOImpl extends AbstractEntityImpl<Utilisateur> implements IUtilisateurDAO{


	public UtilisateurDAOImpl() {
		super(Utilisateur.class); 
		initUserList();
	}

	public Utilisateur getUserByEmailAndPassword(String email, String password) {
		List<Utilisateur> userList = this.findAll();
		for (Utilisateur currentUser : userList) {
			if (currentUser.getEmail().equalsIgnoreCase(email) && currentUser.getPassword().equalsIgnoreCase(password)){
				return currentUser;
			}
		}
		return null;
	}

	public Boolean verifSiEmailExiste(Long idUser, String email) {
		List<Utilisateur> userList = this.findAll();
		if (idUser != null){
			for (Utilisateur currentUser : userList) {
				if (currentUser.getEmail().equalsIgnoreCase(email)
						&& !currentUser.getIdUtilisateur().equals(idUser)){
					return true;
				}
			}
		}else {
			for (Utilisateur currentUser : userList) {
				if (currentUser.getEmail().equalsIgnoreCase(email)){
					return true;
				}
			}
		}
		return false;
	}


	private void initUserList(){
		if (!PersistenceSingleton.getInstance().isStoreInit()){ 
			Utilisateur user = new Utilisateur();
			user.setNom("GUERIN");
			user.setPrenom("Laurent");
			user.setEmail("admin@sogeti.com");
			user.setCodePostal(81000);
			user.setDateInscription(new Date());
			user.setPassword("admin");
			user.setSexe(GenreEnum.GENRE_HOMME.getCodeGenre());
			user.setCodeDepartement(DepartementEnum.DEP_INFORMATIQUE.getCodeDepartement());
			user.setIdUtilisateur(0L);
			this.createUpdateEntity(user);

			Utilisateur user2 = new Utilisateur();
			user2.setNom("TARTEMPION");
			user2.setPrenom("Gregoire");
			user2.setEmail("tartempion.gregoire@yahoo.fr");
			user2.setCodePostal(95000);
			user2.setDateInscription(new Date());
			user2.setPassword("tgreg");
			user2.setSexe(GenreEnum.GENRE_HOMME.getCodeGenre());
			user2.setCodeDepartement(DepartementEnum.DEP_ENTRETIEN.getCodeDepartement());
			this.createUpdateEntity(user2);

			Utilisateur user3 = new Utilisateur();
			user3.setNom("ZOME");
			user3.setPrenom("Christophe");
			user3.setEmail("christophe.zome@sogeti.com");
			user3.setCodePostal(35700);
			user3.setDateInscription(new Date());
			user3.setPassword("czo");
			user3.setSexe(GenreEnum.GENRE_HOMME.getCodeGenre());
			user3.setCodeDepartement(DepartementEnum.DEP_INFORMATIQUE.getCodeDepartement());
			user3.setIdUtilisateur(1985L);
			this.createUpdateEntity(user3);
			
			Utilisateur user4 = new Utilisateur();
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
}
