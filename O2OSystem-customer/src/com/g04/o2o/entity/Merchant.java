package com.g04.o2o.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Merchant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToOne(mappedBy = "owner", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private Restaurant restaurant;
	private String IDCard;
	@Lob
	private byte[] IDimage;
	@Lob
	private byte[] licenseImage;

	private String realName;
	@OneToOne
//	@JoinColumn(foreignKey = @ForeignKey(name = "user_id"))
	private User user;

	/**
	 * @return the iDimage
	 */
	public byte[] getIDimage() {
		return IDimage;
	}

	/**
	 * @param iDimage
	 *            the iDimage to set
	 */
	public void setIDimage(byte[] iDimage) {
		IDimage = iDimage;
	}

	/**
	 * @return the licenseImage
	 */
	public byte[] getLicenseImage() {
		return licenseImage;
	}

	/**
	 * @param licenseImage
	 *            the licenseImage to set
	 */
	public void setLicenseImage(byte[] licenseImage) {
		this.licenseImage = licenseImage;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	/**
	 * @return the iDCard
	 */
	public String getIDCard() {
		return IDCard;
	}

	/**
	 * @param iDCard
	 *            the iDCard to set
	 */
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * @param realName
	 *            the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
