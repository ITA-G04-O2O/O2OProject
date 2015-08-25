package com.g04.o2o.servive;

import java.util.List;

import org.springframework.stereotype.Service;

import com.g04.o2o.bean.Condition;
import com.g04.o2o.entity.Restaurant;

/**
 * 餐厅服务 包括 设置黑名单，获取餐厅信息，设置热门餐厅，删除餐厅，更改餐厅信息
 * 
 * @author Administrator
 *
 */
@Service
public interface RestaurantService {
	
	Restaurant getMerchant(Integer id);

	Restaurant getMerchant(String name);

	int setHotMerchant(Restaurant merchant);

	int setHotMerchant(Integer id);

	int setHotMerchant(String name);

	int addMerchant(Restaurant merchant);

	int delMerchant(Integer id);

	int delMerchant(String name);

	int delMerchant(Restaurant merchant);

	List<Restaurant> getAllMerchant();

	List<Restaurant> getAllHotMerchant();
	
	List<Restaurant> getMerchantByCondition(Condition condition);

	int setBlackList(Restaurant merchant);

	int setBlackList(Integer id);

	int setBlackList(String name);
}
