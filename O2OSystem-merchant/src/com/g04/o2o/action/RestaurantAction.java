package com.g04.o2o.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.service.RestaurantService;

@RestController
public class RestaurantAction {

	@Autowired
	private RestaurantService restaurantService;

	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@RequestMapping(value = "/restaurant", method = RequestMethod.POST)
	public JsonProtocol regist(String mName) {
		System.out.println(mName);
		JsonProtocol js = new JsonProtocol();
		Restaurant rest = new Restaurant();
		int result = restaurantService.addRestaurant(rest);
		boolean res = (result == 1 ? true : false);
		js.setResult(res);
		return js;
	}
}
