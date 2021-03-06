package com.g04.o2o.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.g04.o2o.entity.Order;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.User;

/**
 * 用户服务接口
 * @author CHENJA9
 *
 */

public interface UserService {

	/**
	 * 用户注册
	 * @param loginName
	 * @param psd
	 * @return
	 */
	int regist(String loginName, String psd);
	/**
	 * 用户登陆
	 * @param loginName
	 * @param psd
	 * @return
	 */
	int login(String loginName, String psd);
	/**
	 * 获取用户信息
	 * @param uid
	 * @return
	 */
	User getUserInfo(Integer uid);
	/**
	 * 获取用户订单信息
	 * @param uid
	 * @return
	 */
	List<Order> getUserOrder(Integer uid);
	/**
	 * 获取用户
	 * @param uid
	 * @return
	 */
	Set<Restaurant> getUserRestlikes(Integer uid);
	/**
	 * 添加收藏
	 * @param uid
	 * @param id
	 * @return
	 */
	int addRestlikes(Integer uid, Integer id);
	/**
	 * 取消收藏
	 * @param uid
	 * @param id
	 * @return
	 */
	int delRestlikes(Integer uid, Integer id);
	
	Integer changNickName(Integer uid, String nickName);
	
	Integer changePwd(Integer uid, String psd);
}
