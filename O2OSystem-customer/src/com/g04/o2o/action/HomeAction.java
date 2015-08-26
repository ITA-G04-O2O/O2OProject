package com.g04.o2o.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.service.UserService;

@Controller
public class HomeAction {
	@Autowired
	private UserService service;
	@RequestMapping(value={"/","/index","/home"})
	public String index(){
		System.out.println("进入首页");
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public JsonProtocol login(@RequestParam("uname")String loginName,@RequestParam("psd")String psd){
		System.out.println("验证登陆");
		int rs=service.login(loginName, psd);
		JsonProtocol rsJson = new JsonProtocol();
		if(rs>=1){
			rsJson.setResult(true);
		}else {
			rsJson.setResult(false);
		}
		return rsJson;
	}
}
