package com.g04.o2o.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class MenuItem {
	@ManyToOne
	@JoinColumn(name="restId")
	private Restaurant resturant;
	private String itemName;
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Id
	private Integer id;
	private Double price;
	private String description;
	@ManyToOne
	@JoinColumn(name="menuType")
	private MenuType type;
	
	@CreationTimestamp
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date crDate;
	
	public Restaurant getResturant() {
		return resturant;
	}
	public void setResturant(Restaurant resturant) {
		this.resturant = resturant;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MenuType getType() {
		return type;
	}
	public void setType(MenuType type) {
		this.type = type;
	}
	public Date getCrDate() {
		return crDate;
	}
	public void setCrDate(Date crDate) {
		this.crDate = crDate;
	}
}
