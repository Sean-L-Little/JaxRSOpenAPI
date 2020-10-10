package fr.istic.taa.jaxrs.dao.generic;
import fr.istic.taa.jaxrs.domain.Fiche;

public class FicheDAO extends AbstractJpaDao<Long, Fiche>{
	
	public FicheDAO() {
		super(Fiche.class);
	}
	
	
}
