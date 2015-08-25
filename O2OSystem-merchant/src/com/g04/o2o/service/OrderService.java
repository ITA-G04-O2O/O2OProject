package com.g04.o2o.service;

import java.util.Date;
import java.util.List;

import com.g04.o2o.entity.Order;

/**
 * Order Service
 * @author OUOK
 *
 */

public interface OrderService {
	/**
	 * 獲取所有訂單
	 * @return
	 */
	List<Order> getAllOrders();
	/**
	 * 根據id獲取訂單
	 * @param id
	 * @return
	 */
	Order getOrderById(Integer id);
	/**
	 * 更新訂單接單時間
	 * @param id
	 * @param recevieTime
	 * @return
	 */
	boolean updOrderReceiveTime(Integer id, Date recevieTime);
	/**
	 * 更新訂單確認訂單時間
	 * @param id
	 * @param recevieTime
	 * @return
	 */
	boolean updOrderCompleteTime(Integer id, Date completedTime);
	/**
	 * 更新訂單狀態
	 * @param id
	 * @param status
	 * @return
	 */
	boolean updOrderStatus(Integer id, Integer status);
}
