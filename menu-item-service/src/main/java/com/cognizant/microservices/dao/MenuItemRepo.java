package com.cognizant.microservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.microservices.model.MenuItem;

public interface MenuItemRepo extends JpaRepository<MenuItem,Long>{

	public MenuItem findByItemName(String itemName);
}
