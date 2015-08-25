package com.g04.o2o.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.MenuType;
import com.g04.o2o.entity.Order;
import com.g04.o2o.entity.Restaurant;

/**
 *  餐厅服务接口
 * @author CHENJA9
 *
 */
@Transactional
public interface RestaurantService {

	/**
	 * 注册成为餐厅
	 * @param r
	 * @return
	 */
	int registRestaurant(Restaurant r);
	
	Set<Restaurant> getRestByType(String type);
	
	Set<String> getRestTypes();
	
	Restaurant getRestInfo(Integer id);
	
	Set<MenuType> getMenuType(Integer id);
	
	Set<MenuItem> getMenuItems(Integer id);
	
	List<Order> getHighOrders(Integer id);
	
	List<Order> getMidOrders(Integer id);
	
	List<Order> getLowOrders(Integer id);
	
}
