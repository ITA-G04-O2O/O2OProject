package com.g04.o2o.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * 
 * @author LILE8
 * @author DINGFR2
 * 
 */
@Entity
@Table(name = "myorder")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	@CreationTimestamp
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date crDate;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date receiveTime;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date completedTime; 
	@ManyToOne
	@JoinColumn(name = "restId", nullable = false)
	private Restaurant resturant;
	@ManyToMany
	private List<MenuItem> items = new ArrayList<MenuItem>();
	private String message; 
	private Integer status; //1: user add order. 2:merchant received order. 3:merchant refused order.  4: order finished.
	@ManyToOne
	@JoinColumn(name = "receiver", nullable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "receiveAddress", nullable = true)
	private Address address;
	private String userDefineAddress;
	private Double score;
	private String comment;
	private String tel;
	private String contactName;
	
	public Date getCompletedTime() {
		return completedTime;
	}

	public void setCompletedTime(Date completedTime) {
		this.completedTime = completedTime;
	}
	
	/**
	 * @return the userDefineAddress
	 */
	public String getUserDefineAddress() {
		return userDefineAddress;
	}

	/**
	 * @param userDefineAddress
	 *            the userDefineAddress to set
	 */
	public void setUserDefineAddress(String userDefineAddress) {
		this.userDefineAddress = userDefineAddress;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}



	/**
	 * @return the receiveTime
	 */
	public Date getReceiveTime() {
		return receiveTime;
	}

	/**
	 * @param receiveTime
	 *            the receiveTime to set
	 */
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

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

	public List<MenuItem> getItems() {
		return items;
	}

	public void setItems(List<MenuItem> items) {
		this.items = items;
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
	 * @return the score
	 */
	public Double getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(Double score) {
		this.score = score;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the contactName
	 */
	public String getContactName() {
		return contactName;
	}

	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

}
