package fr.istic.tpjpa.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Persister;

@Entity
public class Person {

	
	private Long id;
	private String nom;
	private String prenom;
	private Boolean genre;
	private String mail;
	private Date dateNaissance;
	private String profileFB;
	
	
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
}
