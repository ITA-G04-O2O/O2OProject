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
/**
 * @author LILE8
 * @author DINGFR2
 *菜品单项
 */
public class MenuItem {
	@ManyToOne
	@JoinColumn(name="restId",nullable=false)
	private Restaurant resturant;// 这个菜品所属的餐厅
	private String itemName;// 菜品的名字
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Id
	private Integer id;
	private Double price;// 菜品的价格
	private String description;// 描述
	@ManyToOne
	@JoinColumn(name="menuType")
	private MenuType type;// 菜品类别
	private Integer salesVolume;// 销量
	private double score; // 评分
	
	/**
	 * @return the salesVolume
	 */
	public Integer getSalesVolume() {
		return salesVolume;
	}
	/**
	 * @param salesVolume the salesVolume to set
	 */
	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}
	/**
	 * @return the score
	 */
	public double getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(double score) {
		this.score = score;
	}
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
