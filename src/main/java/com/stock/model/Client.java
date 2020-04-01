package com.stock.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.UniqueElements;

@Table( name ="client" , uniqueConstraints= @UniqueConstraint(columnNames= {"email"}))
@Entity
public class Client {

	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO)
	private long id;
	
	private String nom;
	
	@Email
	private String email;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(long id, String nom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
