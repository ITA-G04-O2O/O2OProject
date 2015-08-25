package com.g04.o2o.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.MenuType;
import com.g04.o2o.entity.Order;
import com.g04.o2o.entity.Restaurant;

/**
 *  餐厅服务接口
 * @author CHENJA9
 *
 */
@Service
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
	List<Restaurant> getRestByType(String type);
	/**
	 * 获取餐厅种类
	 * @return
	 */
	Set<String> getRestTypes();
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
	List<MenuItem> getMenuItems(Integer id);
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
	
}