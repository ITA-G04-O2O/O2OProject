package com.g04.o2o.action;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.MenuType;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.service.RestaurantService;

@RestController
public class RestAction {
	@Autowired
	private RestaurantService service;
	
	public Set<MenuType> getMeunTypes(Integer id){
		return service.getMenuType(id);
	}
	
	
	public List<Restaurant> getRestList(String type){
		return service.getRestByType(type);
	}
	
	
}
