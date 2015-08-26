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
	/**
	 * 更新订单状态
	 * @param oId
	 * @param status
	 * @return
	 */
	int updateStatus(Integer oId,Integer status);
}
