package com.g04.o2o.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.g04.o2o.entity.Address;
import com.g04.o2o.entity.Area;
import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.entity.Merchant;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.RestaurantType;
import com.g04.o2o.service.AreaService;
import com.g04.o2o.service.MerchantService;
import com.g04.o2o.service.RestaurantService;
import com.g04.o2o.vo.RestaurantVO;

@Controller
public class RestaurantAction {

	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private AreaService areaService;

	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	
	public void setMerchantService(MerchantService merchantService) {
		this.merchantService = merchantService;
	}



	@RequestMapping(value = "/restaurant", method = RequestMethod.POST)
	public String regist(String mName, int type, String provinceInput,
			String cityInput, String detailInput, HttpSession session,
			@RequestParam("file") MultipartFile file) {
		System.out.println("RestaurantAction");
		byte[] pic = null;
		try {
			pic = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Restaurant rest = new Restaurant();
		rest.setName(mName);
		rest.setType(restaurantService.getRestTypeById(type));
		Address addr = new Address();
		Area area = areaService.getAreaByCity(cityInput);
		addr.setDetail(detailInput);
		addr.setArea(area);
		rest.setAddress(addr);
		rest.setImageBytes(pic);
		session.setAttribute("restaurant", rest);
		return "merchantRegist";
	}

	@ResponseBody
	@RequestMapping(value = "/restaurant/{id}", method = RequestMethod.GET)
	public Restaurant get(@PathVariable Integer id) {
		System.out.println("RestaurantAction2...");
		Restaurant rest = restaurantService.getRestById(id);
		RestaurantVO restV = new RestaurantVO();
		restV.setName(rest.getName());
		restV.setType(rest.getType());
		restV.setTel(rest.getTel());
		return rest;
	}

	@RequestMapping(value = "/resttype", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public List<RestaurantType> resttype() {
		System.out.println("resttype");
		List<RestaurantType> restType = restaurantService.getTypes();
		return restType;
	}

	@ResponseBody
	@RequestMapping(value = "/restaurant/{id}", method = RequestMethod.POST)
	@Transactional
	public String updateRest(@PathVariable(value = "id") int id, String name,
			int type, String tel, String pro, String city, String detail) {
		System.out.println("RestaurantAction3...");
		try {
			Restaurant rest =restaurantService.findRestByUserId(id);
			int restId= rest.getId();
			restaurantService.updateRestName(restId, name);
			restaurantService.updateTel(restId, tel);
			RestaurantType t = restaurantService.getRestTypeById(type);
			restaurantService.updateRestType(restId, t);
			Address addr =rest.getAddress();
			addr.setDetail(detail);
			Area area = addr.getArea();
			area.setCity(city);
			area.setProvince(pro);
			rest.setAddress(addr);
			restaurantService.updateRestAddr(restId, addr);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "false";
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
