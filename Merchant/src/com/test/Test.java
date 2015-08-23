package com.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.g04.o2o.entity.Merchant;

public class Test {
	

	public static void main(String[] args) {
		new Test().test();
	}

	public void test() {
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(
				"file:WebContent/WEB-INF/springmvc-servlet.xml");
		EntityManagerFactory factory = context.getBean("entityManagerFactory",EntityManagerFactory.class);
		 EntityManager manager=factory.createEntityManager();
		Merchant merchant = new Merchant();
		merchant.setLoginName("test");
		merchant.setPassword("test");
		
		EntityTransaction etx = manager.getTransaction();
		etx.begin();
//		Merchant merchant=manager.find(Merchant.class, 1);
//		System.out.println(merchant.getLoginName());
		manager.persist(merchant);
		etx.commit();
	}
}
