package org.demo.formation.librairie.service.mapper;

import org.demo.formation.librairie.entity.Cours;
import org.demo.formation.librairie.service.mapper.common.AbstractCommonMapper;
import org.demo.formation.librairie.service.mapper.common.IDemoMapper;
import org.demo.formation.librairie.service.view.CoursView;

public class CoursMapper extends AbstractCommonMapper<CoursView,Cours> implements IDemoMapper<CoursView,Cours>{

	@Override
	public Class<CoursView> getViewClass() {
		// TODO Auto-generated method stub
		return CoursView.class;
	}

	@Override
	public Class<Cours> getEntityClass() {
		// TODO Auto-generated method stub
		return Cours.class;
	}

	

}
