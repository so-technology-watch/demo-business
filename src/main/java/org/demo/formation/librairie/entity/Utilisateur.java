package org.demo.formation.librairie.entity;

import java.io.Serializable;
import java.util.Date;

import org.demo.formation.librairie.entity.common.IEntity;
import org.demo.formation.librairie.util.DepartementEnum;


public class Utilisateur implements Serializable,IEntity {

	private static final long serialVersionUID = 1L;

	private Long idUtilisateur;

	private String nom;

	private String prenom;
	
	private String email;
	
	private String password;
	
	private Integer codePostal;
	
	private Integer codeDepartement;
	
	private int sexe;
	
	private Date dateInscription;

	
	

	public Utilisateur() {
		this.dateInscription = new Date();
	}
	
	public Utilisateur(Long idUtilisateur, String nom, String prenom, String email, String password,
			Integer codePostal, Integer departement, int sexe) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.codePostal = codePostal;
		this.codeDepartement = departement;
		this.sexe = sexe;
		this.dateInscription = new Date();
	}

	public Long getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}



	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getSexe() {
		return this.sexe;
	}

	public void setSexe(int sexe) {
		this.sexe = sexe;
	}
	
	public String toString(){
		String genre = this.sexe == 1 ? "M.":"Mme";
		return genre +" "+ this.nom + " PRENOM :"+ this.prenom + " EST DANS LE "+ this.codePostal + " AVECE EMAIL :"+ this.email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}


	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Integer getCodeDepartement() {
		return codeDepartement;
	}

	public void setCodeDepartement(Integer codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	public String getLibDepartement(){
		return DepartementEnum.getLibByCodeDepartement(this.codeDepartement);
	}

	public Long getEntityId() {
		// TODO Auto-generated method stub
		return this.idUtilisateur;
	}

	public void setEntityId(Long id) {
		this.idUtilisateur = id;
	}

}