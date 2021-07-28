package com.cognizant.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	private MenuItem menuItem;
	private Coupon coupon;
	private double finalPrice;
}
