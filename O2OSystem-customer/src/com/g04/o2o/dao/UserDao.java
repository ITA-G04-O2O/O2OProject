package com.g04.o2o.dao;


import com.g04.o2o.entity.User;

public interface UserDao extends AbstractDao<User>{
	User searchUser(String username);

	int login(String loginName, String psd);

}
