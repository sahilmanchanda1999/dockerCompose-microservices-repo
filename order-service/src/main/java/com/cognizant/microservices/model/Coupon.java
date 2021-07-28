package com.cognizant.microservices.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

	private String couponCode;
	private double discount;
}
