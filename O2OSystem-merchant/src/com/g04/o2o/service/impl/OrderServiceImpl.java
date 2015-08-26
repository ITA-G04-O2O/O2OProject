package com.g04.o2o.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g04.o2o.dao.OrderDao;
import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.Order;
import com.g04.o2o.service.OrderService;

/**
 * OrderService實現類
 * @author OUOK
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao od;

	@Override
	public List<Order> getAllOrders() {
		return od.searchAll(Order.class);
	}

	@Override
	public Order getOrderById(Integer id) {
		return od.search(Order.class, id);
	}

	@Override
	@Transient
	public boolean updOrderReceiveTime(Integer id, Date recevieTime) {
		try {
			od.search(Order.class, id).setReceiveTime(recevieTime);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transient
	public boolean updOrderCompleteTime(Integer id, Date completedTime) {
		try {
			od.search(Order.class, id).setCompletedTime(completedTime);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transient
	public boolean updOrderStatus(Integer id, Integer status) {
		try {
			od.search(Order.class, id).setStatus(status);;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Order> getAllNewOrders() {
		List<Order> allOrders = od.searchAll(Order.class);
		for (Order order : allOrders) {
			
		}
		return null;
	}

	@Override
	public List<Order> getAllHistoryOrders() {
		// TODO Auto-generated method stub
		return null;
	}



}
