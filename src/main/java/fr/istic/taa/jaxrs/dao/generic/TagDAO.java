package fr.istic.taa.jaxrs.dao.generic;
import fr.istic.taa.jaxrs.domain.Tag;
import fr.istic.taa.jaxrs.dao.generic.*;

public class TagDAO extends AbstractJpaDao<Long, Tag>{
	
	public TagDAO() {
		super(Tag.class);
	}
	
	
}
