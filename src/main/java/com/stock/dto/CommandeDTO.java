package com.stock.dto;

import java.util.List;

import com.stock.model.Client;
import com.stock.model.Produit;

public class CommandeDTO {

	private long id;
	
	private double prixTotal;
	
	private Client client;
	
	private List<Produit> produits;

	public CommandeDTO(long id, double prixTotal, Client client,  List<Produit> produits) {
		super();
		this.id = id;
		this.prixTotal = prixTotal;
		this.client = client;
		this.produits = produits;
	}

	public CommandeDTO() {
		super();
		// TODO Auto-generated constructor stub
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
