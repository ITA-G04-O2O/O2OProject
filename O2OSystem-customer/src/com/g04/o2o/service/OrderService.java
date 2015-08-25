package com.g04.o2o.service;


import com.g04.o2o.entity.Order;
/**
 * Order服务接口
 * @author CHENJA9
 *
 */
public interface OrderService {

	int addOrder(Order o);
	
	Order getOrder(Integer oid);
	
	int updateMessage(Integer oId,String notice);
	
	int updateScore(Integer oId,Integer sc);
}
