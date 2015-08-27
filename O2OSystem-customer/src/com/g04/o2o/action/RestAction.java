package com.g04.o2o.action;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vo.RestaurantVo;

import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.RestaurantType;
import com.g04.o2o.service.RestaurantService;
@RestController
public class RestAction {
	@Autowired
	private RestaurantService restService;
	
	@RequestMapping(value="/restaurantType",method=RequestMethod.GET)
	public JsonProtocol getRestTypes(){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(restService.getRestTypes());
		return jp;
	}
	
	@Transactional
	@RequestMapping(value="/restaurant/restaurantType/{type}",method=RequestMethod.GET,produces = { "application/json;charset=UTF-8" })
	public JsonProtocol getRestList(@PathVariable(value="type") String type){
		System.out.println(type);
		JsonProtocol jp = new JsonProtocol();

		Set<Restaurant> rs = restService.getRestByType(type);
		Set<RestaurantVo> rsVO = new HashSet<RestaurantVo>();
		for(Restaurant r:rs){
			Integer id=r.getId();
			String name=r.getName();
			String mtype=r.getType().getType();
			Integer sum=r.getOrders().size();
			Integer playPrice=r.getPlayPrice();
			Double grade=r.getGrade();
			Double actualArrivalTime=r.getActualArrivalTime();
			RestaurantVo vo=new RestaurantVo(id, name, mtype, sum, playPrice, grade, actualArrivalTime);
			rsVO.add(vo);
		}
//		System.out.println(restService.getRestByType(type));
		jp.setObject(rsVO);

		return jp;
	}
	
	@RequestMapping(value="/restaurant/{id}",method=RequestMethod.GET)
	public JsonProtocol getRestInfo(@PathVariable(value="id") Integer id){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(restService.getRestInfo(id));
		return jp;
	}
	
	@RequestMapping(value="/restaurant/{id}/menuType",method=RequestMethod.GET)
	public JsonProtocol getMenuType(@PathVariable(value="id") Integer id){
		JsonProtocol jp = new JsonProtocol(); 
		jp.setObject(restService.getMenuType(id));
		return jp;
	}
	
	@RequestMapping(value="/restaurant/{id}/menuItems",method=RequestMethod.GET)
	public JsonProtocol getMenuItems(@PathVariable(value="id") Integer id){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(restService.getMenuItems(id));
		return jp;
	}
	
	@RequestMapping(value="/restaurant/{id}/highOrders",method=RequestMethod.GET)
	public JsonProtocol getHighOrders(@PathVariable(value="id") Integer id){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(restService.getHighOrders(id));
		return jp;
	}
	
	@RequestMapping(value="/restaurant/{id}/midOrders",method=RequestMethod.GET)
	public JsonProtocol getMidOrders(@PathVariable(value="id") Integer id){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(restService.getMidOrders(id));
		return jp;
	}
	
	@RequestMapping(value="/restaurant/{id}/lowOrders",method=RequestMethod.GET)
	public JsonProtocol getLowOrders(Integer id){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(restService.getLowOrders(id));
		return jp;
	}
	
}
