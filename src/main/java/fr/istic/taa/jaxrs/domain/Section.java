package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Section implements Serializable{
	
	private Long id;
	private Tableau tableau;
	private String section_name;
	private List<Fiche> fiches = new ArrayList<Fiche>();
	
	public Section(String section_name) {
		super();
		this.section_name = section_name;
	}
	
	public Section(String section_name,Tableau tab) {
		super();
		this.section_name = section_name;
		this.tableau=tab;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSection_name() {
		return section_name;
	}
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	
	@OneToMany(mappedBy="section",cascade=CascadeType.ALL)
	@JsonIgnore
	public List<Fiche> getFiches() {
		return fiches;
	}
	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
	}
	
	@ManyToOne( cascade = CascadeType.ALL)
	public Tableau getTableau() {
		return tableau;
	}

	public void setTableau(Tableau tableau) {
		this.tableau = tableau;
	}
	
	
	
}
