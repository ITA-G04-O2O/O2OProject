package com.g04.o2o.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeAction {
	@RequestMapping(value={"/","/index","/home"})
	public String index(){
		System.out.println("进入首页");
		return "manage";
	}
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
}
