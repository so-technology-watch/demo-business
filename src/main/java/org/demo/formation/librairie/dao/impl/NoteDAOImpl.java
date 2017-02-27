package org.demo.formation.librairie.dao.impl;

import org.demo.formation.librairie.dao.INoteDAO;
import org.demo.formation.librairie.entity.Note;
import org.demo.formation.librairie.entity.NoteId;

public class NoteDAOImpl extends AbstractEntityImpl<NoteId,Note> implements INoteDAO{

	public NoteDAOImpl() {
		super(Note.class); 
	}

	@Override
	public void setEntityIdIfNecessary(Note entity) {
	}
	
}
