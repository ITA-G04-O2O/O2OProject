package com.g04.o2o.service;

import java.util.List;

import com.g04.o2o.entity.MenuItem;

/**
 * MenuService
 * @author OUOK
 *
 */
public interface MenuService {
	//menuType
	
	/**
	 * 获取所有菜单种类
	 * @return
	 */
	List<String> findAllMenuTypes();
	/**
	 * 获取某一个菜品种类
	 * @return
	 */
	String findMenuType();
	/**
	 * 添加菜品种类
	 * @param menuType
	 * @return
	 */
	boolean addMenuType(String menuType);
	/**
	 * 删除菜品种类
	 * @param menuType
	 * @return
	 */
	boolean delMenuType(String menuType);
	/**
	 * 更新菜品种类
	 * @param menuType
	 * @return
	 */
	boolean updMenuType(Integer id, String menuType);
	
	//menuItems
	
	/**
	 * 获取菜单所有信息;
	 * @return
	 */
	List<MenuItem> findAllMenuItems();
	/**
	 * 获取某个菜品信息
	 * @param id
	 * @return
	 */
	MenuItem getMenuItemById(Integer id);
	/**
	 * 添加新的菜品
	 * @param menuItem
	 * @return
	 */
	boolean addMenuItem(MenuItem menuItem);
	/**
	 * 删除新的菜品
	 * @param menuItem
	 * @return
	 */
	boolean delMenuItem(Integer id);
	/**
	 * 更新菜品名字
	 * @param id
	 * @param itemName
	 * @return
	 */
	boolean updMenuItemName(Integer id, String itemName);
	/**
	 * 更新菜品价格
	 * @param id
	 * @param itemName
	 * @return
	 */
	boolean updMenuItemPrice(Integer id, Double price);
	/**
	 * 更新菜品描述
	 * @param id
	 * @param itemName
	 * @return
	 */
	boolean updMenuItemDescription(Integer id,String description);
	/**
	 * 更新菜品种类
	 * @param id
	 * @param itemName
	 * @return
	 */
	boolean updMenuItemType(Integer id, String type);
	/**
	 * 更新菜品销量
	 * @param id
	 * @param itemName
	 * @return
	 */
	boolean updMenuItemSalesVolume(Integer id, Integer volume);
	/**
	 * 更新菜品评分
	 * @param id
	 * @param itemName
	 * @return
	 */
	boolean updMenuItemScore(Integer id, Double score);
}
