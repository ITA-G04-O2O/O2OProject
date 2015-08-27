package com.g04.o2o.dao;


import java.util.Set;

import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.Restaurant;

public interface RestaurantDao extends AbstractDao<Restaurant>{
	Set<MenuItem> getMenuItemByType(Integer rid,Integer menuTypeId);
}
