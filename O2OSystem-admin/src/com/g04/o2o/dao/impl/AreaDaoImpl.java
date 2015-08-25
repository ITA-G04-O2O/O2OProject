package com.g04.o2o.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.g04.o2o.dao.AreaDao;
import com.g04.o2o.entity.Area;

@Transactional
@Repository
public class AreaDaoImpl extends AbstractDaoImpl<Area> implements AreaDao{


	public List<String> getProvince(){
		String hql="select distinct province from Area";
		Query query=manager.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<String> provinces=query.getResultList();
		return provinces;
	}

	
	public List<String> getCities(String province){
		String hql="select city from Area where province=:province";
		Query query=manager.createQuery(hql);
		query.setParameter("province", province);
		@SuppressWarnings("unchecked")
		List<String> rs=query.getResultList();
		return rs;
	}
	
}
