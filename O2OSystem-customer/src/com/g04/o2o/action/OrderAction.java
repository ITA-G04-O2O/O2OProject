package com.g04.o2o.action;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.Order;
import com.g04.o2o.service.OrderService;

@RequestMapping()
@RestController
public class OrderAction {

	private OrderService orderService;
	
	@RequestMapping(value="/orders",method=RequestMethod.POST)
	public int addOrder(Order o){
		int result=orderService.addOrder(o);
		return result;
	}
	
	@RequestMapping(value="/orders/{id}",method=RequestMethod.GET)
	public Order getOrder(@PathVariable(value="id") Integer oid){
		return orderService.getOrder(oid);
	}
	
}
