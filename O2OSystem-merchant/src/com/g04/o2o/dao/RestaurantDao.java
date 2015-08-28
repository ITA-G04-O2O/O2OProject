package com.g04.o2o.dao;


import com.g04.o2o.entity.Restaurant;

public interface RestaurantDao extends AbstractDao<Restaurant>{

	Restaurant findRestById(int id);
	
}
