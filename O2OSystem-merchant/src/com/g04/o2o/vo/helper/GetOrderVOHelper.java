package com.g04.o2o.vo.helper;

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
		goVo.setMenuItemMap(GetOrderVOHelper.corventListToMap(order.getItems()));
		goVo.setTotalPrices(GetOrderVOHelper.getTotalPirce(order.getItems()));
		return goVo;
	}
	
	public static Map<MenuItem, Integer> corventListToMap(List<MenuItem> mil){
		System.out.println("mil="+mil.size());
		Map<MenuItem,Integer> menuItemMap = new HashMap<MenuItem, Integer>();
		for (MenuItem menuItem : mil) {
			menuItemMap.put(menuItem, Collections.frequency(mil, menuItem));
		}
		return menuItemMap;
	}
	
	public static Double getTotalPirce(List<MenuItem> mil){
		Double totalPrice = null;
		for (MenuItem menuItem : mil) {
			System.out.println("::::::::"+menuItem.getPrice());
			totalPrice = totalPrice + menuItem.getPrice();
		}
		return totalPrice;
	}

}
