package org.demo.formation.librairie.service.test;

import java.util.Date;

import org.demo.formation.librairie.bean.provider.FactoryServiceProvider;
import org.demo.formation.librairie.entity.Note;
import org.demo.formation.librairie.entity.NoteId;
import org.demo.formation.librairie.service.INoteService;
import org.demo.formation.librairie.service.impl.NoteServiceImpl;
import org.demo.formation.librairie.service.mapper.NoteMapper;
import org.demo.formation.librairie.service.view.NoteView;
import org.junit.Assert;
import org.junit.Test;

public class NoteServiceTest {
	private INoteService noteService = FactoryServiceProvider.getService(NoteServiceImpl.class);

	@Test
	public void testMapper(){
		NoteMapper mapper = new NoteMapper();
		NoteId noteId = new NoteId(1L,2L);
		Note note = new Note(noteId,12.40,new Date(),1);
		NoteView noteView = mapper.mapViewFromEntity(note);
		Assert.assertTrue(noteView.getCodeMention().equals(1));
	}
	
	@Test
	public void testCreateNote(){
		NoteView note = new NoteView(1L,2L,12.40,new Date(),1);
		NoteId noteId = this.noteService.createUpdateView(note);
		Assert.assertTrue(noteId.getCoursConcerne().getIdCours().equals(1L));
	}
}
