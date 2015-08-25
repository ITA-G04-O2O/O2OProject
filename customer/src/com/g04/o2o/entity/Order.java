package com.g04.o2o.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer id;
	@CreationTimestamp
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date crDate;
	@ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name="restId")
	private Restaurant resturant;
	private Double activeTime;
	@OneToMany
	@JoinColumn(name="item")
	private List<MenuItem> items;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCrDate() {
		return crDate;
	}
	public void setCrDate(Date crDate) {
		this.crDate = crDate;
	}
	public Restaurant getResturant() {
		return resturant;
	}
	public void setResturant(Restaurant resturant) {
		this.resturant = resturant;
	}
	public Double getActiveTime() {
		return activeTime;
	}
	public void setActiveTime(Double activeTime) {
		this.activeTime = activeTime;
	}
	public List<MenuItem> getItems() {
		return items;
	}
	public void setItems(List<MenuItem> items) {
		this.items = items;
	}
	
}
