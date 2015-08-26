package com.g04.o2o.service;

import java.util.List;

public interface AreaService {

	public List<String> getProvince();

	public List<String> getCities(String province);
}
