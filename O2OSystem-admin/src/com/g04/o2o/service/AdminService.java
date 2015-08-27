package com.g04.o2o.service;

import java.util.List;

import com.g04.o2o.entity.HotLine;
import com.g04.o2o.entity.MainSystem;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.RestaurantType;
import com.g04.o2o.entity.User;

public interface AdminService {
	//
	// public Integer getAutoExpirationTime();
	//
	// public Integer getAutoCompleteTime();
	//
	// public int setDefaultSetting(MainSystem mainSystem);
	//
	// public boolean setOriginalSetting(Integer autoExpirationTime,
	// Integer autoCompletedTime);

	public List<MainSystem> getSystemTimes();

	public boolean updateSystemTimes(MainSystem mainSystem);

	public boolean addSystemTimes(MainSystem mainSystem);

	public List<RestaurantType> getAllRestType();

	public boolean addRestaurantType(String type);

	public boolean updateRestaurantType(Integer id, String type);

	public boolean updateHotLines(Integer id, String tel);

	public boolean addHotLines(String tel);

	public List<HotLine> getHotLines();

	public boolean deleteHotLine(Integer id);

	public boolean verifyRestaurant(Integer id, Integer state);

	public boolean resetPsd(String tel);

	public List<User> getUsers();

	public boolean setHot(Integer id, boolean isHot);

	public List<Restaurant> getRestaurants();

	public boolean setClose(Integer id);

}
