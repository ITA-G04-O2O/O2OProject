package com.g04.o2o.dao;

import java.util.List;

/**
 * 对象增删改查
 * @author DINGFR2
 *
 * @param <T> entity
 */
public interface AbstractDao<T> {
	
	/**
	 * 该方法只可用于更新值类型属性，不可以用于更新对象类型属性
	 * @param id 实体对象的id
	 * @param clz 需要更新值的试题类型
	 * @param property 实体的属性
	 * @param value 实体属性的值
	 * @return 1 成功 -1失败
	 */
	int updateValue(Integer id,Class<T> clz, String property, Object value);
	
	int add(T target);

	int del(Class<T> clazz,int id);

	List<T> searchAll(Class<T> clazz);

	T search(Class<T> clazz,Integer id);
	/**
	 * 更新整个对象属性 
	 * @param target
	 * @return
	 */
	int update(Class<T> clazz,Integer id,T target);
	/**
	 * 获取指定行数的数据库记录
	 * @param maxCount 最大行数 
	 * @param first 第一条记录开始行数，默认从0开始;
	 * @return 指定行数的记录数
	 */
	List<T> getRecords(Class<T> clazz,int maxCount,int first);
	
	/**
	 * 获取默认行数的数据库记录
	 * @return 记录集
	 */
	List<T> getDefaultRecords(Class<T> clazz);
	
}
