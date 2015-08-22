package com.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.po.User;
import com.service.UserManager;

@Service("um")
public class UserManagerImpl implements UserManager {
	@Autowired(required=true)
	private UserDao ud;
	@Transactional
	public void regist(User u) {
		ud.addUser(u);
	}

}
