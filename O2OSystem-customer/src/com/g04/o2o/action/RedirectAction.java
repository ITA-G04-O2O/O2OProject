package com.g04.o2o.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vo.MenuItemVo;

import com.g04.o2o.entity.JsonProtocol;

@Controller
public class RedirectAction {
	@RequestMapping("/load/order")
	public String send2orderPage(@RequestParam("oid") String uid) {
		return "redirect:html/order.html?oid=" + uid;
	}

	// save order to session
	@RequestMapping(value = "/order/save", method = RequestMethod.POST)
	public void saveOrder(@RequestParam("order")List<MenuItemVo>userorder,HttpSession session) {
		session.setAttribute("userOrder", userorder);
	}

	//get order from session.
	@RequestMapping("/order/get")
	public JsonProtocol getSaveOrder(HttpSession session) {
		@SuppressWarnings("unchecked")
		List<MenuItemVo> order=(List<MenuItemVo>) session.getAttribute("userOrder");
		JsonProtocol js=new JsonProtocol();
		js.setObject(order);
		return js;
	}

	@RequestMapping("/rest/{id}")
	public void saveRestId(@PathVariable Integer id, HttpSession session) {
		session.setAttribute("restId", id);
	}
}
