package com.g04.o2o.action;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.MenuType;
import com.g04.o2o.service.MenuService;
import com.g04.o2o.vo.MenuItemVo;
import com.g04.o2o.vo.MenuTypeVo;

/**
 * Menu handler function
 * 
 * @author OUOK
 * 
 */
@RestController
public class MenuAction {
	@Autowired
	private MenuService ms;

	public void setMs(MenuService ms) {
		this.ms = ms;
	}

	/**
	 * get all orders
	 * 
	 * @return
	 */
	@RequestMapping(value = "/menuTypes/{restId}", method = RequestMethod.GET)
	@Transient
	public JsonProtocol getMenuTypes(@PathVariable Integer restId) {
		JsonProtocol jp = new JsonProtocol();
		List<MenuTypeVo> lists = new ArrayList<>();
		List<MenuType> mentList = ms.findAllMenuTypeList(restId);
		if (mentList != null)
			for (MenuType menuType : mentList) {
				MenuTypeVo mVo = new MenuTypeVo();
				mVo.setId(menuType.getId());
				mVo.setMenuTypeName(menuType.getMenuTypeName());
				mVo.setRestId(menuType.getRest().getId());
				lists.add(mVo);
			}
		jp.setObject(lists);
		return jp;
	}

	// /**
	// * get one order by id
	// *
	// * @param id
	// * @return
	// */
	// @RequestMapping(value = "/menuTypes/{id}", method = RequestMethod.GET)
	// public JsonProtocol getMenuTypeById(@PathVariable Integer id) {
	// JsonProtocol jp = new JsonProtocol();
	// jp.setObject(ms.findMenuTypeById(id));
	// return jp;
	// }

	/**
	 * add menu type with a string.
	 * 
	 * @param menuType
	 * @return
	 */
	@RequestMapping(value = "/menuTypes/{restId}", method = RequestMethod.POST)
	@Transient
	public JsonProtocol addMenuType(@PathVariable Integer restId,
			String menuType) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.addMenuType(restId, menuType));
		return jp;
	}

	/**
	 * delete menu type with id.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/restaurant/{restId}/menuTypes/{menuTypeId}", method = RequestMethod.DELETE)
	@Transient
	public JsonProtocol delMenuType(@PathVariable Integer restId,
			@PathVariable Integer menuTypeId) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.delMenuType(restId, menuTypeId));
		return jp;
	}

	/**
	 * update menu type with id & string.
	 * 
	 * @param id
	 * @param menuType
	 * @return
	 */
	@RequestMapping(value = "/restaurant/{restId}/menuTypes/{menuTypeId}", method = RequestMethod.PUT)
	@Transient
	public JsonProtocol updMenuType(@PathVariable Integer restId,
			@PathVariable Integer menuTypeId, String menuType) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.updMenuType(restId, menuTypeId, menuType));
		return jp;
	}

	/**
	 * get all menu items.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{menuTypeId}", method = RequestMethod.GET)
	@Transient
	public JsonProtocol getMenuItems(@PathVariable Integer menuTypeId) {
		JsonProtocol jp = new JsonProtocol();
		List<MenuItem> list = ms.findAllMenuItems(menuTypeId);
		List<MenuItemVo> lists = new ArrayList<>();
		for (MenuItem menuItem : list) {
			MenuItemVo vo = new MenuItemVo();
			vo.setId(menuItem.getId());
			vo.setItemName(menuItem.getItemName());
			vo.setTypeId(menuItem.getType().getId());
			vo.setResturantId(menuItem.getResturant().getId());
			lists.add(vo);
		}
		jp.setObject(lists);
		return jp;
	}

	/**
	 * get menu item by id.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{id}/menuItemId", method = RequestMethod.GET)
	@Transient
	public JsonProtocol getMenuItemById(@PathVariable Integer id) {
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(ms.getMenuItemById(id));
		return jp;
	}

	/**
	 * get menu items by MenuTypeId
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{menuTypeId}/menuType", method = RequestMethod.GET)
	@Transient
	public JsonProtocol getMenuItemsByMenuTypeId(
			@PathVariable Integer menuTypeId) {
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(ms.findMenuItemsByMenuType(menuTypeId));
		return jp;
	}

	/**
	 * add menu item with a MenuItem entity
	 * 
	 * @param menuItem
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{restId}", method = RequestMethod.POST)
	@Transient
	public JsonProtocol addMenuItem(@PathVariable Integer restId,
			MenuItem menuItem) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.addMenuItem(restId, menuItem));
		return jp;
	}

	/**
	 * delete menuItem with id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{menuItemsId}", method = RequestMethod.DELETE)
	@Transient
	public JsonProtocol delMenuItem(@PathVariable Integer menuItemsId) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.delMenuItem(menuItemsId));
		return jp;
	}

	/**
	 * update MenuItem's name with id&itemName
	 * 
	 * @param id
	 * @param itemName
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{menuTypeId}", method = RequestMethod.PUT)
	@Transient
	public JsonProtocol updMenuItemName(@PathVariable Integer menuTypeId,
			String itemName) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.updMenuItemName(menuTypeId, itemName));
		return jp;
	}

	/**
	 * update MenuItem's price with id&price
	 * 
	 * @param id
	 * @param price
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{id}/price", method = RequestMethod.PUT)
	@Transient
	public JsonProtocol updMenuItemPrice(@PathVariable Integer id, Double price) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.updMenuItemPrice(id, price));
		return jp;
	}

	/**
	 * update MenuItem's description with id&description
	 * 
	 * @param id
	 * @param description
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{id}/descr", method = RequestMethod.PUT)
	@Transient
	public JsonProtocol updMenuItemDescription(@PathVariable Integer id,
			String description) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.updMenuItemDescription(id, description));
		return jp;
	}

	/**
	 * update MenuItem's type with id&type
	 * 
	 * @param id
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{id}/type", method = RequestMethod.PUT)
	@Transient
	public JsonProtocol updMenuItemType(@PathVariable Integer id, String type) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.updMenuItemDescription(id, type));
		return jp;
	}

	/**
	 * update MenuItem's volume with id&volume
	 * 
	 * @param id
	 * @param volume
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{id}/volume", method = RequestMethod.PUT)
	@Transient
	public JsonProtocol updMenuItemSalesVolume(@PathVariable Integer id,
			Integer volume) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.updMenuItemSalesVolume(id, volume));
		return jp;
	}

	/**
	 * update MenuItem's score with id&score
	 * 
	 * @param id
	 * @param score
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{id}/score", method = RequestMethod.PUT)
	@Transient
	public JsonProtocol updMenuItemScore(@PathVariable Integer id, Double score) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.updMenuItemScore(id, score));
		return jp;
	}
}
