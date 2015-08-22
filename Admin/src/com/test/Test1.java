package com.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.po.Addr;
import com.po.User;
import com.service.UserManager;

public class Test1 {
	private static EntityManagerFactory factory;
	private EntityManager manager;
	@BeforeClass
	public static  void init(){
		factory = Persistence
				.createEntityManagerFactory("qs");
		
	}
	@Before
	public void start(){
		manager = factory.createEntityManager();
		
	}

	
	@Test
	public void testPersist() throws Exception{
		
		User u = new User();
		u.setUname("john");
		u.setSex(true);
		u.getTels().add("abc");
		Addr addr1 = new Addr();
		Addr addr2 = new Addr();
		addr1.setCity("bj");
		addr2.setCity("zh");
		addr1.setU(u);
		addr2.setU(u);
		
		manager.getTransaction().begin();
		manager.persist(addr1);
		
		manager.getTransaction().commit();
		System.out.println(u.getId());
	}
	
	@Test
	public void testFind() throws Exception{
		
		//User u=manager.find(User.class, primaryKey)
	}

	public static void main(String[] args) {
		ApplicationContext context=new FileSystemXmlApplicationContext("WebContent/WEB-INF/springmvc-servlet.xml");
		//LocalContainerEntityManagerFactoryBean bean=(LocalContainerEntityManagerFactoryBean)context.getBean("entityManagerFactory");
		/*User u=new User();
		u.setSex(true);
		u.setUname("john");
		
//		UserDao ud=(UserDao)context.getBean("userDaoImpl");
//		ud.addUser(u);
		UserManager um=(UserManager)context.getBean("um");
		um.regist(u);*/
	}
}
