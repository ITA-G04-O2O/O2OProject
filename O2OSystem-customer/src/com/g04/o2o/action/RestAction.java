package com.g04.o2o.action;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vo.MenuItemVo;
import vo.MenuTypeVo;
import vo.OrderVo;
import vo.RestTypeVo;
import vo.RestaurantInfoVo;
import vo.RestaurantVo;

import com.g04.o2o.entity.Address;
import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.MenuType;
import com.g04.o2o.entity.Order;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.RestaurantType;
import com.g04.o2o.service.RestaurantService;
@RestController
public class RestAction {
	@Autowired
	private RestaurantService restService;
	
	@Transactional
	@RequestMapping(value="/restaurantType",method=RequestMethod.GET)
	public JsonProtocol getRestTypes(){
		JsonProtocol jp = new JsonProtocol();
		List<RestaurantType> rt=restService.getRestTypes();
		List<RestTypeVo> rvo=new ArrayList<RestTypeVo>();
		for(RestaurantType r:rt){
			Integer rid=r.getId();
			String type=r.getType();
			RestTypeVo rtvo=new RestTypeVo(rid, type);
			rvo.add(rtvo);
		}
		jp.setObject(rvo);
		System.out.println(rvo);
		return jp;
	}
	
	@Transactional
	@RequestMapping(value="/restaurant/restaurantType/{id}",method=RequestMethod.GET)
	public JsonProtocol getRestList(@PathVariable(value="id") Integer id) throws UnsupportedEncodingException{
		JsonProtocol jp = new JsonProtocol();
		Set<Restaurant> rs = restService.getRestByType(id);
		Set<RestaurantVo> rsVO = new HashSet<RestaurantVo>();
		for(Restaurant r:rs){
			String name=r.getName();
			String mtype=r.getType().getType();
			Integer sum=r.getOrders().size();
			Integer playPrice=r.getPlayPrice();
			Double grade=r.getGrade();
			Double actualArrivalTime=r.getActualArrivalTime();
			RestaurantVo vo=new RestaurantVo(id, name, mtype, sum, playPrice, grade, actualArrivalTime);
			rsVO.add(vo);
		}
		jp.setObject(rsVO);
		return jp;
	}
	
	@Transactional
	@RequestMapping(value="/restaurant/{id}",method=RequestMethod.GET)
	public JsonProtocol getRestInfo(@PathVariable(value="id") Integer id){
		JsonProtocol jp = new JsonProtocol();
		Restaurant r=restService.getRestInfo(id);
		String name=r.getName();
		String type=r.getType().getType();
		Integer playPrice=r.getPlayPrice();
		Double grade=r.getGrade();
		Double actualArrivalTime=r.getActualArrivalTime();
		String notice=r.getNotice();
		List<MenuTypeVo> menuTypes = new ArrayList<MenuTypeVo>();
		
		//change MenuType to MenuTypeVo
		List<MenuType> mTypes=r.getMenuTypes();
		for(MenuType mt:mTypes){
			Set<MenuItemVo> menus=new HashSet<MenuItemVo>();
			Integer mid=mt.getId();
			String mName=mt.getMenuTypeName();
			Set<MenuItem> mItems = restService.getMenuItemByType(id, mid);
			System.out.println(mItems.size());
			for(MenuItem mi:mItems){
				Integer menuId=mi.getId();
				String mitemName=mi.getItemName();
				Double mprice=mi.getPrice();
				String mdescription=mi.getDescription();
				MenuItemVo mivo=new MenuItemVo(menuId, mitemName, mprice, mdescription);
				menus.add(mivo);
			}
			MenuTypeVo mtvo=new MenuTypeVo(mid, mName, menus);
			menuTypes.add(mtvo);
		}
		
		RestaurantInfoVo rivo = new RestaurantInfoVo(id, name, type, playPrice, grade, actualArrivalTime, notice, menuTypes);
		jp.setObject(rivo);
		return jp;
	}
	
	@RequestMapping(value="/restaurant/{id}/menuType",method=RequestMethod.GET)
	public JsonProtocol getMenuType(@PathVariable(value="id") Integer id){
		JsonProtocol jp = new JsonProtocol(); 
		jp.setObject(restService.getMenuType(id));
		return jp;
	}
	
	@RequestMapping(value="/restaurant/{id}/menuItems",method=RequestMethod.GET)
	public JsonProtocol getMenuItems(@PathVariable(value="id") Integer id){
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(restService.getMenuItems(id));
		return jp;
	}
	
	@Transactional
	@RequestMapping(value="/restaurant/{id}/highOrders",method=RequestMethod.GET)
	public JsonProtocol getHighOrders(@PathVariable(value="id") Integer id){
		JsonProtocol jp = new JsonProtocol();
		List<Order> orders = restService.getHighOrders(id);
		List<OrderVo> ordersVo = new ArrayList<OrderVo>();
		for(Order o:orders){
			Integer oid=o.getId();
			Double score=o.getScore();
			String comment=o.getComment();
			String time=o.getCompletedTime().toString();
			OrderVo ov=new OrderVo(oid, comment, time, score);
			ordersVo.add(ov);
		}
		jp.setObject(ordersVo);
		return jp;
	}
	
	@Transactional
	@RequestMapping(value="/restaurant/{id}/midOrders",method=RequestMethod.GET)
	public JsonProtocol getMidOrders(@PathVariable(value="id") Integer id){
		JsonProtocol jp = new JsonProtocol();
		List<Order> orders = restService.getMidOrders(id);
		List<OrderVo> ordersVo = new ArrayList<OrderVo>();
		for(Order o:orders){
			Integer oid=o.getId();
			Double score=o.getScore();
			String comment=o.getComment();
			String time=o.getCompletedTime().toString();
			OrderVo ov=new OrderVo(oid, comment, time, score);
			ordersVo.add(ov);
		}
		jp.setObject(ordersVo);
		return jp;
	}
	
	@Transactional
	@RequestMapping(value="/restaurant/{id}/lowOrders",method=RequestMethod.GET)
	public JsonProtocol getLowOrders(@PathVariable(value="id") Integer id){
		JsonProtocol jp = new JsonProtocol();
		List<Order> orders = restService.getLowOrders(id);
		List<OrderVo> ordersVo = new ArrayList<OrderVo>();
		for(Order o:orders){
			Integer oid=o.getId();
			Double score=o.getScore();
			String comment=o.getComment();
			String time=o.getCompletedTime().toString();
			OrderVo ov=new OrderVo(oid, comment, time, score);
			ordersVo.add(ov);
		}
		jp.setObject(ordersVo);
		return jp;
	}
	
}
