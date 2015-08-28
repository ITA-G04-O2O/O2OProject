package com.g04.o2o.action;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.g04.o2o.entity.JsonProtocol;

@Controller
public class RedirectAction {
	@RequestMapping("/load/order")
	public String send2orderPage(@RequestParam("oid") String uid) {
		return "redirect:html/order.html?oid=" + uid;
	}

	// save order to session
	@RequestMapping(value = "/order/save", method = RequestMethod.POST)
	public void saveOrder() {

	}

	@RequestMapping("/order/save/get")
	public JsonProtocol getSaveOrder() {
		return new JsonProtocol();
	}

	@RequestMapping(value="rest/{id}")
	public String saveRestId(@PathVariable Integer id, HttpSession session) {
		session.setAttribute("restId", id);
		System.out.println(id);
		return "restaurant";
	}
	
}
