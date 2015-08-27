package com.g04.o2o.service.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g04.o2o.dao.RestaurantDao;
import com.g04.o2o.dao.UserDao;
import com.g04.o2o.entity.Order;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.User;
import com.g04.o2o.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	@Autowired
	private RestaurantDao restaurantDao;

	@Transactional
	@Override
	public User getUserInfo(Integer uid) {
		return dao.search(User.class, uid);
	}

	
	@Override
	public List<Order> getUserOrder(Integer uid) {
		return dao.search(User.class, uid).getHistoryOrders();
	}

	@Transactional
	@Override
	public Set<Restaurant> getUserRestlikes(Integer uid) {
		return dao.search(User.class, uid).getRestlikes();
	}

	@Transactional
	@Override
	public int addRestlikes(Integer uid, Integer id) {
		try {
			Restaurant rest = restaurantDao.search(Restaurant.class, id);
			dao.search(User.class, uid).getRestlikes().add(rest);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Transactional
	@Override
	public int delRestlikes(Integer uid, Integer id) {
		dao.search(User.class, uid).getRestlikes().remove(restaurantDao.search(Restaurant.class, id));
		return 1;
	}

	@Transactional
	@Override
	public int regist(String loginName, String psd) {
		try {
			User user = new User();
			user.setLoginName(loginName);
			user.setPassword(psd);
			return 1;

		} catch (Exception e) {
			return -1;
		}

	}

	@Transactional
	@Override
	public int login(String loginName, String psd) {
		return dao.login(loginName, psd);
	}


	@Transactional
	@Override
	public Integer changNickName(Integer uid, String nickName) {
		try {
			User user=dao.search(User.class, uid);
			user.setNickName(nickName);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}


	@Transactional
	@Override
	public Integer changePwd(Integer uid, String psd) {
		try {
			User user=dao.search(User.class, uid);
			user.setPassword(psd);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

}
