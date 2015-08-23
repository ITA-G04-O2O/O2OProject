package com.g04.o2o.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MenuType {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer id;
	private String MenuTypeName;
	private String creater;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuTypeName() {
		return MenuTypeName;
	}
	public void setMenuTypeName(String menuTypeName) {
		MenuTypeName = menuTypeName;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	
}
