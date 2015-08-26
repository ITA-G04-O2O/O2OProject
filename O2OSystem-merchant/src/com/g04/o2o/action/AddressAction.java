package com.g04.o2o.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.Address;
import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.service.AddressService;

@RestController
public class AddressAction {
	@Autowired
	private AddressService addrService;

	public void setAddrService(AddressService addrService) {
		this.addrService = addrService;
	}

	@RequestMapping(value = "/address", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public JsonProtocol location() {
		System.out.println("AddressAction");
		JsonProtocol js = new JsonProtocol();
		List<Address> addrList = addrService.getAllAddress();
		js.setObject(addrList);
		return js;
	}
}
