package org.demo.formation.librairie.entity;

public class NoteId {
	
	private Cours coursConcerne;
	private Eleve eleveConcerne;
	
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
}
