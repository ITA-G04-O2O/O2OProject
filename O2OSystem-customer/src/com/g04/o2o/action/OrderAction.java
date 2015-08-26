package com.g04.o2o.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.entity.Order;
import com.g04.o2o.service.OrderService;


@RestController
public class OrderAction {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/orders",method=RequestMethod.POST)
	public JsonProtocol addOrder(Order o){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(orderService.addOrder(o));
		return jp;
	}
	
	@RequestMapping(value="/orders/{id}",method=RequestMethod.GET)
	public JsonProtocol getOrder(@PathVariable(value="id") Integer oid){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(orderService.getOrder(oid));
		return jp;
	}


	@RequestMapping(value="/orders/{id}/notice",method=RequestMethod.PUT)
	public JsonProtocol updateMessage(@PathVariable(value="id") Integer oId,String notice){

		JsonProtocol jp = new JsonProtocol();
		jp.setObject(orderService.updateMessage(oId, notice));
		return jp;
	}
	

	@RequestMapping(value="/orders/{id}/sc",method=RequestMethod.PUT)
	public JsonProtocol updateScore(@PathVariable(value="id") Integer oId,Integer sc){

		JsonProtocol jp = new JsonProtocol();
		jp.setObject(orderService.updateScore(oId, sc));
		return jp;
	}
	
}
