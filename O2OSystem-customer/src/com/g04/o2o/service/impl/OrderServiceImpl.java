package com.g04.o2o.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g04.o2o.dao.OrderDao;
import com.g04.o2o.entity.Order;
import com.g04.o2o.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao dao;
	@Override
	@Transactional
	public int addOrder(Order o) {
		return dao.add(o);
	}

	@Transactional
	@Override
	public Order getOrder(Integer oid) {
		return dao.search(Order.class, oid);
	}

	@Transactional
	@Override
	public int updateMessage(Integer oId, String notice) {
		return dao.updateValue(oId, Order.class, "message", notice);
	}

	@Transactional
	@Override
	public int updateScore(Integer oId, Integer sc) {
		return dao.updateValue(oId, Order.class, "score", Double.parseDouble(sc.toString()));
	}

}
