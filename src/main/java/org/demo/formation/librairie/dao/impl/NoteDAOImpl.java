package org.demo.formation.librairie.dao.impl;

import java.util.Date;
import java.util.List;

import org.demo.formation.librairie.dao.INoteDAO;
import org.demo.formation.librairie.entity.Note;
import org.demo.formation.librairie.entity.NoteId;

public class NoteDAOImpl extends AbstractEntityImpl<NoteId,Note> implements INoteDAO{

	public NoteDAOImpl() {
		super(Note.class); 
		this.initNote();
	}

	@Override
	public void setEntityIdIfNecessary(Note entity) {
	}

	private void initNote(){
		List<Note> liste = this.findAll();
		if (liste == null || liste.size() == 0){
			NoteId noteId = new NoteId(0L,0L);
			Note note = new Note(noteId,15.40,new Date(),3);
			this.createUpdateEntity(note);
		}
	}
}
