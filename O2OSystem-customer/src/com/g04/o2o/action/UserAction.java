package com.g04.o2o.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.service.UserService;

@RestController
public class UserAction {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users/regist",method=RequestMethod.POST)
	public JsonProtocol regist(String loginName, String psd){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(userService.regist(loginName, psd));
		return jp;
	}
	
//	@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
//	public JsonProtocol login(String loginName, String psd){
//		JsonProtocol jp = new JsonProtocol();
//		jp.setObject(userService.login(loginName, psd));
//		return jp;
//	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
	public JsonProtocol getUserInfo(@PathVariable(value="id") Integer uid){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(userService.getUserInfo(uid));
		return jp;
	}
	
	@RequestMapping(value="/users/{id}/userOrder",method=RequestMethod.GET)
	public JsonProtocol getUserOrder(@PathVariable(value="id") Integer uid){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(userService.getUserOrder(uid));
		return jp;
	}
	
	@RequestMapping(value="/users/{id}/userRestlikes",method=RequestMethod.GET)
	public JsonProtocol getUserRestlikes(@PathVariable(value="id") Integer uid){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(userService.getUserRestlikes(uid));
		return jp;
	}
	
	@RequestMapping(value="/users/addRestLikes",method=RequestMethod.POST)
	public JsonProtocol addRestlikes(Integer uid, Integer id){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(userService.addRestlikes(uid, id));
		return jp;
	}
	
	@RequestMapping(value="/users/{uid}/{id}",method=RequestMethod.DELETE)
	public JsonProtocol delRestlikes(@PathVariable(value="uid") Integer uid, @PathVariable(value="id") Integer id){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(userService.delRestlikes(uid, id));
		return jp;
	}
	
}
