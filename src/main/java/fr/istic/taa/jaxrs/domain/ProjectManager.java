package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity@DiscriminatorValue("MANAGER")
public class ProjectManager extends User implements Serializable{

	String teamName;


	public ProjectManager() {
		super();
		this.teamName="Default Team";
	}
	public ProjectManager(String name) {
		super(name);
		this.teamName="Default Team";
	}
	public ProjectManager(String name, String teamName) {
		super(name);
		this.teamName=teamName;
	}
	@XmlElement(name = "teamName")
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
