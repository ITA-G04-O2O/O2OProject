package com.g04.o2o.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Restaurant {
	// 唯一标示
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer id;
	// 电话
	private String tel;
	// 是否为热门
	private boolean hot;
	// 餐厅名字
	private String name;
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
	// 创建时间
	private Date crt;
	// 拥有菜单
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "resturant")
	private List<MenuItem> menus;
	// 所有订单
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "resturant")
	private List<Order> orders;
	// 餐厅类型
	@JoinColumn(name = "restType", nullable = false)
	@ManyToOne
	private RestaurantType type;
	@OneToOne(fetch = FetchType.LAZY)
	// 拥有者
	private Merchant owner;
	// 承诺送达时间
     
	private Double expectArrivalTime;
	// 实际送达时间
	private Double actualArrivalTime;
	// 餐厅地址
	@OneToOne(cascade = { CascadeType.ALL })
	private Address address;
	// 是否营业中
	private boolean online;
	// 是否被列入黑名单
	private boolean block;
	// 当前评分
	private Double grade;
	
	// 是否繁忙
	private boolean busy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isHot() {
		return hot;
	}

	public void setHot(boolean hot) {
		this.hot = hot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCrt() {
		return crt;
	}

	public void setCrt(Date crt) {
		this.crt = crt;
	}

	public List<MenuItem> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuItem> menus) {
		this.menus = menus;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public RestaurantType getType() {
		return type;
	}

	public void setType(RestaurantType type) {
		this.type = type;
	}

	public Merchant getOwner() {
		return owner;
	}

	public void setOwner(Merchant owner) {
		this.owner = owner;
	}

	public Double getExpectArrivalTime() {
		return expectArrivalTime;
	}

	public void setExpectArrivalTime(Double expectArrivalTime) {
		this.expectArrivalTime = expectArrivalTime;
	}

	public Double getActualArrivalTime() {
		return actualArrivalTime;
	}

	public void setActualArrivalTime(Double actualArrivalTime) {
		this.actualArrivalTime = actualArrivalTime;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public boolean isBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

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
	 * @return the busy
	 */
	public boolean isBusy() {
		return busy;
	}

	/**
	 * @param busy the busy to set
	 */
	public void setBusy(boolean busy) {
		this.busy = busy;
	}

}
