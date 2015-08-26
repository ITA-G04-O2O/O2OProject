package com.g04.o2o.action;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.entity.MainSystem;
import com.g04.o2o.service.AdminService;

@RestController
public class AdminAction {
	private AdminService systemService;

	@RequestMapping(value = "/sysSetting", method = RequestMethod.GET)
	public JsonProtocol getSystemTimes() {
		JsonProtocol jp = new JsonProtocol();
		MainSystem m = new MainSystem();
		m.setAutoExpirationTime(systemService.getAutoExpirationTime());
		m.setAutoCompleteTime(systemService.getAutoCompleteTime());
		jp.setResult(true);
		jp.setObject(m);
		return jp;
	}

	@RequestMapping(value = "/sysSetting/{id}", method = RequestMethod.PUT)
	public JsonProtocol updateSystemTimes(@PathVariable(value = "id") int id,
			MainSystem mainSystem) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.updateSystemTimes(mainSystem));
		return jp;
	}

	@RequestMapping(value = "/restaurantType", method = RequestMethod.GET)
	public JsonProtocol getRestaurantType() {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(true);
		jp.setObject(systemService.getAllRestType());
		return jp;
	}

	@RequestMapping(value = "/restaurantType/{id}", method = RequestMethod.PUT)
	public JsonProtocol updateRestaurantType(
			@PathVariable(value = "id") int id, String type) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.updateRestaurantType(id, type));
		return jp;
	}

	@RequestMapping(value = "/restaurantType", method = RequestMethod.POST)
	public JsonProtocol addRestaurantType(String type) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.addRestaurantType(type));
		return jp;
	}

	@RequestMapping(value = "/hotlines", method = RequestMethod.POST)
	public JsonProtocol addHotLines(String tel) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.addHotLines(tel));
		return jp;
	}

	@RequestMapping(value = "/hotlines/{id}", method = RequestMethod.PUT)
	public JsonProtocol updateHotLine(@PathVariable int id, String number) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.updateHotLines(id, number));
		return jp;
	}

	@RequestMapping(value = "/hotlines", method = RequestMethod.GET)
	public JsonProtocol getHotLine() {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(true);
		jp.setObject(systemService.getHotLines());
		return jp;
	}

	@RequestMapping(value = "/hotlines/{id}", method = RequestMethod.DELETE)
	public JsonProtocol deleteHotLine(@PathVariable int id) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.deleteHotLine(id));
		return jp;
	}

	@RequestMapping(value = "/users/{tel}")
	public JsonProtocol updateUserPSD(@PathVariable String tel) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.resetPsd(tel));
		return jp;
	}

	@RequestMapping(value = "/restaurantVerify/{id}")
	public JsonProtocol verifyRestaurant(@PathVariable int id, int state) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.verifyRestaurant(id, state));
		return jp;
	}

}
