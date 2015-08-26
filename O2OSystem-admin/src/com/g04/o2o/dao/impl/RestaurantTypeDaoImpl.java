package com.g04.o2o.dao.impl;

import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.g04.o2o.dao.RestaurantTypeDao;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.RestaurantType;
@Repository
public class RestaurantTypeDaoImpl extends AbstractDaoImpl<RestaurantType> implements RestaurantTypeDao{

	@Override
	public Set<Restaurant> getRestByTpe(String type) {
		String hql="from RestaurantType where type=:type";
		Query query=manager.createQuery(hql);
		query.setParameter("type",type);
		RestaurantType restType=(RestaurantType) query.getSingleResult();
		return restType.getHasRestaurants();
	}

}
