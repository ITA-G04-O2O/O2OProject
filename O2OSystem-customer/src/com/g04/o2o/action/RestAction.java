package com.g04.o2o.action;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.MenuType;
import com.g04.o2o.entity.Order;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.service.RestaurantService;
@RequestMapping()
@RestController
public class RestAction {
	@Autowired
	private RestaurantService restService;
	
	@RequestMapping(value="/restaurantType",method=RequestMethod.GET)
	public Set<String> getRestTypes(){
		return restService.getRestTypes();
	}
	
	public Set<Restaurant> getRestList(String type){
		return restService.getRestByType(type);
	}
	
	@RequestMapping(value="/restaurant/{id}",method=RequestMethod.GET)
	public Restaurant getRestInfo(@PathVariable(value="id") Integer id){
		return restService.getRestInfo(id);
	}
	
	@RequestMapping(value="/restaurant/{id}",method=RequestMethod.GET)
	public Set<MenuType> getMenuType(@PathVariable(value="id") Integer id){
		return restService.getMenuType(id);
	}
	
	@RequestMapping(value="/restaurant/{id}",method=RequestMethod.GET)
	public Set<MenuItem> getMenuItems(@PathVariable(value="id") Integer id){
		return restService.getMenuItems(id);
	}
	
	@RequestMapping(value="/restaurant/{id}",method=RequestMethod.GET)
	public List<Order> getHighOrders(Integer id){
		return restService.getHighOrders(id);
	}
	
	@RequestMapping(value="/restaurant/{id}",method=RequestMethod.GET)
	public List<Order> getMidOrders(Integer id){
		return restService.getMidOrders(id);
	}
	
	@RequestMapping(value="/restaurant/{id}",method=RequestMethod.GET)
	public List<Order> getLowOrders(Integer id){
		return restService.getLowOrders(id);
	}
	
}
