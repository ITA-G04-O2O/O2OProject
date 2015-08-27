package com.g04.o2o.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedirectAction {
	@RequestMapping("/load/order")
	public String send2orderPage(@RequestParam("uid")String uid){
		return "redirect:html/order.html?uid="+uid;
	}
}
