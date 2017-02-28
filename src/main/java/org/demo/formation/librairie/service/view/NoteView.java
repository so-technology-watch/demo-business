package org.demo.formation.librairie.service.view;

import java.io.Serializable;
import java.util.Date;

import org.demo.formation.librairie.util.MentionEnum;

public class NoteView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6206469103883541013L;
	private Long idCours;
	private Long idEleve;
	private Double noteObtenue;
	private Date dateExamen;
	private Integer codeMention;
	
	
	public NoteView(){
	}
	
	public NoteView(Long idC,Long idE,Double noteVal,Date dateExam,Integer codeM){
		this.idCours = idC;
		this.idEleve = idE;
		this.noteObtenue = noteVal;
		this.codeMention = codeM;
	}
	
	public Long getIdCours() {
		return idCours;
	}
	public void setIdCours(Long idCours) {
		this.idCours = idCours;
	}
	public Long getIdEleve() {
		return idEleve;
	}
	public void setIdEleve(Long idEleve) {
		this.idEleve = idEleve;
	}
	public Date getDateExamen() {
		return dateExamen;
	}
	public void setDateExamen(Date dateExamen) {
		this.dateExamen = dateExamen;
	}
	public Integer getCodeMention() {
		return codeMention;
	}
	public void setCodeMention(Integer codeMention) {
		this.codeMention = codeMention;
	}
	public Double getNoteObtenue() {
		return noteObtenue;
	}
	public void setNoteObtenue(Double noteObtenue) {
		this.noteObtenue = noteObtenue;
	}
	public String getLibMention() {
		return MentionEnum.getLibByCodeMention(this.codeMention);
	}
}
