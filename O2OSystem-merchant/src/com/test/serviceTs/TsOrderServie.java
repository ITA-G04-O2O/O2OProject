package com.test.serviceTs;





import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.g04.o2o.dao.AreaDao;
import com.g04.o2o.dao.RestaurantDao;
import com.g04.o2o.dao.impl.RestaurantDaoImpl;
import com.g04.o2o.entity.Address;
import com.g04.o2o.entity.Order;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.User;
import com.g04.o2o.service.OrderService;
import com.g04.o2o.service.impl.OrderServiceImpl;


public class TsOrderServie {
	
	private static FileSystemXmlApplicationContext context;
	
	private static OrderService service;
	private static AreaDao areaDao;
	private static OrderService orderService;
	private static RestaurantDao restdao;
	
	
	@BeforeClass
	public  static void init(){
		context = new FileSystemXmlApplicationContext("file:WebContent/WEB-INF/springmvc-servlet.xml");
		service=context.getBean(OrderServiceImpl.class);
		areaDao= context.getBean(AreaDao.class);
		orderService = context.getBean(OrderServiceImpl.class);
		restdao=context.getBean(RestaurantDaoImpl.class);
		
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
		
	}
	
	@Test
	
	public void tsGetUpdate(){
//		service.updateMessage(1, "hello world");
//		service.updateScore(1, 2);
		
		
	}
	@Test
	public void tss() throws Exception{
		
		Assert.assertNotNull(restdao.findRestById(10));
	}
	
	
}
