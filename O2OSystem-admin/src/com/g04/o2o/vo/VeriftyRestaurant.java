package com.g04.o2o.vo;

import com.g04.o2o.entity.Address;
import com.g04.o2o.entity.RestaurantType;

public class VeriftyRestaurant {
	private Integer id;
	private String tel;
	private String name;
	private RestaurantType type;
	private String owner;
	private Address address;
	private String IDCard;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String string) {
		this.owner = string;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

}
