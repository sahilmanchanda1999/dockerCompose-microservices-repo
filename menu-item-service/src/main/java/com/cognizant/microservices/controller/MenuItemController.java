package com.cognizant.microservices.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.microservices.dao.MenuItemRepo;
import com.cognizant.microservices.model.MenuItem;

@RestController
@RequestMapping("/items")
public class MenuItemController {

	@Autowired
	private MenuItemRepo repo;
	
	@PostConstruct
	public void init() {
		MenuItem item1=new MenuItem(100,"Burger",99.0);
		MenuItem item2=new MenuItem(101,"Pizza",199.0);
		repo.save(item1);
		repo.save(item2);
	}
	
	@GetMapping("/item-name/{itemName}")
	public MenuItem getMenuItem(@PathVariable String itemName) {
		return repo.findByItemName(itemName);
	}
}
