package com.g04.o2o.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g04.o2o.dao.MerchantDao;
import com.g04.o2o.dao.RestaurantDao;
import com.g04.o2o.dao.RestaurantTypeDao;
import com.g04.o2o.entity.Address;
import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.Merchant;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.RestaurantType;
import com.g04.o2o.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private RestaurantDao dao;

	@Autowired
	private RestaurantTypeDao tdao;

	@Autowired
	private MerchantDao mdao;

	@Override
	public int addRestaurant(Restaurant rest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public int updateRest(Integer restId, Restaurant rest) {
		try {
			dao.search(Restaurant.class, restId).setName(rest.getName());
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
		dao.search(Restaurant.class, restId).setType(type);
		return 0;
	}

	@Override
	public int updateRestAddr(Integer restId, Address addr) {
		try {
			dao.search(Restaurant.class, restId).setAddress(addr);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Restaurant getRestById(Integer restId) {
		// TODO Auto-generated method stub
		return dao.search(Restaurant.class, restId);
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

	@Override
	public RestaurantType getRestTypeById(Integer restTypeId) {
		return tdao.search(RestaurantType.class, restTypeId);
	}

	
	@Override
	public Restaurant findRestByUserId(int id) {
		Merchant mer = getMerchantById(id);
		List<Restaurant> rlist = dao.searchAll(Restaurant.class);
		for (Restaurant res : rlist) {
			Merchant m = res.getOwner();
			int oid = m.getId();
			if (oid == mer.getId()) {
				return res;
			}
		}
		return null;

	}

	private Merchant getMerchantById(int id) {
		List<Merchant> mlist = mdao.searchAll(Merchant.class);
		for (Merchant m : mlist) {
			if (id == m.getUser().getId()) {
				return m;
			}
		}
		return null;
	}

	@Override
	public int updateRestName(int restId, String name) {
		return dao.updateValue(restId, Restaurant.class, "name", name);
	}

	@Override
	public int updateTel(int restId, String tel) {

		return dao.updateValue(restId, Restaurant.class, "tel", tel);
	}
}
