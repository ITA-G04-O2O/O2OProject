package com.g04.o2o.vo.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.Order;
import com.g04.o2o.vo.GetOrderVO;

public class GetOrderVOHelper {
	public static GetOrderVO setOrder2VO(Order order){
		GetOrderVO goVo = new GetOrderVO();
		goVo.setId(order.getId());
		goVo.setCreateDate(order.getCrDate());
		goVo.setStatus(order.getStatus());
		goVo.setConnectPeople(order.getUser().getLoginName());
		goVo.setTel(order.getTel());
		goVo.setAddress(order.getAddress().getArea().getProvince()+order.getAddress().getArea().getCity()+order.getAddress().getDetail());
		goVo.setMenuItemAmountMap(GetOrderVOHelper.corventListToAmountMap(order.getItems()));
		goVo.setMenuItemPriceMap(GetOrderVOHelper.corventListToPriceMap(order.getItems()));
		goVo.setTotalPrices(GetOrderVOHelper.getTotalPirce(order.getItems()));
		if (!("".equals(order.getCompletedTime())||order.getCompletedTime() == null)) {
			goVo.setCompletedDate(order.getCompletedTime());
		}
		return goVo;
	}
	
	/**
	 * 獲取商品名字和數量
	 * @param mil
	 * @return
	 */
	public static Map<String, Integer> corventListToAmountMap(List<MenuItem> mil){
		Map<String,Integer> menuItemAmountMap = new HashMap<String, Integer>();
		List<String> nameList = new ArrayList<String>();
		for (MenuItem menuItem : mil) {
			nameList.add(menuItem.getItemName());
		}
		for (String name : nameList) {
			menuItemAmountMap.put(name, Collections.frequency(nameList, name));
		}
		return menuItemAmountMap;
	}
	
	/**
	 * 獲取商品名字和價格（數量*單價）
	 * @param mil
	 * @return
	 */
	public static Map<String, Double> corventListToPriceMap(List<MenuItem> mil){
		Map<String,Double> menuItemPriceMap = new HashMap<String, Double>();

		Map<String,Integer> menuItemAmountMap = GetOrderVOHelper.corventListToAmountMap(mil);
	
		for (MenuItem menuItem : mil) {
			menuItemPriceMap.put(menuItem.getItemName(), menuItemAmountMap.get(menuItem.getItemName())*menuItem.getPrice());
		}
		return menuItemPriceMap;
	}
	
	/**
	 * 獲取總價
	 * @param mil
	 * @return
	 */
	public static Double getTotalPirce(List<MenuItem> mil){
		Double totalPrice = (double) 0;
		for (MenuItem menuItem : mil) {
			totalPrice = totalPrice + menuItem.getPrice();
		}
		return totalPrice;
	}

}
