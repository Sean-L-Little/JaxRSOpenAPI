package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Section;

public class SectionDAO extends AbstractJpaDao<Long, Section>{
	
	public SectionDAO() {
		super(Section.class);
	}
	
	
}
