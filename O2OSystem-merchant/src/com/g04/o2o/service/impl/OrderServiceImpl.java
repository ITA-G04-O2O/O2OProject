package com.g04.o2o.service.impl;

import java.util.Date;
import java.util.List;

import com.g04.o2o.entity.Order;
import com.g04.o2o.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updOrderReceiveTime(Integer id, Date recevieTime) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updOrderCompleteTime(Integer id, Date completedTime) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updOrderStatus(Integer id, Integer status) {
		// TODO Auto-generated method stub
		return false;
	}

}
