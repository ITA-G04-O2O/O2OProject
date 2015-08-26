package com.g04.o2o.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.service.AreaService;

@RestController
public class AreaAction {
	@Autowired
	private AreaService service;

	public void setService(AreaService service) {
		this.service = service;
	}

	@RequestMapping(value = "/area", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public List<String> location() {
		System.out.println("AreaAction");
		List<String> proList = service.getProvince();
		return proList;
	}
}
