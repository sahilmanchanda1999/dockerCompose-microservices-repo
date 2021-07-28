package com.cognizant.microservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.microservices.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long>{
	
	public Coupon findByCouponCode(String couponCode);
}
