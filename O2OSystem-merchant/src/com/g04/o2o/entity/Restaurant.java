package com.g04.o2o.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	// 电话
	private String tel;
	// 是否为热门
	private boolean hot;
	// 餐厅名字
	private String name;
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(updatable=false)
	// 创建时间
	private Date crt;
	// 拥有菜单
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "resturant")
	private Set<MenuItem> menus;
	// 所有订单
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "resturant")
	private List<Order> orders = new ArrayList<Order>();
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
	@JoinColumn(name="addressId",nullable=false)
	private Address address;
	// 是否营业中
	private boolean online;
	// 是否被列入黑名单
	private boolean block;
	// 当前评分
	private Double grade;

	// 是否繁忙
	private boolean busy;
	private Integer examine; // 审核状态 0：待审核 1：审核通过 2：审核未通过 3：暂停营业
	private Integer collectionTimes;//被收藏次数 这个字段可以省略
	private String notice;// 公告
	private Integer playPrice;// 起送价
	private Integer disCharge;// 配送费
	private String openTime;// 营业时间
	@Lob
	private byte[] imageBytes;
	/**
	 * @return the imageBytes
	 */
	public byte[] getImageBytes() {
		return imageBytes;
	}

	/**
	 * @param imageBytes the imageBytes to set
	 */
	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}

	/**
	 * @return the collectionTimes
	 */
	public Integer getCollectionTimes() {
		return collectionTimes;
	}

	/**
	 * @param collectionTimes the collectionTimes to set
	 */
	public void setCollectionTimes(Integer collectionTimes) {
		this.collectionTimes = collectionTimes;
	}

	/**
	 * @return the notice
	 */
	public String getNotice() {
		return notice;
	}

	/**
	 * @param notice the notice to set
	 */
	public void setNotice(String notice) {
		this.notice = notice;
	}

	/**
	 * @return the playPrice
	 */
	public Integer getPlayPrice() {
		return playPrice;
	}

	/**
	 * @param playPrice the playPrice to set
	 */
	public void setPlayPrice(Integer playPrice) {
		this.playPrice = playPrice;
	}

	/**
	 * @return the disCharge
	 */
	public Integer getDisCharge() {
		return disCharge;
	}

	/**
	 * @param disCharge the disCharge to set
	 */
	public void setDisCharge(Integer disCharge) {
		this.disCharge = disCharge;
	}

	/**
	 * @return the openTime
	 */
	public String getOpenTime() {
		return openTime;
	}

	/**
	 * @param openTime the openTime to set
	 */
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

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

	public Set<MenuItem> getMenus() {
		return menus;
	}

	public void setMenus(Set<MenuItem> menus) {
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
	 * @param tel
	 *            the tel to set
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
	 * @param busy
	 *            the busy to set
	 */
	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	/**
	 * @return the examine
	 */
	public Integer getExamine() {
		return examine;
	}

	/**
	 * @param examine the examine to set
	 */
	public void setExamine(Integer examine) {
		this.examine = examine;
	}

}
