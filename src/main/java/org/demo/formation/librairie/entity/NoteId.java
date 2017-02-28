package org.demo.formation.librairie.entity;

import java.io.Serializable;

public class NoteId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1530410473751583392L;
	private Cours coursConcerne;
	private Eleve eleveConcerne;
	
	
	public NoteId(){
			}
	
	public NoteId(Long idCours, Long idEleve) {
		this.coursConcerne = new Cours(idCours,null,null);
		Eleve eleveTmp = new Eleve();
		eleveTmp.setIdEleve(idEleve);
		this.eleveConcerne = eleveTmp;
	}
	public Cours getCoursConcerne() {
		return coursConcerne;
	}
	public void setCoursConcerne(Cours coursConcerne) {
		this.coursConcerne = coursConcerne;
	}
	public Eleve getEleveConcerne() {
		return eleveConcerne;
	}
	public void setEleveConcerne(Eleve eleveConcerne) {
		this.eleveConcerne = eleveConcerne;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coursConcerne == null) ? 0 : coursConcerne.getIdCours().hashCode());
		result = prime * result + ((eleveConcerne == null) ? 0 : eleveConcerne.getIdEleve().hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoteId other = (NoteId) obj;
		if (coursConcerne == null) {
			if (other.coursConcerne != null)
				return false;
		} else if (!coursConcerne.getIdCours().equals(other.coursConcerne.getIdCours()))
			return false;
		if (eleveConcerne == null) {
			if (other.eleveConcerne != null)
				return false;
		} else if (!eleveConcerne.getIdEleve().equals(other.eleveConcerne.getIdEleve()))
			return false;
		return true;
	}
	
	
}
