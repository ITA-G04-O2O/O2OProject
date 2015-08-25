package com.g04.o2o.service;

import com.g04.o2o.entity.Address;
import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.RestaurantType;

/**
 * 餐厅服务接口
 * 
 * @author LILE8
 * 
 */
public interface RestaurantService {

	/**
	 * 添加餐厅
	 * 
	 * @param rest
	 * @return
	 */
	public int addRestaurant(Restaurant rest);

	/**
	 * 更新餐厅信息 基本类型信息
	 * 
	 * @return
	 */
	public int updateRestaurant(Integer restId, String property, Object obj);

	/**
	 * 添加菜单项
	 * 
	 * @param menu
	 * @return
	 */
	public int addMenu(MenuItem menu);

	/**
	 * 更新商家类型
	 * 
	 * @param restId
	 * @param type
	 * @return
	 */
	public int updateRestType(Integer restId, RestaurantType type);

	/**
	 * 更新店地址
	 * 
	 * @param restId
	 * @param type
	 * @return
	 */
	public int updateRestAddr(Integer restId, Address addr);

}
