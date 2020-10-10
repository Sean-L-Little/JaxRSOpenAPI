package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MachineACafe implements Serializable{
	
	private Long id;
	private String coffee_name;
	private int quantite_restant;
	
	public MachineACafe() {
		
	}

	public MachineACafe(String name, int quantite_restant) {
		super();
		this.coffee_name = name;
		this.quantite_restant = quantite_restant;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getCoffee_name() {
		return coffee_name;
	}

	public void setCoffee_name(String coffee_name) {
		this.coffee_name = coffee_name;
	}

	public int getQuantite_restant() {
		return quantite_restant;
	}

	public void setQuantite_restant(int quantite_restant) {
		this.quantite_restant = quantite_restant;
	}
	

}
