package com.stock.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.UniqueElements;

@Table
@Entity
public class Commande {

	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO)
	private long id;
	
	private double prixTotal;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinTable(name = "commande_client",
    joinColumns = @JoinColumn(name = "commande_id", referencedColumnName ="id"),
    inverseJoinColumns = @JoinColumn(name = "client_id" , referencedColumnName="id"))
	private Client client;
	
	@ManyToMany
	@JoinTable(name = "commande_produits",
    joinColumns = @JoinColumn(name = "commande_id", referencedColumnName ="id"),
    inverseJoinColumns = @JoinColumn(name = "produit_id" , referencedColumnName="id"))
	private List<Produit> produits;
	

	public Commande() {
		super();
	}


	public Commande(long id, double prixTotal, Client client, List<Produit> produits) {
		super();
		this.id = id;
		this.prixTotal = prixTotal;
		this.client = client;
		this.produits = produits;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public double getPrixTotal() {
		return prixTotal;
	}


	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public List<Produit> getProduits() {
		return produits;
	}


	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	
}
