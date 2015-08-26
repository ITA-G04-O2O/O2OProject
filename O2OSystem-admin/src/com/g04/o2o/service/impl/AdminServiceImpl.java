package com.g04.o2o.service.impl;

import java.util.List;

import com.g04.o2o.entity.HotLine;
import com.g04.o2o.entity.MainSystem;
import com.g04.o2o.entity.RestaurantType;
import com.g04.o2o.service.AdminService;

public class AdminServiceImpl implements AdminService {

	@Override
	public Integer getAutoExpirationTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAutoCompleteTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setDefaultSetting(MainSystem mainSystem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean setOriginalSetting(Integer autoExpirationTime,
			Integer autoCompletedTime) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSystemTimes(MainSystem mainSystem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RestaurantType> getAllRestType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addRestaurantType(String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRestaurantType(Integer id, String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHotLines(Integer id, String tel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addHotLines(String tel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HotLine getHotLines() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteHotLine(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyRestaurant(Integer id, Integer state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetPsd(String tel) {
		// TODO Auto-generated method stub
		return false;
	}

}
