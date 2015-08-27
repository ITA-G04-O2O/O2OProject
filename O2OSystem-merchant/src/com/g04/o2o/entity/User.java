package com.g04.o2o.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@CreationTimestamp
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(updatable=false)
	private Date registTime;
	@Column(nullable=false)
	private String loginName;
	@Column(nullable=false)
	private String password;
	private Integer age;
	private boolean sex;
	private String tel;
	private Double blance;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address = new ArrayList<Address>();// 用户的地址
	@OneToMany
	private Set<Restaurant> restlikes = new HashSet<Restaurant>();
	
	private String nickName;
	
	@OneToMany(mappedBy="user",cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
	private List<Order> historyOrders = new ArrayList<>();
	/**
	 * @return the historyOrders
	 */
	public List<Order> getHistoryOrders() {
		return historyOrders;
	}

	/**
	 * @param historyOrders the historyOrders to set
	 */
	public void setHistoryOrders(List<Order> historyOrders) {
		this.historyOrders = historyOrders;
	}

	/**
	 * @return the restlikes
	 */
	public Set<Restaurant> getRestlikes() {
		return restlikes;
	}

	/**
	 * @param restlikes
	 *            the restlikes to set
	 */
	public void setRestlikes(Set<Restaurant> restlikes) {
		this.restlikes = restlikes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Double getBlance() {
		return blance;
	}

	public void setBlance(Double blance) {
		this.blance = blance;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
