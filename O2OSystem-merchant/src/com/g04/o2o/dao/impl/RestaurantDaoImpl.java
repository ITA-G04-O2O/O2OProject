package com.g04.o2o.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.g04.o2o.dao.RestaurantDao;
import com.g04.o2o.entity.Merchant;
import com.g04.o2o.entity.Restaurant;

@Repository
public class RestaurantDaoImpl extends AbstractDaoImpl<Restaurant> implements
		RestaurantDao {

	@Override
	public Restaurant findRestById(int id) {
		String hql = "from merchant where user=:id";
		Query query = manager.createQuery(hql);
		query.setParameter("id", id);
		Merchant m = (Merchant) query.getSingleResult();

		String hql2 = "from restaurant";
		Query query2 = manager.createQuery(hql2);
		List<Restaurant> list = query2.getResultList();
		for (Restaurant rs : list) {
			if (rs.getOwner() == m) {
				return rs;
			}
		}

		return null;
	}

}
