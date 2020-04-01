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

import com.stock.dto.ClientDTO;
import com.stock.dto.CommandeDTO;
import com.stock.model.Client;
import com.stock.model.Commande;
import com.stock.service.AllService;

@RestController
@RequestMapping(value="/api")
public class CommandeController {

	@Autowired
	private AllService allService;
	
	@GetMapping(value="/commandes")
	public List<CommandeDTO>getAllProduit(){
		return allService.touteLesCommande();
	}
	
	@PostMapping(value="/ajouter-commande", produces = "application/json")
	public Commande saveProduit(@RequestBody Commande commande) {
		return allService.ajouterCommande(commande);
	}
	
	@PutMapping(value="/modifier-commande")
	public Commande updateProduit(@RequestBody Commande commande) {
		return allService.modifierCommande(commande);
	}
	
	@DeleteMapping(value="/suprimer-commande/{id}")
	public void deleteProduit(@PathVariable(name = "id") Long id) {
		 allService.suprimerCommande(id);
	}
	
}
