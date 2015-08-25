package com.g04.o2o.service;

import java.util.List;

import com.g04.o2o.entity.MainSystem;
import com.g04.o2o.entity.RestaurantType;

public interface SystemService {

	/**
	 * 获取自动过期时间
	 * 
	 * @return
	 */
	Integer getAutoExpirationTime();

	/**
	 * 获取订单自动完成时间
	 * 
	 * @return
	 */
	Integer getAutoCompleteTime();

	/**
	 * 恢复出厂设置
	 * 
	 * @param mainSystem
	 * @return
	 */
	int setDefaultSetting(MainSystem mainSystem);

	/**
	 * 设置初始值
	 * 
	 * @param autoExpirationTime
	 * @param autoCompletedTime
	 * @return
	 */
	boolean setOriginalSetting(Integer autoExpirationTime,
			Integer autoCompletedTime);

	/**
	 * 修改自动过期时间
	 * 
	 * @param autoExpirationTime
	 * @return
	 */
	boolean updateSystemTimes(MainSystem mainSystem);

	/**
	 * 获取所有餐厅类型
	 * 
	 * @return
	 */
	List<RestaurantType> getAllRestType();

	/**
	 * 添加餐厅类型
	 * 
	 * @param type
	 * @return
	 */
	boolean addRestaurantType(String type);

	/**
	 * 修改餐厅类型
	 * 
	 * @param type
	 * @return
	 */
	boolean updateRestaurantType(Integer id, String type);

	boolean updateAirLines(Integer id, String tel);

	boolean addAirLines();
}
