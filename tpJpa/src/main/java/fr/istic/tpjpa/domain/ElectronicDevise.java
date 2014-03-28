package fr.istic.tpjpa.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
@DiscriminatorValue("E")
public class ElectronicDevise extends Technologies{
	
	
	//private Long id;
	private String nom;
	private Person person;
	
	
	//@Id
	//@GeneratedValue
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	 @ManyToOne
	    public Person getPerson() {

	        return person;
	    }
	    
	    public void setPerson(Person personne) {

	        this.person = personne;
	    }
	    
	

}
