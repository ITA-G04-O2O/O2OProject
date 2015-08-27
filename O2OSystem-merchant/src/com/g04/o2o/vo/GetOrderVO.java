package com.g04.o2o.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.g04.o2o.entity.MenuItem;

public class GetOrderVO {
	private Integer id;
	private Date createDate;
	private Date completedDate;
	public Date getCompletedDate() {
		return completedDate;
	}
	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}
	private Integer status;
	private String connectPeople;
	private String tel;
	private String address;
	private Map<String,Integer> menuItemAmountMap; 
	private Map<String, Double> menuItemPriceMap;
	private Double totalPrices;

	public GetOrderVO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getConnectPeople() {
		return connectPeople;
	}
	public void setConnectPeople(String connectPeople) {
		this.connectPeople = connectPeople;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	public Double getTotalPrices() {
		return totalPrices;
	}
	public void setTotalPrices(Double totalPrices) {
		this.totalPrices = totalPrices;
	}

	public GetOrderVO(Integer id, Date createDate, Integer status,
			String connectPeople, String tel, String address,
			Map<String, Integer> menuItemAmountMap,
			Map<String, Double> menuItemPriceMap, Double totalPrices) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.status = status;
		this.connectPeople = connectPeople;
		this.tel = tel;
		this.address = address;
		this.menuItemAmountMap = menuItemAmountMap;
		this.menuItemPriceMap = menuItemPriceMap;
		this.totalPrices = totalPrices;
	}
	public Map<String, Integer> getMenuItemAmountMap() {
		return menuItemAmountMap;
	}
	public void setMenuItemAmountMap(Map<String, Integer> menuItemAmountMap) {
		this.menuItemAmountMap = menuItemAmountMap;
	}
	public Map<String, Double> getMenuItemPriceMap() {
		return menuItemPriceMap;
	}
	public void setMenuItemPriceMap(Map<String, Double> menuItemPriceMap) {
		this.menuItemPriceMap = menuItemPriceMap;
	}
}
