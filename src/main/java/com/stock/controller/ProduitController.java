package com.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.dto.ProduitDTO;
import com.stock.model.Produit;
import com.stock.repo.ProduitRepository;
import com.stock.service.AllService;


@RestController
@RequestMapping(value="/api")
public class ProduitController {

	@Autowired
	private AllService allService;
	
	@GetMapping(value="/produits")
	public List<ProduitDTO>getAllProduit(){
		return allService.tousLesProduit();
	}
	
	@GetMapping(value="/produitById/{id}")
	public ProduitDTO getProduitById(@PathVariable(name = "id") Long id){
		return allService.getProduitById(id);
	}
	
	@PostMapping(value="/ajouter-produit", produces = "application/json")
	public Produit saveProduit(@RequestBody Produit produit) {
		return allService.ajouterPdoduit(produit);
	}
	
	@PutMapping(value="/modifier-produit")
	public Produit updateProduit(@RequestBody Produit produit) {
		return allService.modifierProduit(produit);
	}
	
	@DeleteMapping(value="/suprimer-produit/{id}")
	public Long deleteProduit(@PathVariable(name = "id") Long id) {
		 return allService.suprimerProduit(id);
	}
	
}
