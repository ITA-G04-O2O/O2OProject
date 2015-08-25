package com.g04.o2o.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotLine {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String tel;
	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
