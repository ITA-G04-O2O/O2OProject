package com.g04.o2o.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/setting")
public class SystemSettingAction {
	
	/**
	 * 获取系统信息  返回所有当前设置
	 * 包括订单自动完成时间，订单有效时间，客服电话，餐厅种类
	 */
	@RequestMapping(value="/currentSetting")
	public void getSystemSetting(){
		System.out.println("获取系统信息  返回所有当前设置");
	}
	
	@RequestMapping(value="/act")
	public void setAutoCompletedTime(){
		System.out.println("设置自动完成订单时间");
	}
	@RequestMapping(value="/aet")
	public void setAutoExpireTime(){
		System.out.println("设置订单过期时间");
	}
	
	@RequestMapping(value="/aReType")
	public void addRestaurantType(){
		System.out.println("增加餐厅的种类");
	}
	
	@RequestMapping(value="/dReType")
	public void delRestaurantType(){
		System.out.println("删除餐厅的种类");
	}
	
	@RequestMapping(value="/stel")
	public void setServiceTel(){
		System.out.println("设置客服电话");
	}
}
