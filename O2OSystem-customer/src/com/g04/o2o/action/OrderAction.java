package com.g04.o2o.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.entity.Order;
import com.g04.o2o.service.OrderService;

<<<<<<< HEAD

=======
>>>>>>> f9b1bcf495192991884d166171bb2ee24d158023
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
	
<<<<<<< HEAD
	@RequestMapping(value="/orders/{id}",method=RequestMethod.POST)
	public JsonProtocol updateMessage(Integer oId,String notice){
=======
	@RequestMapping(value="/orders/{id}/notice",method=RequestMethod.PUT)
	public JsonProtocol updateMessage(@PathVariable(value="id") Integer oId,String notice){
>>>>>>> f9b1bcf495192991884d166171bb2ee24d158023
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(orderService.updateMessage(oId, notice));
		return jp;
	}
	
<<<<<<< HEAD
	@RequestMapping(value="/orders/ss",method=RequestMethod.POST)
	public JsonProtocol updateScore(Integer oId,Integer sc){
=======
	@RequestMapping(value="/orders/{id}/sc",method=RequestMethod.PUT)
	public JsonProtocol updateScore(@PathVariable(value="id") Integer oId,Integer sc){
>>>>>>> f9b1bcf495192991884d166171bb2ee24d158023
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(orderService.updateScore(oId, sc));
		return jp;
	}
	
}
