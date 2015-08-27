package com.g04.o2o.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
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
		List<Order> newOrders = new ArrayList<Order>();
		for (Order order : allOrders) {
			if (order.getStatus() == 1) {
				newOrders.add(order);
			}
		}
		System.out.println("newOrders size is::::::::"+newOrders.size());
		return newOrders;
	}

	@Override
	public List<Order> getAllReceiveOrders() {
		List<Order> allOrders = od.searchAll(Order.class);
		List<Order> receOrders = new ArrayList<Order>();
		for (Order order : allOrders) {
			if (order.getStatus() == 2) {
				receOrders.add(order);
			}
		}
		return receOrders;
	}

	@Override
	public List<Order> getAllFinishedOrders() {
		List<Order> allOrders = od.searchAll(Order.class);
		List<Order> finishOrders = new ArrayList<Order>();
		for (Order order : allOrders) {
			if (order.getStatus() == 3) {
				finishOrders.add(order);
			}
		}
		return finishOrders;
	}

	@Override
	public List<Order> getAllFailOrders() {
		List<Order> allOrders = od.searchAll(Order.class);
		List<Order> finishOrders = new ArrayList<Order>();
		for (Order order : allOrders) {
			if (order.getStatus() == 4) {
				finishOrders.add(order);
			}
		}
		return finishOrders;
	}
}
