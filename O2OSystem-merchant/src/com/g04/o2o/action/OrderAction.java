package com.g04.o2o.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.entity.Order;
import com.g04.o2o.service.OrderService;
import com.g04.o2o.vo.GetOrderVO;
import com.g04.o2o.vo.helper.GetOrderVOHelper;

/**
 * Order handler function
 * 
 * @author OUOK
 * 
 */
@RestController
public class OrderAction {
	@Autowired
	private OrderService os;

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public JsonProtocol getOrders() {
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(os.getAllOrders());
		return jp;
	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public JsonProtocol getOrder(@PathVariable Integer id) {
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(os.getOrderById(id));
		return jp;
	}
	
	@Transactional
	@RequestMapping(value = "/orders/new", method = RequestMethod.GET)
	public JsonProtocol getNewOrders() {
		JsonProtocol jp = new JsonProtocol();
//		List<Order> newOrders = os.getAllNewOrders();
//		System.out.println("newOrders size is "+newOrders.size());
//		jp.setObject(newOrders);
		
		System.out.println(os.getAllNewOrders().size());
		
		List<GetOrderVO> goVoList = new ArrayList<GetOrderVO>();
		for (Order order : os.getAllNewOrders()) {
			GetOrderVO getVo = GetOrderVOHelper.setOrder2VO(order);
			goVoList.add(getVo);
		}
		jp.setObject(goVoList);
		return jp;
	}
	
	@Transactional
	@RequestMapping(value = "/orders/receive", method = RequestMethod.GET)
	public JsonProtocol getAllReceiveOrders() {
		JsonProtocol jp = new JsonProtocol();
//		jp.setObject(os.getAllReceiveOrders());
		List<GetOrderVO> goVoList = new ArrayList<GetOrderVO>();
		for (Order order : os.getAllReceiveOrders()) {
			GetOrderVO getVo = GetOrderVOHelper.setOrder2VO(order);
			goVoList.add(getVo);
		}
		jp.setObject(goVoList);
		return jp;
	}
	
	@Transactional
	@RequestMapping(value = "/orders/finish", method = RequestMethod.GET)
	public JsonProtocol getAllFinishedOrders() {
		JsonProtocol jp = new JsonProtocol();
//		jp.setObject(os.getAllFinishedOrders());
		List<GetOrderVO> goVoList = new ArrayList<GetOrderVO>();
		for (Order order : os.getAllFinishedOrders()) {
			GetOrderVO getVo = GetOrderVOHelper.setOrder2VO(order);
			goVoList.add(getVo);
		}
		jp.setObject(goVoList);
		return jp;
	}
	
	@Transactional
	@RequestMapping(value = "/orders/fail", method = RequestMethod.GET)
	public JsonProtocol getAllFailOrders() {
		JsonProtocol jp = new JsonProtocol();		
		List<GetOrderVO> goVoList = new ArrayList<GetOrderVO>();
		for (Order order : os.getAllFailOrders()) {
			GetOrderVO getVo = GetOrderVOHelper.setOrder2VO(order);
			goVoList.add(getVo);
		}
		jp.setObject(goVoList);
		return jp;
	}

	@RequestMapping(value = "/orders/{id}/rece", method = RequestMethod.PUT)
	public JsonProtocol updateOrderReceiveTime(@PathVariable Integer id) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(os.updOrderReceiveTime(id, new Date()));
		return jp;
	}

	@RequestMapping(value = "/orders/{id}/comp", method = RequestMethod.PUT)
	public JsonProtocol updOrderCompleteTime(@PathVariable Integer id) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(os.updOrderCompleteTime(id, new Date()));
		return jp;
	}

	/**
	 * update order's status with id&status.
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/orders/{id}/{status}", method = RequestMethod.PUT)
	public JsonProtocol updOrderStatus(@PathVariable Integer id, @PathVariable Integer status) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(os.updOrderStatus(id, status));
		return jp;
	}
}
