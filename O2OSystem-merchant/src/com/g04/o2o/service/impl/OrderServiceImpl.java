package com.g04.o2o.service.impl;

import java.util.Date;
import java.util.List;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;

import com.g04.o2o.dao.OrderDao;
=======
import org.springframework.stereotype.Service;

>>>>>>> f9718c87fab240cd26340eda0a279053a2446c13
import com.g04.o2o.entity.Order;
import com.g04.o2o.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao od;

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
