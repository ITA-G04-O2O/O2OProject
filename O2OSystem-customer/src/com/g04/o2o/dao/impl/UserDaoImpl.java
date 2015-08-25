package com.g04.o2o.dao.impl;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.g04.o2o.dao.UserDao;
import com.g04.o2o.entity.User;

@Transactional
@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao{
		
	@Override
	public User searchUser(String username) {

		String hql = "from User where loginName=:name";
		Query query=manager.createQuery(hql);
		query.setParameter("name", username);
		return (User) query.getSingleResult();
	}
}
