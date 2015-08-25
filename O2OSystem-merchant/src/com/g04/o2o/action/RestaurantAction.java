package com.g04.o2o.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.service.RestaurantService;

@RestController
public class RestaurantAction {

	@Autowired
	private RestaurantService restaurantService;

	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@RequestMapping(value = "/restaurant", method = RequestMethod.POST)
	public String regist() {
		
		return "fail";
	}

}
