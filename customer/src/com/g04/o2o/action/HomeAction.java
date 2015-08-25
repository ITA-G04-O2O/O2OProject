package com.g04.o2o.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeAction {
	@RequestMapping(value={"/","/index","/home"})
	public String index(){
		System.out.println("进入首页");
		return "index";
	}
	
	@RequestMapping(value="/login")
	public void login(){
		System.out.println("验证登陆");
	}
}
