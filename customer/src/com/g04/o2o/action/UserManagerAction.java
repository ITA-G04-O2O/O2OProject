package com.g04.o2o.action;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagerAction {
	
	public void getUserByTel(){
		System.out.println("通过电话搜索用户");
	}
	
	public void setPassword(){
		System.out.println("更新用户密码");
	}
}
