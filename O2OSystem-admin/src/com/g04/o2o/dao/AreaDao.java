package com.g04.o2o.dao;

import java.util.List;

import com.g04.o2o.entity.Area;
/**
 *
 * 
 * @author DINGFR2
 *
 */
public interface AreaDao extends AbstractDao<Area>{
	List<String> getProvince();
	List<String> getCities(String province);
}
