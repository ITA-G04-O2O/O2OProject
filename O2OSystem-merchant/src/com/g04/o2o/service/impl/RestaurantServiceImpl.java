package com.g04.o2o.service.impl;

import java.util.List;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g04.o2o.dao.RestaurantDao;
import com.g04.o2o.dao.RestaurantTypeDao;
import com.g04.o2o.entity.Address;
import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.RestaurantType;
import com.g04.o2o.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private RestaurantDao dao;

	@Autowired
	private RestaurantTypeDao tdao;

	@Override
	public int addRestaurant(Restaurant rest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transient
	public int updateRestName(Integer restId, String name) {
		try {
			dao.search(Restaurant.class, restId).setName(name);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	@Override
	public int addMenu(MenuItem menu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRestType(Integer restId, RestaurantType type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRestAddr(Integer restId, Address addr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Restaurant getRestById(Integer restId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateRestNotice(Integer restId, String notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRestPlayPrice(Integer restId, Integer price) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRestDisCharge(Integer restId, Integer disCharge) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOpenTime(Integer restId, String openTime) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RestaurantType> getTypes() {
		return tdao.searchAll(RestaurantType.class);
	}

}
