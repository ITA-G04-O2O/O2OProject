package com.g04.o2o.service;

import java.util.List;

import com.g04.o2o.entity.HotLine;
import com.g04.o2o.entity.MainSystem;
import com.g04.o2o.entity.RestaurantType;

public interface AdminService {

	/**
	 * 获取自动过期时间
	 * 
	 * @return
	 */
	public Integer getAutoExpirationTime();

	/**
	 * 获取订单自动完成时间
	 * 
	 * @return
	 */
	public Integer getAutoCompleteTime();

	/**
	 * 恢复出厂设置
	 * 
	 * @param mainSystem
	 * @return
	 */
	public int setDefaultSetting(MainSystem mainSystem);

	/**
	 * 设置初始值
	 * 
	 * @param autoExpirationTime
	 * @param autoCompletedTime
	 * @return
	 */
	public boolean setOriginalSetting(Integer autoExpirationTime,
			Integer autoCompletedTime);

	/**
	 * 修改自动过期时间
	 * 
	 * @param autoExpirationTime
	 * @return
	 */
	public boolean updateSystemTimes(MainSystem mainSystem);

	/**
	 * 获取所有餐厅类型
	 * 
	 * @return
	 */
	public List<RestaurantType> getAllRestType();

	/**
	 * 添加餐厅类型
	 * 
	 * @param type
	 * @return
	 */
	public boolean addRestaurantType(String type);

	/**
	 * 修改餐厅类型
	 * 
	 * @param type
	 * @return
	 */
	public boolean updateRestaurantType(Integer id, String type);

	public boolean updateHotLines(Integer id, String tel);

	public boolean addHotLines(String tel);

	public HotLine getHotLines();

	public boolean deleteHotLine(Integer id);

	public boolean verifyRestaurant(Integer id, Integer state);

	public boolean resetPsd(String tel);
}
