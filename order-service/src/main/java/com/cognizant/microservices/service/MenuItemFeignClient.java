package com.cognizant.microservices.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.microservices.model.MenuItem;

@FeignClient(value="menu-item-service",url="http://localhost:5100/items")
public interface MenuItemFeignClient {

	@GetMapping("item-name/{item-name}")
	MenuItem getMenuItems(@PathVariable("item-name") String itemName);
}
