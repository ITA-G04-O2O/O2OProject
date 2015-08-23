package com.g04.o2o.action;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantManagerAction {
	
	
	/**
	 * 根据用户名搜索餐厅
	 */
	public void getResturants(){
		// 返回商家的信息
		System.out.println("获取所有的普通餐厅信息");
	}
	
	public void getHotResturant(){
		System.out.println("获取热门餐厅...");
	}
	
	public void setBlack(){
		System.out.println("设置停业处理");
	}
	
	public void setHot(){
		System.out.println("设置热门餐厅");
	}
}
