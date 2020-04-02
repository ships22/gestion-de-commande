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
import com.stock.model.Client;
import com.stock.service.AllService;

@RestController
@RequestMapping(value="/api")
public class ClientController {
	
	@Autowired
	private AllService allService;
	
	@GetMapping(value="/client")
	public List<ClientDTO>getAllClient(){
		return allService.touteLesClient();
	}
	
	@PostMapping(value="/ajouter-client", produces = "application/json")
	public Client saveClient(@RequestBody Client client) {
		return allService.ajouterClient(client);
	}
	
	@PutMapping(value="/modifier-client")
	public Client updateClient(@RequestBody Client client) {
		return allService.modifierClient(client);
	}
	
	@DeleteMapping(value="/suprimer-client/{id}")
	public void deleteClient(@PathVariable(name = "id") Long id) {
		 allService.suprimerClient(id);
	}

}
