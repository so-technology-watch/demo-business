package org.demo.formation.librairie.service.impl;

import org.demo.formation.librairie.dao.INoteDAO;
import org.demo.formation.librairie.dao.impl.NoteDAOImpl;
import org.demo.formation.librairie.entity.Note;
import org.demo.formation.librairie.entity.NoteId;
import org.demo.formation.librairie.service.INoteService;
import org.demo.formation.librairie.service.mapper.NoteMapper;
import org.demo.formation.librairie.service.view.NoteView;

public class NoteServiceImpl extends AbstractServiceImpl<NoteId,Note,NoteView, INoteDAO> implements INoteService{

private INoteDAO noteDAO = null;
private NoteMapper noteMapper ;

	
	public NoteServiceImpl(){
		this.noteDAO = new NoteDAOImpl();
		this.noteMapper = new NoteMapper();
		//DAO requis par l'Abstract DAO
		this.setMyDAO(noteDAO); 
		this.setMapper(noteMapper);
	}


	public void setNoteDAO(INoteDAO noteDAO) {
		this.noteDAO = noteDAO;
	}
}
