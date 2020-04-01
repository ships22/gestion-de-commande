package com.stock.dto;

import java.util.List;
import com.stock.model.Commande;

public class ClientDTO {
	
	private Long id;	
	private String nom;
	private String email;
	private List<Commande> commandes;
	
	
	
	public ClientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientDTO(Long id, String nom, String email, List<Commande> commandes) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.commandes = commandes;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
}
