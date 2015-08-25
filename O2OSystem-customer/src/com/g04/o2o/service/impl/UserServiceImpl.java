package com.g04.o2o.service.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g04.o2o.dao.OrderDao;
import com.g04.o2o.dao.RestaurantDao;
import com.g04.o2o.dao.UserDao;
import com.g04.o2o.entity.Order;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.User;
import com.g04.o2o.service.UserService;
@Service

public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao dao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private RestaurantDao restaurantDao;
	@Transactional
	@Override
	public User getUserInfo(Integer uid) {
		return dao.search(User.class, uid);
	}

	@Transactional
	@Override
	public List<Order> getUserOrder(Integer uid) {
		 return null;
	}
	@Transactional
	@Override
	public Set<Restaurant> getUserRestlikes(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public int addRestlikes(Integer uid, Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Transactional
	@Override
	public int delRestlikes(Integer uid, Integer id) {
		dao.search(User.class, uid).getRestlikes().remove(restaurantDao.search(Restaurant.class, id));
		return 1;
	}

	@Override
	public int regist(String loginName, String psd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int login(String loginName, String psd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
