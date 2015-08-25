package com.g04.o2o.service;

import com.g04.o2o.entity.Address;
import com.g04.o2o.entity.User;

/**
 * 用户服务接口
 * 
 * @author LILE8
 * 
 */
public interface UserService {
	/**
	 * 添加用户
	 * 
	 * @return
	 */
	public int addUser(User user);
	
	/**
	 * 获得某个用户
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);

	/**
	 * 重置用户密码
	 * 
	 * @param id
	 * @return
	 */
	public int resetUserPassword(Integer id);

	/**
	 * 更新用户名
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	public int updateUserLoginName(Integer id, String name);

	/**
	 * 更新用户密码
	 * 
	 * @param id
	 * @param password
	 * @return
	 */
	public int updateUserPassword(Integer id, String password);

	/**
	 * 用户充值
	 * 
	 * @param id
	 * @param change
	 * @return
	 */
	public int addUserBalance(Integer id, int change);

	/**
	 * 用户消费
	 * 
	 * @param id
	 * @param change
	 * @return
	 */
	public int reduceUserBalance(Integer id, int change);

	/**
	 * 用户添加地址
	 * 
	 * @param id
	 * @param addr
	 * @return
	 */
	public int addAddress(Integer id, Address addr);

	/**
	 * 用户添加收藏
	 * 
	 * @param id
	 * @param restId
	 * @return
	 */
	public int addRestlikes(Integer id, int restId);

}
