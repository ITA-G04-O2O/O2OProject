package com.g04.o2o.dao;

import java.util.Set;

import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.RestaurantType;


public interface RestaurantTypeDao extends AbstractDao<RestaurantType>{

	Set<Restaurant> getRestByTpe(String type);

}
