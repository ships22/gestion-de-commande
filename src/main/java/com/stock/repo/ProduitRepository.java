package com.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.model.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
}
