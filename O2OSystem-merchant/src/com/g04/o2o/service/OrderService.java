package com.g04.o2o.service;

import java.util.Date;
import java.util.List;

import com.g04.o2o.entity.Order;

/**
 * Order Service
 * @author OUOK
 *
 */
public interface OrderService {
	List<Order> getAllOrders();
	Order getOrderById(Integer id);
	boolean updOrderReceiveTime(Integer id,Date recevieTime);
	boolean updOrderStatus(Integer id,Integer status);
}
