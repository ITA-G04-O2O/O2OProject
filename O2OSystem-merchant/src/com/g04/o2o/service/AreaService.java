package com.g04.o2o.service;

import java.util.List;

import com.g04.o2o.entity.Area;

public interface AreaService {

	public List<String> getProvince();

	public List<String> getCities(String province);

	public Area getAreaByCity(String city);
}
