package com.g04.o2o.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.g04.o2o.dao.MenuItemDao;
import com.g04.o2o.dao.MenuTypeDao;
import com.g04.o2o.dao.RestaurantDao;
import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.MenuType;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.service.MenuService;

/**
 * MenuService實現類
 * 
 * @author OUOK
 * 
 */
@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuTypeDao mtd;
	@Autowired
	private MenuItemDao mid;
	@Autowired
	private RestaurantDao rd;

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
	@Transactional
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
	public boolean updMenuType(Integer restId, Integer menuTypeId,
			String menuType) {
		if (mtd.search(MenuType.class, menuTypeId).getRest().getId() == restId) {
			try {
				mtd.del(MenuType.class, menuTypeId);
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	@Override
	public List<MenuItem> findAllMenuItems() {
		return mid.searchAll(MenuItem.class);
	}
	

	@Override
	public List<MenuItem> findMenuIeItemsByMenuType(String menuTypeString) {
		List<MenuItem> allItems = mid.searchAll(MenuItem.class);
		List<MenuItem> menuTypeItems = new ArrayList<MenuItem>();
		for (MenuItem menuItem : allItems) {
			if (menuTypeString.equals(menuItem.getType().getMenuTypeName())) {
				menuTypeItems.add(menuItem);
			}
		}
		return menuTypeItems;
	}

	@Override
	public MenuItem getMenuItemById(Integer id) {
		return mid.search(MenuItem.class, id);
	}

	@Override
	@Transactional
	public boolean addMenuItem(MenuItem menuItem) {
		try {
			mid.add(menuItem);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public boolean delMenuItem(Integer id) {
		try {
			mid.del(MenuItem.class, id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional

	public boolean updMenuItemName(Integer id, String itemName) {
		try {
			mid.search(MenuItem.class, id).setItemName(itemName);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional

	public boolean updMenuItemPrice(Integer id, Double price) {
		try {
			mid.search(MenuItem.class, id).setPrice(price);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional

	public boolean updMenuItemDescription(Integer id, String description) {
		try {
			mid.search(MenuItem.class, id).setDescription(description);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional

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
	@Transactional

	public boolean updMenuItemSalesVolume(Integer id, Integer volume) {
		try {
			mid.search(MenuItem.class, id).setSalesVolume(volume);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional

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
	@Transactional
	public boolean delMenuType(Integer restID, Integer id) {
		Restaurant rest = rd.search(Restaurant.class, restID);
		Set<MenuItem> misSet = rest.getMenus();
		List<MenuItem> typeList = new ArrayList<MenuItem>();
		for (MenuItem item : misSet) {
			if (item.getType().getId() == id) {
				typeList.add(item);
			}
		}
		if (typeList.size() == 0) {
			mtd.del(MenuType.class, id);
			return true;
		}
		return false;
	}

}
