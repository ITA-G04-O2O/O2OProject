package com.g04.o2o.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.MenuItemVo;
import vo.OrderVo;

import com.g04.o2o.entity.JsonProtocol;

@Controller
public class RedirectAction {
	@RequestMapping("/load/order")
	public String send2orderPage(@RequestParam("oid") String uid) {
		return "redirect:html/order.html?oid=" + uid;
	}

	@ResponseBody
	// save order to session
	@RequestMapping(value = "/order/save", method = RequestMethod.POST)
	public JsonProtocol saveOrder(@RequestBody String myorder,HttpSession session) {
		System.out.println("save order to session"+myorder);
		session.setAttribute("userOrder", myorder);
		JsonProtocol jsonProtocol=new JsonProtocol();
		jsonProtocol.setResult(true);
		return jsonProtocol;
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

	@RequestMapping(value="rest/{id}")
	public String saveRestId(@PathVariable Integer id, HttpSession session) {
		session.setAttribute("restId", id);
		System.out.println(id);
		return "restaurant";
	}
	
<<<<<<< HEAD
=======
	@RequestMapping("/rest/go")
	public String goConfirm(){
		return "confirm";
	}
>>>>>>> 22ab5b8465c979087932a62f52c7908683643e62
}
