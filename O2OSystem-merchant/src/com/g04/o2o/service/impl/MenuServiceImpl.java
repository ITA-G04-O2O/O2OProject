package com.g04.o2o.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.g04.o2o.dao.MenuItemDao;
import com.g04.o2o.dao.MenuTypeDao;
import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.MenuType;
import com.g04.o2o.entity.Order;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.service.MenuService;

/**
 * MenuService實現類
 * @author OUOK
 *
 */
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuTypeDao mtd;
	@Autowired
	private MenuItemDao mid;

	@Override
	public List<String> findAllMenuTypes() {
		List<MenuType> mtl = mtd.searchAll(MenuType.class);
		List<String> types = new ArrayList<String>();
		for (MenuType menuType : mtl) {
			types.add(menuType.getMenuTypeName());
		}
		return types;
	}

	@Override
	@Transient
	public boolean addMenuType(String menuType) {
		MenuType mt = new MenuType();
		mt.setMenuTypeName(menuType);
		try {
			mtd.add(mt);
		} catch (Exception e) {
			return false;
		}
		return true;
	}


	@Override
	@Transient
	public boolean updMenuType(Integer id, String menuType) {
		try {
			mtd.search(MenuType.class, id).setMenuTypeName(menuType);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<MenuItem> findAllMenuItems() {
		return mid.searchAll(MenuItem.class);
	}

	@Override
	public MenuItem getMenuItemById(Integer id) {
		return mid.search(MenuItem.class, id);
	}

	@Override
	@Transient
	public boolean addMenuItem(MenuItem menuItem) {
		try {
			mid.add(menuItem);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transient
	public boolean delMenuItem(Integer id) {
		try {
			mid.del(MenuItem.class, id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transient
	public boolean updMenuItemName(Integer id, String itemName) {
		try {
			mid.search(MenuItem.class, id).setItemName(itemName);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transient
	public boolean updMenuItemPrice(Integer id, Double price) {
		try {
			mid.search(MenuItem.class, id).setPrice(price);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transient
	public boolean updMenuItemDescription(Integer id, String description) {
		try {
			mid.search(MenuItem.class, id).setDescription(description);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transient
	public boolean updMenuItemType(Integer id, String type) {
		for (MenuType menuType : mtd.searchAll(MenuType.class)) {
			if (type.equals(menuType.getMenuTypeName())) {
				mid.search(MenuItem.class, id).setType(menuType);
				return true;
			}
		}
		return false;
	}

	@Override
	@Transient
	public boolean updMenuItemSalesVolume(Integer id, Integer volume) {
		try {
			mid.search(MenuItem.class, id).setSalesVolume(volume);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transient
	public boolean updMenuItemScore(Integer id, Double score) {
		try {
			mid.search(MenuItem.class, id).setScore(score);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public String findMenuTypeById(Integer id) {
		return mtd.search(MenuType.class, id).getMenuTypeName();
	}

	@Override
	@Transient
	public boolean delMenuType(Integer id) {
		if (mid.searchAll(MenuItem.class).size() == 0) {
			mtd.del(MenuType.class, id);
			return true;
		}
		return false;
	}

}
