package org.demo.formation.librairie.service.mapper;

import org.demo.formation.librairie.entity.Eleve;
import org.demo.formation.librairie.service.mapper.common.AbstractCommonMapper;
import org.demo.formation.librairie.service.mapper.common.IDemoMapper;
import org.demo.formation.librairie.service.view.EleveView;

public class EleveMapper extends AbstractCommonMapper<EleveView,Eleve> implements IDemoMapper<EleveView,Eleve>{

	@Override
	public Class<EleveView> getViewClass() {
		// TODO Auto-generated method stub
		return EleveView.class;
	}

	@Override
	public Class<Eleve> getEntityClass() {
		// TODO Auto-generated method stub
		return Eleve.class;
	}

}
