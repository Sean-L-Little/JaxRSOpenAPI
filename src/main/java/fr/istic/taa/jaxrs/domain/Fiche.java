package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "Fiche")
public class Fiche  implements Serializable{
	
	private Long id;
	private String libelle;
	private Date date_buttoir;
	private User user;
	private int temps_requis_m;
	private List<Tag> tags = new ArrayList<Tag>();
	private String lieu;
	private String url;
	private Section section;
	
	public Fiche() {
		
	}
	
	public Fiche(String libelle, Date date_buttoir, User user, Section section) {
		super();
		this.libelle = libelle;
		this.date_buttoir = date_buttoir;
		this.user = user;
		this.temps_requis_m = 60;
		this.tags = new ArrayList<Tag>();
		this.lieu = "home";
		this.url = "www.blabla.com";
		this.section=section;
		
		
		user.addFiche(this);
		section.addFiche(this);
	}
	
	public Fiche(String libelle, Date date_buttoir, User user, int temps_requis_m, List<Tag> tags,
			String lieu, String url, Section section) {
		super();
		this.libelle = libelle;
		this.date_buttoir = date_buttoir;
		this.user = user;
		this.temps_requis_m = temps_requis_m;
		this.tags = tags;
		this.lieu = lieu;
		this.url = url;
		this.section=section;
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

	@XmlElement(name = "libelle")
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@XmlElement(name = "date_buttoir")
	public Date getDate_buttoir() {
		return date_buttoir;
	}

	public void setDate_buttoir(Date date_buttoir) {
		this.date_buttoir = date_buttoir;
	}
	
	@ManyToOne
	@XmlElement(name = "user")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@XmlElement(name = "temps_requis_m")
	public int getTemps_requis_m() {
		return temps_requis_m;
	}

	public void setTemps_requis_m(int temps_requis_m) {
		this.temps_requis_m = temps_requis_m;
	}

	@ManyToMany
	@XmlElement(name = "tags")
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@ManyToOne( cascade = CascadeType.ALL)
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	
	//####################################################################################
	//####################################################################################
	//####################################################################################


	public void addTag(Tag tag) {
		if(!this.tags.contains(tag)) {
			this.tags.add(tag);
		}
		
	}
	@Override
	public String toString() {
		return "Fiche [id=" + id + ", libelle=" + libelle + ", date_buttoir=" + date_buttoir + ", user=" + user
				+ ", temps_requis_m=" + temps_requis_m + ", tags=" + tags + ", lieu=" + lieu + ", url=" + url + "]";
	}
	
}
