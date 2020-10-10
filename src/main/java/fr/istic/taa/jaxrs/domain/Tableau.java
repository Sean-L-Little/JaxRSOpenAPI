package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlRootElement(name = "Tableau")
public class Tableau implements Serializable {
	
	private Long id;
	private String table_title;
	private List<Section> sections = new ArrayList<Section>();
	
	public Tableau() {
		super();
	}
	public Tableau(String table_title) {
		super();
		this.table_title = table_title;
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
	@XmlElement(name = "table_title")
	public String getTable_title() {
		return table_title;
	}
	public void setTable_title(String table_title) {
		this.table_title = table_title;
	}
	
	@OneToMany(mappedBy="section_name",cascade=CascadeType.ALL)
	@JsonIgnore
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	public void addSection(Section section) {
		this.sections.add(section);
	}
	
	
}
