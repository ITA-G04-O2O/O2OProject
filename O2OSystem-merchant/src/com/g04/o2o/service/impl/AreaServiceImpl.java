package com.g04.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g04.o2o.dao.AreaDao;
import com.g04.o2o.entity.Area;
import com.g04.o2o.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao dao;

	@Override
	public List<String> getProvince() {
		return dao.getProvince();
	}

	@Override
	public List<String> getCities(String province) {
		return dao.getCities(province);
	}

	@Override
	public Area getAreaByCity(String city) {
		int id = dao.getAreaId(city);
		return dao.search(Area.class, id);
	}

}
