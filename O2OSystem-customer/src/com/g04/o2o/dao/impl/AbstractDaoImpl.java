package com.g04.o2o.dao.impl;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.g04.o2o.dao.AbstractDao;
import com.g04.o2o.tools.SetterReflect;

/**
 * 抽象增删改查的实现
 * @author DINGFR2
 *
 * @param <T>
 */


public class  AbstractDaoImpl<T> implements AbstractDao<T>{
	@Autowired
	private SetterReflect reflect;
	@PersistenceContext
	protected EntityManager manager;
	/**
	 * 更新某个对象的属性
	 * @param id 需要更改属性值的entity的id
	 * @param clz entity的类型
	 * @param property 需要更改的属性
	 * @param value 值
	 * @return 1 成功 -1 失败
	 */
	@Override
	public int updateValue(Integer id,Class<T> clz, String property, Object value) {
			T targetT=(T) manager.find(clz, id);
			return reflect.updateValue(targetT, property, value);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getRecords(Class<T> clazz,int maxCount, int first) {
		String sqlString="from "+clazz.getSimpleName();
		Query query=manager.createQuery(sqlString);
		query.setFirstResult(first);
		query.setMaxResults(maxCount);
		return query.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getDefaultRecords(Class<T> clazz) {
		String sqlString="from "+clazz.getSimpleName();
		Query query=manager.createQuery(sqlString);
		query.setFirstResult(0);
		query.setMaxResults(100);
		return query.getResultList();
	}


	/* (non-Javadoc)
	 * @see com.g04.o2o.dao.AbstractDao#add(java.lang.Object)
	 */
	@Override
	public int add(T target) {
		manager.persist(target);
		return 1;
	}


	/* (non-Javadoc)
	 * @see com.g04.o2o.dao.AbstractDao#del(java.lang.Object)
	 */
	@Override
	public int del(Class<T> clazz,int id) {
		T target=manager.find(clazz, id);
		manager.remove(target);
		return 1;
	}


	/* (non-Javadoc)
	 * @see com.g04.o2o.dao.AbstractDao#searchAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll(Class<T> clazz) {
		String hqlString="from " + clazz.getSimpleName();
		Query query=manager.createQuery(hqlString);
		return query.getResultList();
	}


	/* (non-Javadoc)
	 * @see com.g04.o2o.dao.AbstractDao#search(java.lang.Integer)
	 */
	
	@Override
	public T search(Class<T> clazz,Integer id) {
		return (T) manager.find(clazz,id);
	}


	/* (non-Javadoc)
	 * @see com.g04.o2o.dao.AbstractDao#update(java.lang.Object)
	 */
	@Override
	public int update(Class<T> clazz,Integer id,T target) {
		try {
			Field[]targetFields=target.getClass().getDeclaredFields();
			Field[]properties=clazz.getDeclaredFields();
			for(int i=0;i<properties.length;i++){
				if(properties[i].getName().equals("id"))
					continue;
				properties[i].setAccessible(true);
				targetFields[i].setAccessible(true);
				String property=properties[i].getName();
				Object value=targetFields[i].get(target);
				updateValue(id, clazz, property, value);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
}
