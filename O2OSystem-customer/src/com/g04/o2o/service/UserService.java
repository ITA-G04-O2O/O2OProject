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
public interface UserService {

	User getUserInfo(Integer uid);
	
	List<Order> getUserOrder(Integer uid);
	
	Set<Restaurant> getUserRestlikes(Integer uid);
	
	int addRestlikes(Integer uid, Integer id);
	
	int delRestlikes(Integer uid, Integer id);
}
