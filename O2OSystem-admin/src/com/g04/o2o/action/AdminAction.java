package com.g04.o2o.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.entity.MainSystem;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.RestaurantType;
import com.g04.o2o.entity.User;
import com.g04.o2o.service.AdminService;
import com.g04.o2o.vo.RestaurantTypeVo;
import com.g04.o2o.vo.RestaurantVo;
import com.g04.o2o.vo.UserVo;

@RestController
@RequestMapping(value = "/AdminService")
public class AdminAction {
	@Autowired
	private AdminService systemService;

	@RequestMapping(value = "/sysSetting", method = RequestMethod.GET)
	public JsonProtocol getSystemTimes() {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(true);
		jp.setObject(systemService.getSystemTimes());
		return jp;
	}

	@RequestMapping(value = "/sysSetting/{id}", method = RequestMethod.PUT)
	public JsonProtocol updateSystemTimes(@PathVariable(value = "id") int id,
			MainSystem mainSystem) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.updateSystemTimes(mainSystem));
		return jp;
	}

	@RequestMapping(value = "/restaurantTypes", method = RequestMethod.GET)
	@Transactional
	public JsonProtocol getRestaurantType() {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(true);
		Set<RestaurantTypeVo> lists = new HashSet<>();
		for (RestaurantType rt : systemService.getAllRestType()) {
			RestaurantTypeVo restaurantType = new RestaurantTypeVo();
			restaurantType.setId(rt.getId());
			restaurantType.setType(rt.getType());
			lists.add(restaurantType);
		}
		jp.setObject(lists);
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

	@RequestMapping(value = "/users/{tel}", method = RequestMethod.PUT)
	public JsonProtocol updateUserPSD(@PathVariable String tel) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.resetPsd(tel));
		return jp;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@Transactional
	public JsonProtocol getUserlist() {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(true);
		List<UserVo> lists = new ArrayList<>();
		if (systemService.getUsers() != null) {
			System.out.println(systemService.getUsers().size());
			for (User u : systemService.getUsers()) {
				UserVo uVo = new UserVo();
				uVo.setId(u.getId());
				uVo.setTel(u.getTel());
				uVo.setUname(u.getNickName());
				lists.add(uVo);
			}
		}
		jp.setObject(lists);
		return jp;
	}

	@RequestMapping(value = "/restaurantVerify/{id}")
	public JsonProtocol verifyRestaurant(@PathVariable int id, int state) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.verifyRestaurant(id, state));
		return jp;
	}

	@RequestMapping(value = "/hot/{id}", method = RequestMethod.PUT)
	public JsonProtocol setHot(@PathVariable int id, boolean isHot) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.setHot(id, isHot));
		return jp;
	}

	@RequestMapping(value = "/state/{id}", method = RequestMethod.PUT)
	public JsonProtocol setClose(@PathVariable int id) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.setClose(id));
		return jp;
	}

	@RequestMapping(value = "/restaurants", method = RequestMethod.GET)
	@Transactional
	public JsonProtocol getRestaurants() {
		JsonProtocol jp = new JsonProtocol();
		List<RestaurantVo> lists = new ArrayList<>();
		if (systemService.getRestaurants() != null) {
			for (Restaurant r : systemService.getRestaurants()) {
				RestaurantVo rVo = new RestaurantVo();
				rVo.setId(r.getId());
				rVo.setGrade(r.getGrade());
				rVo.setHot(r.isHot());
				rVo.setName(r.getName());
				rVo.setNum(r.getOrders().size());
				rVo.setOnline(r.isOnline());
				lists.add(rVo);
			}
		}
		jp.setObject(lists);
		return jp;
	}
}
