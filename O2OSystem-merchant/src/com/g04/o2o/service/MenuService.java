package com.g04.o2o.service;

import java.util.List;

public interface MenuService {
	//menuType
	
	/**
	 * 获取所有菜单种类
	 * @return
	 */
	List<String> findAllMenuType();
	boolean addMenuType(String menuType);
	boolean delMenuType(String menuType);
	boolean updMenuType(Integer id, String menuType);
	
	//menuItems
	
}
