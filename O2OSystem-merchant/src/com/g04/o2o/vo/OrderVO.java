package com.g04.o2o.vo;

import java.util.Date;
import java.util.List;

import com.g04.o2o.entity.MenuItem;
import com.sun.javafx.collections.MappingChange.Map;

public class OrderVO {
	private Integer id;
	private Date createDate;
	private Integer status;
	private String connectPeople;
	private String tel;
	private String address;
	private Map<MenuItem,Integer> menuItemMap; 
	private Double totalPrices;
	public OrderVO(Integer id, Date createDate, Integer status,
			String connectPeople, String tel, String address,
			Map<MenuItem, Integer> menuItemMap, Double totalPrices) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.status = status;
		this.connectPeople = connectPeople;
		this.tel = tel;
		this.address = address;
		this.menuItemMap = menuItemMap;
		this.totalPrices = totalPrices;
	}
	public OrderVO() {
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
	public Map<MenuItem, Integer> getMenuItemMap() {
		return menuItemMap;
	}
	public void setMenuItemMap(Map<MenuItem, Integer> menuItemMap) {
		this.menuItemMap = menuItemMap;
	}
	public Double getTotalPrices() {
		return totalPrices;
	}
	public void setTotalPrices(Double totalPrices) {
		this.totalPrices = totalPrices;
	}
}
