package com.g04.o2o.action;

import java.io.IOException;
import java.io.OutputStream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g04.o2o.dao.MenuItemDao;
import com.g04.o2o.dao.MerchantDao;
import com.g04.o2o.dao.RestaurantDao;
import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.Merchant;
import com.g04.o2o.entity.Restaurant;

@Controller
@RequestMapping("/img")
public class ImageAction {
	@Autowired
	private MenuItemDao MIDao;
	@Autowired
	private MerchantDao mCDao;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Transactional
	@ResponseBody
	@RequestMapping("/menuItem/{id}")
	public void getMenuItemImage(@PathVariable("id")Integer id,OutputStream out){
		System.out.println("get image");
		MenuItem item=MIDao.search(MenuItem.class, id);
		try {
			out.write(item.getImage());
//			out.write("hello".getBytes());
		} catch (IOException e) {
			System.err.println("can not get image");
		}
	}
	
	@Transactional
	@ResponseBody
	@RequestMapping("/merchant/IDCard/{id}")
	public void getMerchantIDImage(@PathVariable("id")Integer id,OutputStream out){
		Merchant merchant=mCDao.search(Merchant.class, id);
		try {
			out.write(merchant.getIDimage());
//			out.write("hello".getBytes());
		} catch (IOException e) {
			System.err.println("can not get image");
		}
	}
	
	
	@Transactional
	@ResponseBody
	@RequestMapping("/merchant/license/{id}")
	public void getMerchantLicenseImage(@PathVariable("id")Integer id,OutputStream out){
		Merchant merchant=mCDao.search(Merchant.class, id);
		try {
			out.write(merchant.getLicenseImage());
//			out.write("hello".getBytes());
		} catch (IOException e) {
			System.err.println("can not get image");
		}
	}
	
	
	@Transactional
	@ResponseBody
	@RequestMapping("/rest/icon/{id}")
	public void getRestIconImage(@PathVariable("id")Integer id,OutputStream out){
		Restaurant restaurant=restaurantDao.search(Restaurant.class, id);
		try {
			out.write(restaurant.getImageBytes());
//			out.write("hello".getBytes());
		} catch (IOException e) {
			System.err.println("can not get image");
		}
	}
}
