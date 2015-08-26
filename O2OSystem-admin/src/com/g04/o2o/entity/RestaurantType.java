package com.g04.o2o.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class RestaurantType {
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
	@Column(name="restType")
	private String type;
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer id;
	@OneToMany(mappedBy="type",cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
	private Set<Restaurant> hasRestaurants = new HashSet<>();
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
