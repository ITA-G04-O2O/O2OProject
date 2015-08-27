package com.g04.o2o.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g04.o2o.dao.UserDao;
import com.g04.o2o.entity.Address;
import com.g04.o2o.entity.User;
import com.g04.o2o.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUserById(Integer id) {
		return dao.search(User.class, id);
	}

	@Override
	public int resetUserPassword(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUserLoginName(Integer id, String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUserPassword(Integer id, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addUserBalance(Integer id, int change) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reduceUserBalance(Integer id, int change) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addAddress(Integer id, Address addr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addRestlikes(Integer id, int restId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
