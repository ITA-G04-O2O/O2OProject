package com.g04.o2o.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.g04.o2o.entity.Order;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.User;

@Transactional
@Service
/**
 * ç”¨æˆ·æœ�åŠ¡æŽ¥å�£
 * @author CHENJA9
 *
 */

public interface UserService {

	/**
	 * ç”¨æˆ·æ³¨å†Œ
	 * @param loginName
	 * @param psd
	 * @return
	 */
	int regist(String loginName, String psd);
	/**
	 * ç”¨æˆ·ç™»é™†
	 * @param loginName
	 * @param psd
	 * @return
	 */
	int login(String loginName, String psd);
	/**
	 * èŽ·å�–ç”¨æˆ·ä¿¡æ�¯
	 * @param uid
	 * @return
	 */
	User getUserInfo(Integer uid);
	/**
	 * èŽ·å�–ç”¨æˆ·è®¢å�•ä¿¡æ�¯
	 * @param uid
	 * @return
	 */
	List<Order> getUserOrder(Integer uid);
	/**
	 * èŽ·å�–ç”¨æˆ·æ”¶è—�åˆ—è¡¨
	 * @param uid
	 * @return
	 */
	Set<Restaurant> getUserRestlikes(Integer uid);
	/**
	 * æ·»åŠ æ”¶è—�
	 * @param uid
	 * @param id
	 * @return
	 */
	int addRestlikes(Integer uid, Integer id);
	/**
	 * å�–æ¶ˆæ”¶è—�
	 * @param uid
	 * @param id
	 * @return
	 */
	int delRestlikes(Integer uid, Integer id);
}
