package org.demo.formation.librairie.service.mapper;

import org.demo.formation.librairie.entity.Note;
import org.demo.formation.librairie.entity.NoteId;
import org.demo.formation.librairie.service.mapper.common.AbstractCommonMapper;
import org.demo.formation.librairie.service.mapper.common.IDemoMapper;
import org.demo.formation.librairie.service.view.NoteView;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class NoteMapper extends AbstractCommonMapper<NoteView,Note> implements IDemoMapper<NoteView,Note>{

	private ModelMapper mapperFromView; 
	private ModelMapper mapperFromEntity;

	public NoteMapper(){
		this.mapperFromView = new ModelMapper();
		this.mapperFromView.addMappings(new PropertyMap<NoteView, Note>() {
			@Override 
			protected void configure() { 
				map().setCodeMention(source.getCodeMention()); 
				map().setDateExamen(source.getDateExamen());
				map().setNoteObtenue(source.getNoteObtenue());
				NoteId noteId = new NoteId(source.getIdCours(),source.getIdEleve());
				map().setId(noteId);
				map().setEntityId(noteId);
			} 
		}); 
		this.mapperFromEntity = new ModelMapper();
		this.mapperFromEntity.addMappings(new PropertyMap<Note,NoteView >() {
			@Override 
			protected void configure() { 
				map().setCodeMention(source.getCodeMention()); 
				map().setDateExamen(source.getDateExamen());
				map().setNoteObtenue(source.getNoteObtenue());
				map().setIdCours(source.getId().getCoursConcerne().getIdCours());
				map().setIdEleve(source.getId().getEleveConcerne().getEntityId());
			} 
		}); 
	}

	public NoteView mapViewFromEntity(Note ent) {
		return this.mapperFromEntity.map(ent,NoteView.class);
	}

	public Note mapEntityFromView(NoteView view) {
		return this.mapperFromView.map(view, Note.class);
	}

	@Override
	public Class<NoteView> getViewClass() {
		// TODO Auto-generated method stub
		return NoteView.class;
	}

	@Override
	public Class<Note> getEntityClass() {
		// TODO Auto-generated method stub
		return Note.class;
	}

	
	
	
}
