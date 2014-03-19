package fr.istic.tpjpa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Home implements Serializable{
	
	private Long id;
	
	private String adresse;
	private String superficie;
	private String adresseIp;
	private Person personne;
	
	private List<Heater> Heater = new ArrayList<Heater>();
	
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSuperficie() {
		return superficie;
	}
	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}
	public String getAdresseIp() {
		return adresseIp;
	}
	public void setAdresseIp(String adresseIp) {
		this.adresseIp = adresseIp;
	}
	
    @ManyToOne
	public Person getPersonne() {
		return personne;
	}
	public void setPersonne(Person personne) {
		this.personne = personne;
	}
	
    
    
    
//    @Override
//
//    public String toString() {
//
//        return "la maison [id=" + id + ", name=" + adresse + ", appartient à la personne"
//
//                + personne.getNom() + "]";
//    }
	
    
    
    @OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST)

    public List<Heater> getHeater() {

        return Heater;

    }

    public Home(String adresse, Person personne) {
		super();
		this.adresse = adresse;
		this.personne = personne;
	}
	public void setHeater(List<Heater> Heater) {

        this.Heater = Heater;
    }

	
	
	
	 
}
