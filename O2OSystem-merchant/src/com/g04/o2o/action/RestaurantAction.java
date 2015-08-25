package com.g04.o2o.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.Address;
import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.RestaurantType;
import com.g04.o2o.service.RestaurantService;

@RestController
public class RestaurantAction {

	@Autowired
	private RestaurantService restaurantService;

	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@RequestMapping(value = "/restaurant", method = RequestMethod.POST)
	public JsonProtocol regist(String mName, int type, Address addr) {
		System.out.println(mName);
		JsonProtocol js = new JsonProtocol();
		Restaurant rest = new Restaurant();
		int result = restaurantService.addRestaurant(rest);
		boolean res = (result == 1 ? true : false);
		js.setResult(res);
		return js;
	}

	@RequestMapping(value = "/restaurant/{id}/name", method = RequestMethod.PUT)
	public JsonProtocol updateRestName(@PathVariable(value = "id") int id,
			String name) {
		System.out.println(name);
		JsonProtocol js = new JsonProtocol();
		int result = restaurantService.updateRestName(id, name);
		boolean res = (result == 1 ? true : false);
		js.setResult(res);
		return js;
	}

	@RequestMapping(value = "/restaurant/{id}/addr", method = RequestMethod.PUT)
	public JsonProtocol updateRestAddr(@PathVariable(value = "id") int id,
			Address addr) {
		System.out.println(addr);
		JsonProtocol js = new JsonProtocol();
		int result = restaurantService.updateRestAddr(id, addr);
		boolean res = (result == 1 ? true : false);
		js.setResult(res);
		return js;
	}

	@RequestMapping(value = "/restaurant/{id}/type", method = RequestMethod.PUT)
	public JsonProtocol updateRestType(@PathVariable(value = "id") int id,
			RestaurantType type) {
		System.out.println(type);
		JsonProtocol js = new JsonProtocol();
		int result = restaurantService.updateRestType(id, type);
		boolean res = (result == 1 ? true : false);
		js.setResult(res);
		return js;
	}

	@RequestMapping(value = "/restaurant/{id}/notice", method = RequestMethod.PUT)
	public JsonProtocol updateRestNotice(@PathVariable(value = "id") int id,
			String notice) {
		System.out.println(notice);
		JsonProtocol js = new JsonProtocol();
		int result = restaurantService.updateRestNotice(id, notice);
		boolean res = (result == 1 ? true : false);
		js.setResult(res);
		return js;
	}

	@RequestMapping(value = "/restaurant/{id}/playprice", method = RequestMethod.PUT)
	public JsonProtocol updateRestPlayPrice(@PathVariable(value = "id") int id,
			int playPrice) {
		System.out.println(playPrice);
		JsonProtocol js = new JsonProtocol();
		int result = restaurantService.updateRestPlayPrice(id, playPrice);
		boolean res = (result == 1 ? true : false);
		js.setResult(res);
		return js;
	}

	@RequestMapping(value = "/restaurant/{id}/discharge", method = RequestMethod.PUT)
	public JsonProtocol updateRestDisCharge(@PathVariable(value = "id") int id,
			int disCharge) {
		System.out.println(disCharge);
		JsonProtocol js = new JsonProtocol();
		int result = restaurantService.updateRestDisCharge(id, disCharge);
		boolean res = (result == 1 ? true : false);
		js.setResult(res);
		return js;
	}

	@RequestMapping(value = "/restaurant/{id}/opentime", method = RequestMethod.PUT)
	public JsonProtocol updateOpenTime(@PathVariable(value = "id") int id,
			String opentime) {
		System.out.println(opentime);
		JsonProtocol js = new JsonProtocol();
		int result = restaurantService.updateOpenTime(id, opentime);
		boolean res = (result == 1 ? true : false);
		js.setResult(res);
		return js;
	}

}