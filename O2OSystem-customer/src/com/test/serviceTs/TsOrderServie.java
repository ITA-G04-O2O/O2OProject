package com.test.serviceTs;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.g04.o2o.dao.impl.Tes;
import com.g04.o2o.entity.Address;
import com.g04.o2o.entity.Order;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.User;
import com.g04.o2o.service.OrderService;
import com.g04.o2o.service.RestaurantService;
import com.g04.o2o.service.impl.OrderServiceImpl;
import com.g04.o2o.service.impl.RestaurantServiceImpl;

public class TsOrderServie {
	
	private static FileSystemXmlApplicationContext context;
	
	private static OrderService service;
	private static  Tes service2;
	
	@BeforeClass
	public  static void init(){
		context = new FileSystemXmlApplicationContext("file:WebContent/WEB-INF/springmvc-servlet.xml");
		service=context.getBean(OrderServiceImpl.class);
		service2=context.getBean(Tes.class);
	}
	
	@Test
	public void tsOrderAd(){
		Order o=new Order();
		o.setMessage("test");
		Address address = new Address();
		address.setId(32768);
		o.setAddress(address);
		Restaurant rs = new Restaurant();
		rs.setId(1);
		o.setResturant(rs);
		User user=new User();
		user.setId(32768);
		o.setUser(user);
		service.addOrder(o);
	}
	
	@Test
	public void tsGetUpdate(){
//		service.updateMessage(1, "hello world");
//		service.updateScore(1, 2);
		
		
	}
	@Test
	public void tss(){
		service2.tes();
	}
}
