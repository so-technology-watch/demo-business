package org.demo.formation.librairie.entity;

import java.io.Serializable;

import org.demo.formation.librairie.entity.common.IEntity;

public class Cours implements Serializable,IEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
	 * 
	 */
	private Long idCours;
	private String libelle;
	private Integer nbHeures;
	
	public Cours(){
			}
	
	public Cours(Long idCours, String libelle, Integer nbHeures) {
		super();
		this.idCours = idCours;
		this.libelle = libelle;
		this.nbHeures = nbHeures;
	}
	
	public Long getIdCours() {
		return idCours;
	}
	public void setIdCours(Long idCours) {
		this.idCours = idCours;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Integer getNbHeures() {
		return nbHeures;
	}
	public void setNbHeures(Integer nbHeures) {
		this.nbHeures = nbHeures;
	}
	public Long getEntityId() {
		// TODO Auto-generated method stub
		return this.idCours;
	}
	public void setEntityId(Long id) {
		this.idCours = id;
	}
	
	public String toString(){
		return "ID ="+this.idCours +"| LIB ="+this.libelle+ "| HEURES :"+this.nbHeures;
	}
}
