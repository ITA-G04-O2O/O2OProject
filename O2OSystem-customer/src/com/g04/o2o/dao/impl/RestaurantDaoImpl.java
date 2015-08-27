package com.g04.o2o.dao.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Set;







import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.g04.o2o.dao.RestaurantDao;
import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.Restaurant;
@Repository
public class RestaurantDaoImpl extends AbstractDaoImpl<Restaurant> implements RestaurantDao {

	@Transactional
	@Override
	public Set<MenuItem> getMenuItemByType(Integer rid, Integer menuTypeId) {
		String hql="from MenuItem where type.id=:menutypeid and resturant.id=:rid";
		Query query=manager.createQuery(hql);
		query.setParameter("menutypeid", menuTypeId);
		query.setParameter("rid", rid);
		Set<MenuItem> set=new HashSet<>();
		List<MenuItem> list=query.getResultList();
		for(MenuItem item:list){
			set.add(item);
		}
		return set;
	}
	
}
