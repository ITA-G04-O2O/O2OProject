package com.g04.o2o.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.service.MenuService;

/**
 * Menu handler function
 * @author OUOK
 *
 */
@RestController
public class MenuAction {
	@Autowired
	private MenuService ms;
	
	/**
	 * get all orders
	 * @return
	 */
	@RequestMapping(value = "/menuTypes", method = RequestMethod.GET)
	public JsonProtocol getOrders() {
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(ms.findAllMenuTypes());
		return jp;
	}
	
	/**
	 * get one order by id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/menuTypes/{id}", method = RequestMethod.GET)
	public JsonProtocol getOrderById(@PathVariable Integer id) {
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(ms.findMenuTypeById(id));
		return jp;
	}
	
	/**
	 * add menu type with a string.
	 * @param menuType
	 * @return
	 */
	@RequestMapping(value = "/menuTypes", method = RequestMethod.POST)
	public JsonProtocol addMenuType(String menuType) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.addMenuType(menuType));
		return jp;
	}
	
	/**
	 * delete menu type with id.
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/menuTypes/{id}", method = RequestMethod.DELETE)
	public JsonProtocol delMenuType(@PathVariable Integer id) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.delMenuType(id));
		return jp;
	}
	
	/**
	 * update menu type with id & string.
	 * @param id
	 * @param menuType
	 * @return
	 */
	@RequestMapping(value = "/menuTypes/{id}", method = RequestMethod.PUT)
	public JsonProtocol updMenuType(@PathVariable Integer id, String menuType) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.updMenuType(id, menuType));
		return jp;
	}
	
	/**
	 * get all menu items.
	 * @return
	 */
	@RequestMapping(value = "/menuItems", method = RequestMethod.GET)
	public JsonProtocol getMenuItems() {
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(ms.findAllMenuItems());
		return jp;
	}
	
	/**
	 * get menu item by id.
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{id}", method = RequestMethod.GET)
	public JsonProtocol getMenuItemById(@PathVariable Integer id) {
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(ms.getMenuItemById(id));
		return jp;
	}
	/**
	 * add menu item with a MenuItem entity
	 * @param menuItem
	 * @return
	 */
	@RequestMapping(value = "/menuItems", method = RequestMethod.POST)
	public JsonProtocol addMenuItem(MenuItem menuItem) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.addMenuItem(menuItem));
		return jp;
	}
	
	/**
	 * delete menuItem with id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{id}", method = RequestMethod.DELETE)
	public JsonProtocol delMenuItem(@PathVariable Integer id) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.delMenuItem(id));
		return jp;
	}
	
	/**
	 * update MenuItem's name with id&itemName
	 * @param id
	 * @param itemName
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{id}", method = RequestMethod.PUT)
	public JsonProtocol updMenuItemName(@PathVariable Integer id, String itemName) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.updMenuItemName(id, itemName));
		return jp;
	}
	
	/**
	 * update MenuItem's price with id&price
	 * @param id
	 * @param price
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{id}", method = RequestMethod.PUT)
	public JsonProtocol updMenuItemPrice(@PathVariable Integer id, Double price) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.updMenuItemPrice(id, price));
		return jp;
	}
	
	/**
	 * update MenuItem's description with id&description
	 * @param id
	 * @param description
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{id}", method = RequestMethod.PUT)
	public JsonProtocol updMenuItemDescription(@PathVariable Integer id, String description) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.updMenuItemDescription(id, description));
		return jp;
	}
	
	/**
	 * update MenuItem's type with id&type
	 * @param id
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{id}", method = RequestMethod.PUT)
	public JsonProtocol updMenuItemType(@PathVariable Integer id, String type) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.updMenuItemDescription(id, type));
		return jp;
	}
	
	/**
	 * update MenuItem's volume with id&volume
	 * @param id
	 * @param volume
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{id}", method = RequestMethod.PUT)
	public JsonProtocol updMenuItemSalesVolume(@PathVariable Integer id, Integer volume) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.updMenuItemSalesVolume(id, volume));
		return jp;
	}
	
	/**
	 * update MenuItem's score with id&score
	 * @param id
	 * @param score
	 * @return
	 */
	@RequestMapping(value = "/menuItems/{id}", method = RequestMethod.PUT)
	public JsonProtocol updMenuItemScore(@PathVariable Integer id, Double score) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(ms.updMenuItemScore(id, score));
		return jp;
	}
}
