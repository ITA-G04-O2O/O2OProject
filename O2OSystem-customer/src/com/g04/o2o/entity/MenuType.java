package com.g04.o2o.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
/**
 * 菜品的类别
 * @author DINGFR2
 *
 */
public class MenuType {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer id;
	private String MenuTypeName;
	private String creater;
	@OneToMany(mappedBy="type")
	private Set<Restaurant> hasRestaurants = new HashSet<Restaurant>();
	
	/**
	 * @return the hasRestaurants
	 */
	public Set<Restaurant> getHasRestaurants() {
		return hasRestaurants;
	}
	/**
	 * @param hasRestaurants the hasRestaurants to set
	 */
	public void setHasRestaurants(Set<Restaurant> hasRestaurants) {
		this.hasRestaurants = hasRestaurants;
	}
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
