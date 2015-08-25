package com.g04.o2o.service;


import org.springframework.stereotype.Service;

import com.g04.o2o.entity.Order;
/**
 * 订单服务接口
 * @author CHENJA9
 *
 */

<<<<<<< HEAD
@Service
=======
>>>>>>> f9718c87fab240cd26340eda0a279053a2446c13
public interface OrderService {

	/**
	 * 添加订单
	 * @param o
	 * @return
	 */
	int addOrder(Order o);
	/**
	 * 获取订单内容
	 * @param oid
	 * @return
	 */
	Order getOrder(Integer oid);
	/**
	 * 添加评价内容
	 * @param oId
	 * @param notice
	 * @return
	 */
	int updateMessage(Integer oId,String notice);
	/**
	 * 添加评分
	 * @param oId
	 * @param sc
	 * @return
	 */
	int updateScore(Integer oId,Integer sc);
}
