package com.g04.o2o.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<String> getProvince() {
		System.out.println("getProvince");
		List<String> proList = service.getProvince();
		return proList;
	}

	@RequestMapping(value = "/city/{province}", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public List<String> getCity(
			@PathVariable(value = "province") String province) {
		System.out.println("getCity");
		System.out.println(province);
		List<String> proList = service.getCities(province);
		for (int i = 0; i < proList.size(); i++) {
			System.out.println(proList.get(i));
		}
		return proList;
	}
}
