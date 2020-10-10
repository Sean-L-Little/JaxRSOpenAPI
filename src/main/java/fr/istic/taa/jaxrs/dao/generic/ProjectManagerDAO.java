package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.ProjectManager;

public class ProjectManagerDAO extends AbstractJpaDao<Long, ProjectManager>{
	
	public ProjectManagerDAO() {
		super(ProjectManager.class);
	}
	
	
}
