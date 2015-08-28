package com.g04.o2o.action;




import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	@RequestMapping("/order/get")
	public JsonProtocol getSaveOrder(HttpSession session) {
		String order=(String) session.getAttribute("userOrder");
		JsonProtocol js=new JsonProtocol();
		js.setObject(order);
		return js;
	}

	@RequestMapping("/rest/{id}")
	public void saveRestId(@PathVariable Integer id, HttpSession session) {
		session.setAttribute("restId", id);
	}
	
	@RequestMapping("/rest/go")
	public String goConfirm(){
		return "confirm";
	}
}
