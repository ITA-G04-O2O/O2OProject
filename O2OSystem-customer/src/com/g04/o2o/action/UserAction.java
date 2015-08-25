package com.g04.o2o.action;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.Order;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.User;
import com.g04.o2o.service.UserService;

@RequestMapping()
@RestController
public class UserAction {

	private UserService userService;
	
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
	public User getUserInfo(@PathVariable(value="id") Integer uid){
		return userService.getUserInfo(uid);
	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
	public List<Order> getUserOrder(@PathVariable(value="id") Integer uid){
		return userService.getUserOrder(uid);
	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
	public Set<Restaurant> getUserRestlikes(@PathVariable(value="id") Integer uid){
		return userService.getUserRestlikes(uid);
	}
	
	
}
