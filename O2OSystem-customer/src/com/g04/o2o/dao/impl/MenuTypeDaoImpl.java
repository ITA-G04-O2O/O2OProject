package com.g04.o2o.dao.impl;


import java.util.Set;

import org.springframework.stereotype.Repository;

import com.g04.o2o.dao.MenuTypeDao;
import com.g04.o2o.entity.MenuType;
import com.g04.o2o.entity.Restaurant;

@Repository
public class MenuTypeDaoImpl extends AbstractDaoImpl<MenuType> implements MenuTypeDao{

	@Override
	public Set<Restaurant> getRestByType(Integer id) {
		MenuType type=manager.find(MenuType.class, id);
		return type.getHasRestaurants();
	}
	
	
}
