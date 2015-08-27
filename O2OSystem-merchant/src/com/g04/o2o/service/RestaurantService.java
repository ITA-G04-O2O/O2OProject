package com.g04.o2o.service;

import java.util.List;

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
	 * 获得所有餐厅类型
	 * 
	 * @return
	 */
	public List<RestaurantType> getTypes();

	/**
	 * 更新餐厅信息 基本类型信息
	 * 
	 * @return
	 */
	public int updateRestName(Integer restId, String name);

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

	/**
	 * 获取某个商店
	 * 
	 * @param restId
	 * @return
	 */
	public Restaurant getRestById(Integer restId);

	/**
	 * 更新商店公告
	 * 
	 * @param restId
	 * @param notice
	 * @return
	 */
	public int updateRestNotice(Integer restId, String notice);

	/**
	 * 更改起送价
	 * 
	 * @param restId
	 * @param price
	 * @return
	 */
	public int updateRestPlayPrice(Integer restId, Integer price);

	/**
	 * 更改配送费
	 * 
	 * @param restId
	 * @param disCharge
	 * @return
	 */
	public int updateRestDisCharge(Integer restId, Integer disCharge);

	/**
	 * 更改营业时间
	 * 
	 * @param restId
	 * @param openTime
	 * @return
	 */
	public int updateOpenTime(Integer restId, String openTime);

	/**
	 * 通过restaurant的Id获得类型
	 * 
	 * @param restTypeId
	 * @return
	 */
	public RestaurantType getRestTypeById(Integer restTypeId);

}
