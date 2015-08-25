package com.g04.o2o.service;


import org.springframework.stereotype.Service;

import com.g04.o2o.entity.Order;
/**
 * 订单服务接口
 * @author CHENJA9
 *
 */
@Service
public interface OrderService {

	int addOrder(Order o);
	
	Order getOrder(Integer oid);
	
	int updateMessage(Integer oId,String notice);
	
	int updateScore(Integer oId,Integer sc);
}
