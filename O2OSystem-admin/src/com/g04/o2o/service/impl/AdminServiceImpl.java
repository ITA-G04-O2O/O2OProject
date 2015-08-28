package com.g04.o2o.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g04.o2o.dao.HotLineDao;
import com.g04.o2o.dao.MainSystemDao;
import com.g04.o2o.dao.RestaurantDao;
import com.g04.o2o.dao.RestaurantTypeDao;
import com.g04.o2o.dao.UserDao;
import com.g04.o2o.entity.HotLine;
import com.g04.o2o.entity.MainSystem;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.RestaurantType;
import com.g04.o2o.entity.User;
import com.g04.o2o.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private MainSystemDao mainSystemDao;
	@Autowired
	private RestaurantTypeDao restaurantTypeDao;
	@Autowired
	private HotLineDao hotLineDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RestaurantDao restaurantDao;

	@Override
	@Transactional
	public List<MainSystem> getSystemTimes() {
		return mainSystemDao.searchAll(MainSystem.class);
	}

	@Override
	@Transactional
	public boolean updateSystemTimes(MainSystem mainSystem) {
		return mainSystemDao.update(MainSystem.class, mainSystem.getId(),
				mainSystem) == 1;
	}

	@Override
	@Transactional
	public List<RestaurantType> getAllRestType() {
		return restaurantTypeDao.searchAll(RestaurantType.class);
	}

	@Override
	@Transactional
	public boolean addRestaurantType(String type) {
		RestaurantType restaurantType = new RestaurantType();
		restaurantType.setType(type);
		return restaurantTypeDao.add(restaurantType) == 1;
	}

	@Override
	@Transactional
	public boolean updateRestaurantType(Integer id, String type) {
		try {
			restaurantTypeDao.search(RestaurantType.class, id).setType(type);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public boolean updateHotLines(Integer id, String tel) {
		try {
			hotLineDao.search(HotLine.class, id).setTel(tel);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public boolean addHotLines(String tel) {
		HotLine hotLine = new HotLine();
		hotLine.setTel(tel);
		return hotLineDao.add(hotLine) == 1;
	}

	@Override
	@Transactional
	public List<HotLine> getHotLines() {
		return hotLineDao.searchAll(HotLine.class);
	}

	@Override
	@Transactional
	public boolean deleteHotLine(Integer id) {
		return hotLineDao.del(HotLine.class, id) == -1;
	}

	@Override
	@Transactional
	public boolean verifyRestaurant(Integer id, Integer state) {
		return restaurantDao
				.updateValue(id, Restaurant.class, "examine", state) == 1;
	}

	@Override
	@Transactional
	public boolean resetPsd(String tel) {
		for (User u : userDao.searchAll(User.class)) {
			if (u.getTel().equals(tel)) {
				return userDao.updateValue(u.getId(), User.class, "password",
						"123456") == 1;
			}
		}
		return false;
	}

	@Override
	@Transactional
	public boolean setHot(Integer id) {
		return restaurantDao.updateValue(id, Restaurant.class, "hot",
				!restaurantDao.search(Restaurant.class, id).isHot()) == 1;
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDao.searchAll(User.class);
	}

	@Override
	@Transactional
	public List<Restaurant> getRestaurants() {
		return restaurantDao.searchAll(Restaurant.class);
	}

	@Override
	@Transactional
	public boolean setClose(Integer id) {
		System.out.println(restaurantDao.search(Restaurant.class, id)
				.isOnline());
		return restaurantDao.updateValue(id, Restaurant.class, "online",
				!restaurantDao.search(Restaurant.class, id).isOnline()) == 1;
	}

	@Override
	@Transactional
	public boolean addSystemTimes(MainSystem mainSystem) {
		// TODO Auto-generated method stub
		return mainSystemDao.add(mainSystem) == 1;
	}

	@Override
	public Restaurant getRestaurantInfo(Integer id) {
		return restaurantDao.search(Restaurant.class, id);
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		return restaurantDao.searchAll(Restaurant.class);
	}

}
