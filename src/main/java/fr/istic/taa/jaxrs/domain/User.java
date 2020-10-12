package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Users")
@NamedQuery(name="findUserByName", query="select a from User a where a.user_name = :user_name")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("WORKER")
@XmlRootElement(name = "User")
public class User  implements Serializable{

	private Long id;
	private String user_name;
	private List<Fiche> fiches = new ArrayList<Fiche>();
	
	public User() {
		
	}
	
	public User(String name) {
		super();
		this.user_name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name = "user_name")
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnore
	public List<Fiche> getFiches() {
		return fiches;
	}
	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
	}
	
	public void addFiche(Fiche fiche) {

		this.fiches.add(fiche);
		fiche.setUser(this);
	}
	
	
}
