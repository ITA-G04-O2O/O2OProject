package com.g04.o2o.entity;




import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
/**
 * 
 * @author DINGFR2
 *
 */
public class MenuType {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer id;
	private String MenuTypeName;
	private String creater;
	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="restID")
	private Restaurant rest;
	
	/**
	 * @return the rest
	 */
	public Restaurant getRest() {
		return rest;
	}
	/**
	 * @param rest the rest to set
	 */
	public void setRest(Restaurant rest) {
		this.rest = rest;
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
