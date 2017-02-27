package org.demo.formation.librairie.service.view;

import java.util.Date;

import org.demo.formation.librairie.util.DepartementEnum;

public class EleveView {
	private Long idEleve;

	private String nom;

	private String prenom;
	
	private String email;
	
	private String password;
	
	private Integer codePostal;
	
	private Integer codeDepartement;
	
	private int sexe;
	
	private Date dateInscription;

	public Long getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(Long idEleve) {
		this.idEleve = idEleve;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public Integer getCodeDepartement() {
		return codeDepartement;
	}

	public void setCodeDepartement(Integer codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	public int getSexe() {
		return sexe;
	}

	public void setSexe(int sexe) {
		this.sexe = sexe;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	
	public String getLibDepartement(){
		return DepartementEnum.getLibByCodeDepartement(this.codeDepartement);
	}
	
	public String toString(){
		String genre = this.sexe == 1 ? "M.":"Mme";
		return genre +" "+ this.nom + " PRENOM :"+ this.prenom + " EST DANS LE "+ this.codePostal + " AVECE EMAIL :"+ this.email;
	}
}
