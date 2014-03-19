package fr.istic.tpjpa.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {

	
	private Long id;
	private String nom;
	private String prenom;
	private Boolean genre;
	private String mail;
	private Date dateNaissance;
	private String profileFB;
	
	
	
	private List<Home> home = new ArrayList<Home>();
	
	private List<ElectronicDevise> electronicDevise = new ArrayList<ElectronicDevise>();
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Boolean getGenre() {
		return genre;
	}
	public void setGenre(Boolean genre) {
		this.genre = genre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getProfileFB() {
		return profileFB;
	}
	public void setProfileFB(String profileFB) {
		this.profileFB = profileFB;
	}
	

	
    @OneToMany(mappedBy = "personne", cascade = CascadeType.PERSIST)
    public List<Home> getHome() {
		return home;
	}
	public void setHome(List<Home> home) {
		this.home = home;
	}
    
  
    
    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
	public List<ElectronicDevise> getElectronicDevise() {
		return electronicDevise;
	}
	public void setElectronicDevise(List<ElectronicDevise> electronicDevise) {
		this.electronicDevise = electronicDevise;
	}
	
    
    
    
    
    
    
    
    
    
    
    
}
