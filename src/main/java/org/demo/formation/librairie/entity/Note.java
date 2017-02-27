package org.demo.formation.librairie.entity;

import java.io.Serializable;
import java.util.Date;

import org.demo.formation.librairie.entity.common.IEntity;
import org.demo.formation.librairie.util.MentionEnum;

public class Note implements Serializable,IEntity<NoteId>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 696495986383727507L;
	private NoteId id;
	private Double noteObtenue;
	private Date dateExamen;
	private Integer codeMention;
	
	public Note(NoteId id, Double note,Date dateExamen, Integer codeMention) {
		super();
		this.id = id;
		this.noteObtenue = note;
		this.dateExamen = dateExamen;
		this.codeMention = codeMention;
	}
	
	public NoteId getId() {
		return id;
	}
	public void setId(NoteId id) {
		this.id = id;
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
	public String getLibMention() {
		return MentionEnum.getLibByCodeMention(this.codeMention);
	}
	public NoteId getEntityId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	public void setEntityId(NoteId id) {
		this.id = id;
	}

	public Double getNoteObtenue() {
		return noteObtenue;
	}

	public void setNoteObtenue(Double noteObtenue) {
		this.noteObtenue = noteObtenue;
	}
	
}
