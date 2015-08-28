package com.g04.o2o.service;

import java.util.List;

import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.MenuType;

/**
 * MenuService
 * 
 * @author OUOK
 * 
 */
public interface MenuService {
	// menuType

	/**
	 * 获取所有菜单种类
	 * 
	 * @return
	 */
	public List<String> findAllMenuTypes(Integer restID);

	public List<MenuType> findAllMenuTypeList(Integer restID);

	/**
	 * 获取某一个菜品种类
	 * 
	 * @return
	 */
	public String findMenuTypeById(Integer id);

	/**
	 * 添加菜品种类
	 * 
	 * @param menuType
	 * @return
	 */
	public boolean addMenuType(Integer restId, String menuType);

	/**
	 * 删除菜品种类
	 * 
	 * @param menuType
	 * @return
	 */
	public boolean delMenuType(Integer restID, Integer menuTypeId);

	/**
	 * 更新菜品种类
	 * 
	 * @param menuType
	 * @return
	 */
	public boolean updMenuType(Integer restId, Integer menuTypeId,
			String menuType);

	// menuItems

	/**
	 * 获取菜单所有信息;
	 * 
	 * @return
	 */
	public List<MenuItem> findAllMenuItems(Integer restId);

	/**
	 * 获取某个菜品信息
	 * 
	 * @param id
	 * @return
	 */
	public MenuItem getMenuItemById(Integer id);

	/**
	 * 找对应菜品种类的所有菜品
	 * 
	 * @param menuTypeString
	 * @return
	 */
	public List<MenuItem> findMenuItemsByMenuType(Integer menuTypeId);

	/**
	 * 添加新的菜品
	 * 
	 * @param menuItem
	 * @return
	 */
	public boolean addMenuItem(Integer restId, MenuItem menuItem);

	/**
	 * 删除新的菜品
	 * 
	 * @param menuItem
	 * @return
	 */
	public boolean delMenuItem(Integer id);

	/**
	 * 更新菜品名字
	 * 
	 * @param id
	 * @param itemName
	 * @return
	 */
	public boolean updMenuItemName(Integer id, String itemName);

	/**
	 * 更新菜品价格
	 * 
	 * @param id
	 * @param itemName
	 * @return
	 */
	public boolean updMenuItemPrice(Integer id, Double price);

	/**
	 * 更新菜品描述
	 * 
	 * @param id
	 * @param itemName
	 * @return
	 */
	public boolean updMenuItemDescription(Integer id, String description);

	/**
	 * 更新菜品种类
	 * 
	 * @param id
	 * @param itemName
	 * @return
	 */
	public boolean updMenuItemType(Integer id, String type);

	/**
	 * 更新菜品销量
	 * 
	 * @param id
	 * @param itemName
	 * @return
	 */
	public boolean updMenuItemSalesVolume(Integer id, Integer volume);

	/**
	 * 更新菜品评分
	 * 
	 * @param id
	 * @param itemName
	 * @return
	 */
	public boolean updMenuItemScore(Integer id, Double score);
}
