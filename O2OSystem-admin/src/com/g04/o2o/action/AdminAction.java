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

import com.g04.o2o.entity.JmsProtocol;
import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.entity.MainSystem;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.RestaurantType;
import com.g04.o2o.entity.User;
import com.g04.o2o.service.AdminService;
import com.g04.o2o.tools.JMSUtil;
import com.g04.o2o.tools.JsonUtil;
import com.g04.o2o.vo.RestaurantTypeVo;
import com.g04.o2o.vo.RestaurantVo;
import com.g04.o2o.vo.UserVo;
import com.g04.o2o.vo.VeriftyRestaurant;

@RestController
@RequestMapping(value = "/AdminService")
public class AdminAction {
	@Autowired
	private AdminService systemService;

	@RequestMapping(value = "/sysSetting", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public JsonProtocol getSystemTimes() {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(true);
		jp.setObject(systemService.getSystemTimes());
		return jp;
	}

	@RequestMapping(value = "/sysSetting/{id}", method = RequestMethod.PUT, produces = { "application/json;charset=UTF-8" })
	public JsonProtocol updateSystemTimes(@PathVariable(value = "id") int id,
			MainSystem mainSystem) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.updateSystemTimes(mainSystem));
		return jp;
	}

	@RequestMapping(value = "/sysSetting", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public JsonProtocol addSystemTimes(Integer autoTime, Integer exTime) {
		JsonProtocol jp = new JsonProtocol();
		MainSystem mainSystem = new MainSystem();
		mainSystem.setAutoExpirationTime(autoTime);
		mainSystem.setAutoCompleteTime(exTime);
		jp.setResult(systemService.addSystemTimes(mainSystem));
		return jp;
	}

	@RequestMapping(value = "/restaurantTypes", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
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

	@RequestMapping(value = "/restaurantType/{id}", method = RequestMethod.PUT, produces = { "application/json;charset=UTF-8" })
	public JsonProtocol updateRestaurantType(
			@PathVariable(value = "id") int id, String type) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.updateRestaurantType(id, type));
		return jp;
	}

	@RequestMapping(value = "/restaurantType", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public JsonProtocol addRestaurantType(String type) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.addRestaurantType(type));
		return jp;
	}

	@RequestMapping(value = "/hotlines", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public JsonProtocol addHotLines(String tel) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.addHotLines(tel));
		return jp;
	}

	@RequestMapping(value = "/hotlines/{id}", method = RequestMethod.PUT, produces = { "application/json;charset=UTF-8" })
	public JsonProtocol updateHotLine(@PathVariable int id, String tel) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.updateHotLines(id, tel));
		return jp;
	}

	@RequestMapping(value = "/hotlines", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public JsonProtocol getHotLine() {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(true);
		jp.setObject(systemService.getHotLines());
		return jp;
	}

	@RequestMapping(value = "/hotlines/{id}", method = RequestMethod.DELETE, produces = { "application/json;charset=UTF-8" })
	public JsonProtocol deleteHotLine(@PathVariable int id) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.deleteHotLine(id));
		return jp;
	}

	@RequestMapping(value = "/users/{tel}", method = RequestMethod.PUT, produces = { "application/json;charset=UTF-8" })
	public JsonProtocol updateUserPSD(@PathVariable String tel) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.resetPsd(tel));
		return jp;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
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

	@RequestMapping(value = "/restaurantVerify/{id}", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public JsonProtocol getRestaurant(@PathVariable int id) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(true);
		VeriftyRestaurant vr = new VeriftyRestaurant();
		Restaurant restaurant = systemService.getRestaurantInfo(id);
		vr.setAddress(restaurant.getAddress().getArea().getProvince()
				+ restaurant.getAddress().getArea().getCity());
		vr.setId(restaurant.getId());
		vr.setIDCard(restaurant.getOwner().getIDCard());
		vr.setName(restaurant.getName());
		vr.setOwner(restaurant.getOwner().getRealName());
		vr.setTel(restaurant.getTel());
		vr.setType(restaurant.getType().getType());
		jp.setObject(vr);
		return jp;
	}

	@RequestMapping(value = "/restaurantVerify", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public JsonProtocol getAllRestaurantVerify() {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(true);
		List<VeriftyRestaurant> restaurantsVo = new ArrayList<>();
		List<Restaurant> restaurants = systemService.getAllRestaurant();
		if (restaurants != null) {
			for (Restaurant restaurant : restaurants) {
				if (restaurant.getExamine() == 0) {
					VeriftyRestaurant vr = new VeriftyRestaurant();
					vr.setId(restaurant.getId());
					vr.setName(restaurant.getName());
					restaurantsVo.add(vr);
				}
			}
		}
		jp.setObject(restaurantsVo);
		return jp;
	}

	@RequestMapping(value = "/restaurantVerify/{id}", method = RequestMethod.PUT, produces = { "application/json;charset=UTF-8" })
	public JsonProtocol verifyRestaurant(@PathVariable int id, int state) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.verifyRestaurant(id, state));
		return jp;
	}

	@RequestMapping(value = "/hot/{id}", method = RequestMethod.PUT, produces = { "application/json;charset=UTF-8" })
	public JsonProtocol setHot(@PathVariable int id) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.setHot(id));
		return jp;
	}

	@RequestMapping(value = "/state/{id}", method = RequestMethod.PUT, produces = { "application/json;charset=UTF-8" })
	public JsonProtocol setClose(@PathVariable int id) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(systemService.setClose(id));
		return jp;
	}

	@RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
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

	@Transactional
	@RequestMapping(value = "/jms", method = RequestMethod.GET)
	public List<String> getJMS() {
		List<String> msgs = null;
		try {
			JMSUtil jms = new JMSUtil("g04_que");
			msgs = jms.receiveMsg();
		} catch (Exception e) {
		}
		return msgs;
	}
}
