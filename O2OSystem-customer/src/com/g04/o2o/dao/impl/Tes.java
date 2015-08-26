package com.g04.o2o.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.g04.o2o.entity.Restaurant;

@Service
public class Tes {
	@PersistenceContext
	EntityManager mm;
	@Transactional
	public void tes(){
		Restaurant ooRestaurant=mm.find(Restaurant.class,1);
		System.out.println(ooRestaurant.getName());
	}
}
