package com.g04.o2o.vo;

import com.g04.o2o.entity.MenuType;
import com.g04.o2o.entity.Restaurant;

public class MenuItemVo {
	private String itemName;
	private Integer id;
	private Double price;
	private String description;
	private Integer typeId;
	private Integer salesVolume;
	private Double score;
	private byte[] image;
	private Integer resturantId;

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

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Integer getResturantId() {
		return resturantId;
	}

	public void setResturantId(Integer resturantId) {
		this.resturantId = resturantId;
	}

}
