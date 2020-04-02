package com.stock.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dto.ClientDTO;
import com.stock.dto.CommandeDTO;
import com.stock.dto.ProduitDTO;
import com.stock.model.Client;
import com.stock.model.Commande;
import com.stock.model.Produit;
import com.stock.repo.ClientRepository;
import com.stock.repo.CommandeRepository;
import com.stock.repo.ProduitRepository;

@Service
public class AllService {
	
	
	//Produits
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@Transactional
	public List<ProduitDTO> tousLesProduit() {
		List<Produit>pdouitList = produitRepository.findAll();
		List<ProduitDTO>produitDTOS = new ArrayList<ProduitDTO>();
		pdouitList.forEach(produit -> {
			ProduitDTO produitDto = new ProduitDTO();
			produitDto.setId(produit.getId());
			produitDto.setNom(produit.getNom());
			produitDto.setPrix(produit.getPrix());
			produitDto.setQuantite(produit.getQuantite());
			produitDTOS.add(produitDto);
		});
		return produitDTOS;
	}
	
	public ProduitDTO getProduitById(Long id) {
		Produit produit = produitRepository.getOne(id);
		ProduitDTO produitDto = new ProduitDTO();
		produitDto.setId(produit.getId());
		produitDto.setNom(produit.getNom());
		produitDto.setPrix(produit.getPrix());
		produitDto.setQuantite(produit.getQuantite());
		return produitDto;
	}
	
	public Produit ajouterPdoduit(Produit produit) {
		return produitRepository.save(produit);
	}
	
	public Produit modifierProduit(Produit produit) {
		return produitRepository.saveAndFlush(produit);
	}
	
	public Long suprimerProduit(Long id) {
		 produitRepository.deleteById(id);
		 return id;
	}
	
	//Client
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	@Transactional
	public List<ClientDTO> touteLesClient() {
		List<Client>clientList = clientRepository.findAll();
		List<ClientDTO>clientDTOS = new ArrayList<ClientDTO>();
		clientList.forEach(client -> {
			ClientDTO clientDto = new ClientDTO();
			clientDto.setId(client.getId());
			clientDto.setNom(client.getNom());
			clientDto.setEmail(client.getEmail());
			clientDTOS.add(clientDto);
		});
		return clientDTOS;
	}
	
	public Client ajouterClient(Client client) {
		return clientRepository.save(client);
	}
	
	public Client modifierClient(Client client) {
		return clientRepository.saveAndFlush(client);
	}
	
	public void suprimerClient(Long id) {
		clientRepository.deleteById(id);
	}
	
	//Commande
	
		@Autowired
		private CommandeRepository commandeRepository;
		
		
		@Transactional
		public List<CommandeDTO> touteLesCommande() {
			List<Commande>commandeList = commandeRepository.findAll();
			List<CommandeDTO>commandeDTOS = new ArrayList<CommandeDTO>();
			commandeList.forEach(commande -> {
				CommandeDTO commandeDto = new CommandeDTO();
				commandeDto.setId(commande.getId());
				commandeDto.setPrixTotal(commande.getPrixTotal());
				commandeDto.setProduits(commande.getProduits());
				commandeDto.setClient(commande.getClient());
				commandeDTOS.add(commandeDto);
			});
			return commandeDTOS;
		}
		
		/*double prixTotal;
		protected double total(Commande commande) {
			prixTotal = 0;
			commande.getProduits().forEach(produit -> {
				prixTotal += produit.getPrix() * produit.getQuantite();
			});
			return prixTotal;
		}*/
		
		public Commande ajouterCommande(Commande commande) {
			return commandeRepository.save(commande);
		}
		
		public Commande modifierCommande(Commande commande) {
			return commandeRepository.saveAndFlush(commande);
		}
		
		public void suprimerCommande(Long id) {
			commandeRepository.deleteById(id);
		}

}
