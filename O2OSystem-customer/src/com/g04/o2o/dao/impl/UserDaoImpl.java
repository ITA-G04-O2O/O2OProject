package com.g04.o2o.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.g04.o2o.dao.UserDao;
import com.g04.o2o.entity.User;


@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao{
		
	@Override
	public User searchUser(String username) {

		String hql = "from User where loginName=:name";
		Query query=manager.createQuery(hql);
		query.setParameter("name", username);
		return (User) query.getSingleResult();
	}

	@Override
	public int login(String loginName, String psd) {
		
		String hql = "from User where loginName=:name and password=:psd";
		Query query=manager.createQuery(hql);
		query.setParameter("name", loginName);
		query.setParameter("password", psd);
		
		User user = (User) query.getSingleResult();
		if(user==null){
			return -1;
		}else{
			return user.getId();
		}
	}
}
