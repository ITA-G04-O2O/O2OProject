package com.g04.o2o.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 地址 用户地址
 * 
 * @author LILE8
 * @author DINGFR2
 */
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="area")
	private Area area;// 省市信息
	private String detail;// 详细的地址信息
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
