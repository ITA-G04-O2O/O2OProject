package com.g04.o2o.dao;

import java.util.Set;

import com.g04.o2o.entity.MenuType;
import com.g04.o2o.entity.Restaurant;

public interface MenuTypeDao extends AbstractDao<MenuType>{
	Set<Restaurant> getRestByType(Integer id);
}
