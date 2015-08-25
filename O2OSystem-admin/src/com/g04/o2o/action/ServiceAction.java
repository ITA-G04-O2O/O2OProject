package com.g04.o2o.action;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sun.print.resources.serviceui;

import com.g04.o2o.entity.MainSystem;
import com.g04.o2o.entity.RestaurantType;
import com.g04.o2o.service.SystemService;

@RestController
public class ServiceAction {
	private SystemService systemService;

	@RequestMapping(value = "/sysSetting", method = RequestMethod.GET)
	public MainSystem getSystemTimes() {
		MainSystem m = new MainSystem();
		m.setAutoExpirationTime(systemService.getAutoExpirationTime());
		m.setAutoCompleteTime(systemService.getAutoCompleteTime());
		return m;
	}

	@RequestMapping(value = "/sysSetting/{id}", method = RequestMethod.PUT)
	public boolean updateSystemTimes(@PathVariable(value = "id") int id,
			MainSystem mainSystem) {
		systemService.updateSystemTimes(mainSystem);
		return true;
	}

	@RequestMapping(value = "/restaurantType", method = RequestMethod.GET)
	public List<RestaurantType> getRestaurantType() {
		List<RestaurantType> list = systemService.getAllRestType();
		return list;
	}

	@RequestMapping(value = "/restaurantType/{id}", method = RequestMethod.PUT)
	public boolean updateRestaurantType(@PathVariable(value = "id") int id,
			String type) {
		boolean isUpdate = systemService.updateRestaurantType(id, type);
		return isUpdate;
	}

	@RequestMapping(value = "/restaurantType", method = RequestMethod.POST)
	public boolean addRestaurantType(String type) {
		boolean isCreate = systemService.addRestaurantType(type);
		return isCreate;
	}

	public boolean addAirLines() {

		return false;
	}

	@RequestMapping(value = "/airlines/{id}", method = RequestMethod.PUT)
	public boolean updateAirLines(@PathVariable int id, String number) {
		systemService.updateAirLines(id, number);
		return true;
	}

	// public
}
