package com.g04.o2o.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.service.RestaurantService;
@RequestMapping()
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
	
	public JsonProtocol getRestList(String type){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(restService.getRestByType(type));
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
	public JsonProtocol getHighOrders(Integer id){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(restService.getHighOrders(id));
		return jp;
	}
	
	@RequestMapping(value="/restaurant/{id}/midOrders",method=RequestMethod.GET)
	public JsonProtocol getMidOrders(Integer id){
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
