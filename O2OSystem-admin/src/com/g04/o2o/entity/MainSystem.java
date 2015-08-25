package com.g04.o2o.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 点餐系统 设置菜单自动完成和过期时间
 * 
 * @author ITA_G04
 * 
 */
@Entity
public class MainSystem {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer id;
	private Integer autoExpirationTime; // 自动过期时间
	private Integer autoCompleteTime; // 订单自动完成时间

	public MainSystem() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAutoExpirationTime() {
		return autoExpirationTime;
	}

	public void setAutoExpirationTime(Integer autoExpirationTime) {
		this.autoExpirationTime = autoExpirationTime;
	}

	public Integer getAutoCompleteTime() {
		return autoCompleteTime;
	}

	public void setAutoCompleteTime(Integer autoCompleteTime) {
		this.autoCompleteTime = autoCompleteTime;
	}

}
