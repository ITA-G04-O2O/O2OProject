package com.g04.o2o.service;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.MenuType;
import com.g04.o2o.entity.Order;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.RestaurantType;

/**
 *  餐厅服务接口
 * @author CHENJA9
 *
 */

public interface RestaurantService {

	/**
	 * 注册成为餐厅
	 * @param r
	 * @return
	 */
	int registRestaurant(Restaurant r);
	/**
	 * 根据地址、种类查询餐厅
	 * @param type
	 * @return
	 */	
	Set<Restaurant> getRestByType(Integer id);
	/**
	 * 获取餐厅类型
	 * @return
	 */
	List<RestaurantType> getRestTypes();
	/**
	 * 获取餐厅具体信息
	 * @param id
	 * @return
	 */
	Restaurant getRestInfo(Integer id);
	/**
	 * 获取菜品种类
	 * @param id
	 * @return
	 */
	Set<MenuType> getMenuType(Integer id);
	/**
	 * 获取菜品具体信息
	 * @param id
	 * @return
	 */
	Set<MenuItem> getMenuItems(Integer id);
	/**
	 * 获取好评信息
	 * @param id
	 * @return
	 */
	List<Order> getHighOrders(Integer id);
	/**
	 * 获取中评信息
	 * @param id
	 * @return
	 */
	List<Order> getMidOrders(Integer id);
	/**
	 * 获取差评信息
	 * @param id
	 * @return
	 */
	List<Order> getLowOrders(Integer id);
	
	Set<MenuItem> getMenuItemByType(Integer rid,Integer menuTypeId);
}
