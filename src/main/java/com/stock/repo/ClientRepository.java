package com.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.model.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
}
