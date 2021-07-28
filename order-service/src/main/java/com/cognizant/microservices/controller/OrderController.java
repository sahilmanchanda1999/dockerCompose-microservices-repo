package com.cognizant.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.microservices.model.Order;
import com.cognizant.microservices.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@GetMapping("/item-name/{itemName}/coupon-code/{couponCode}")
	public Order getOrderDetails(@PathVariable String itemName,@PathVariable String couponCode) {
		return service.getOrderDetails(itemName, couponCode);
	}
	
	@GetMapping("/name")
	public String getName() {
		return "running";
	}
}
