package com.g04.o2o.service.impl;

import java.util.List;

import javax.persistence.Transient;

import org.springframework.stereotype.Service;

import com.g04.o2o.dao.MainSystemDao;
import com.g04.o2o.dao.RestaurantTypeDao;
import com.g04.o2o.entity.HotLine;
import com.g04.o2o.entity.MainSystem;
import com.g04.o2o.entity.RestaurantType;
import com.g04.o2o.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	private MainSystemDao mainSystemDao;
	private RestaurantTypeDao restaurantTypeDao;

	@Override
	@Transient
	public MainSystem getSystemTimes() {
		List<MainSystem> lists = mainSystemDao.searchAll(MainSystem.class);
		return lists.get(0);
	}

	@Override
	public boolean updateSystemTimes(MainSystem mainSystem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transient
	public List<RestaurantType> getAllRestType() {
		return restaurantTypeDao.searchAll(RestaurantType.class);
	}

	@Override
	@Transient
	public boolean addRestaurantType(String type) {
		RestaurantType restaurantType = new RestaurantType();
		restaurantType.setType(type);
		return restaurantTypeDao.add(restaurantType) == -1;
	}

	@Override
	@Transient
	public boolean updateRestaurantType(Integer id, String type) {
		restaurantTypeDao.search(RestaurantType.class, id).setType(type);
		return false;
	}

	@Override
	@Transient
	public boolean updateHotLines(Integer id, String tel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transient
	public boolean addHotLines(String tel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transient
	public HotLine getHotLines() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transient
	public boolean deleteHotLine(Integer id) {
		// mainSystemDao.search(HotLine.class, id);
		return false;
	}

	@Override
	@Transient
	public boolean verifyRestaurant(Integer id, Integer state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transient
	public boolean resetPsd(String tel) {
		// TODO Auto-generated method stub
		return false;
	}

	public MainSystemDao getMainSystemDao() {
		return mainSystemDao;
	}

	public void setMainSystemDao(MainSystemDao mainSystemDao) {
		this.mainSystemDao = mainSystemDao;
	}
}
