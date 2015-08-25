package com.g04.o2o.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g04.o2o.dao.MenuTypeDao;
import com.g04.o2o.dao.RestaurantDao;
import com.g04.o2o.dao.RestaurantTypeDao;
import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.MenuType;
import com.g04.o2o.entity.Order;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.RestaurantType;
import com.g04.o2o.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private RestaurantDao dao;
	@Autowired
	private RestaurantTypeDao restTypeDao;
	@Autowired
	private MenuTypeDao menuTypeDao;

	@Override
	public int registRestaurant(Restaurant r) {
		return dao.add(r);
	}

	@Override
	public Set<Restaurant> getRestByType(String type) {
		return restTypeDao.getRestByTpe(type);

	}

	@Override
	public Set<String> getRestTypes() {
		List<RestaurantType> restTypes = restTypeDao.searchAll(RestaurantType.class);
		
		Set<String> targetSet = new HashSet<>();
		
		for (RestaurantType type : restTypes) {
			targetSet.add(type.getType());
		}
		
		return targetSet;
	}

	@Override
	public Restaurant getRestInfo(Integer id) {
		return dao.search(Restaurant.class, id);
	}

	@Override
	public Set<MenuType> getMenuType(Integer id) {
		
		List<MenuType> menuTypes = menuTypeDao.searchAll(MenuType.class);
		
		Set<MenuType> targetSet = new HashSet<>();
		
		for (MenuType type : menuTypes) {
			targetSet.add(type);
		}
		
		return targetSet;
	}

	@Override
	public Set<MenuItem> getMenuItems(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getHighOrders(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getMidOrders(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getLowOrders(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
