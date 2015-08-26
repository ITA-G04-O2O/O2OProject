package com.g04.o2o.service;

import java.util.Date;
import java.util.List;

import com.g04.o2o.entity.MenuItem;
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
	public List<Order> getAllOrders();
	/**
	 * 根據id獲取訂單
	 * @param id
	 * @return
	 */
	public Order getOrderById(Integer id);
	/**
	 * 更新訂單接單時間
	 * @param id
	 * @param recevieTime
	 * @return
	 */
	public boolean updOrderReceiveTime(Integer id, Date recevieTime);
	/**
	 * 更新訂單確認訂單時間
	 * @param id
	 * @param recevieTime
	 * @return
	 */
	public boolean updOrderCompleteTime(Integer id, Date completedTime);
	/**
	 * 更新訂單狀態
	 * @param id
	 * @param status
	 * @return
	 */
	public boolean updOrderStatus(Integer id, Integer status);
	
	/**
	 * 获取所有新订单
	 * @return
	 */
	public List<Order> getAllNewOrders();
	
	/**
	 * 获取所有历史订单
	 * @return
	 */
	public List<Order> getAllHistoryOrders();
	
}
