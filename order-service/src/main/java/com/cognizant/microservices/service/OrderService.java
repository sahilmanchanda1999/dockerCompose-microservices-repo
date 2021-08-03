package com.cognizant.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cognizant.microservices.model.Coupon;
import com.cognizant.microservices.model.MenuItem;
import com.cognizant.microservices.model.Order;

@Service
public class OrderService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${LOAD_BALANCER_URL}")
	String loadBalancerUrl;
	
	@Autowired
	CouponServiceFeignClient couponServiceClient;
	
	@Autowired
	MenuItemFeignClient menuItemServiceClient;
	
	public Order getOrderDetails(String itemName,String couponCode) {
		//MenuItem item=restTemplate.getForObject(loadBalancerUrl+"/items/item-name/" + itemName, MenuItem.class);
		//Coupon coupon=restTemplate.getForObject(loadBalancerUrl+"/coupons/coupon-code/" + couponCode, Coupon.class);
		
		Coupon coupon=couponServiceClient.getCoupon(couponCode);
		MenuItem item=menuItemServiceClient.getMenuItems(itemName);
		double finalPrice=item.getPrice()-(item.getPrice()*(coupon.getDiscount()/100));
		return new Order(item,coupon,finalPrice);
	}
	
}
