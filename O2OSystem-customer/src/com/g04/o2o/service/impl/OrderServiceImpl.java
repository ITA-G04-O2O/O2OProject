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
		try{
			Order order=dao.search(Order.class, oId);
			order.setMessage(notice);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	@Transactional
	@Override
	public int updateScore(Integer oId, Integer sc) {
		try{
			Order order=dao.search(Order.class, oId);
			order.setScore(2.0);
			
		}catch(Exception e){
			return -1;
		}
		return 1;
	}

}
