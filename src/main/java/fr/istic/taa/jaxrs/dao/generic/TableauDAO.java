package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Tableau;

public class TableauDAO extends AbstractJpaDao<Long, Tableau>{
	
	public TableauDAO() {
		super(Tableau.class);
	}
	
	
}
