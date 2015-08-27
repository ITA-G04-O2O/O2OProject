package com.g04.o2o.vo;

import com.g04.o2o.entity.Address;
import com.g04.o2o.entity.RestaurantType;

public class RestaurantVO {

	private Integer id;
	private String name;
	private RestaurantType type;
	private Address address;
	private String notice;// 公告
	private Integer playPrice;// 起送价
	private Integer disCharge;// 配送费
	private String openTime;// 营业时间
	private String tel;

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RestaurantType getType() {
		return type;
	}

	public void setType(RestaurantType type) {
		this.type = type;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public Integer getPlayPrice() {
		return playPrice;
	}

	public void setPlayPrice(Integer playPrice) {
		this.playPrice = playPrice;
	}

	public Integer getDisCharge() {
		return disCharge;
	}

	public void setDisCharge(Integer disCharge) {
		this.disCharge = disCharge;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

}
