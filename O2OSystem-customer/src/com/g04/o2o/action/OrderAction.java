package com.g04.o2o.action;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vo.MenuItemVo;
import vo.OrderVo;
import vo.helper.OrderVoHelper;

import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.entity.Order;
import com.g04.o2o.service.OrderService;


@RestController
public class OrderAction {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/orders",method=RequestMethod.POST)
	public JsonProtocol addOrder(HttpSession session,@RequestParam("tel")String tel,String address,String uname,String message,Double totalPrice){
		
		@SuppressWarnings("unchecked")
		List<MenuItemVo> orderVo=(List<MenuItemVo>)session.getAttribute("userOrder");
		Integer restId=(Integer) session.getAttribute("restId");
		Order order=OrderVoHelper.getOrderFromVo(orderVo,restId);
		order.setTel(tel);
		order.setMessage(message);
		order.setUserDefineAddress(address);
		order.setContactName(uname);
		JsonProtocol jp = new JsonProtocol();
		if(orderService.addOrder(order)>=1){
			jp.setResult(true);
		}else{
			jp.setResult(false);
		}
		
		return jp;
	}
	

	@Transactional
	@RequestMapping(value="/orders/{id}",method=RequestMethod.GET)
	public JsonProtocol getOrder(@PathVariable(value="id") Integer oid){
		JsonProtocol jp = new JsonProtocol();
		Order order=orderService.getOrder(oid);
		Integer uid=order.getUser().getId();
		OrderVo orderVo = null;
		if(order!=null){
			orderVo= OrderVoHelper.get(order);
			orderVo.setUid(uid);
		}
		
		jp.setObject(orderVo);
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
	
	@RequestMapping(value="/orders/{id}/status",method=RequestMethod.PUT)
	public JsonProtocol updateStatus(@PathVariable(value="id") Integer oId,Integer status){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(orderService.updateStatus(oId, status));
		return jp;
	}
	
}
