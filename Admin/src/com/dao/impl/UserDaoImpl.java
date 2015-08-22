package com.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.po.User;
@Repository("ud")
public class UserDaoImpl implements UserDao{
	@PersistenceContext
	private EntityManager em;
	 
	public void addUser(User u) {
//		EntityTransaction tx=em.getTransaction();
		em.persist(u);
//		tx.commit();
	}

}
