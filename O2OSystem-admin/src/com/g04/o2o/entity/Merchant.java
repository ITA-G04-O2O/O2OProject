package com.g04.o2o.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
@Entity
public class Merchant extends User{
	
	@OneToOne(mappedBy="owner",fetch=FetchType.LAZY,cascade={CascadeType.ALL})
	private Restaurant restaurant;
	private String IDCard;
	@Lob
	private byte[] IDimage;
	@Lob
	private byte[]  licenseImage;
	/**
	 * @return the iDimage
	 */
	public byte[] getIDimage() {
		return IDimage;
	}
	/**
	 * @param iDimage the iDimage to set
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
	 * @param licenseImage the licenseImage to set
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
	 * @param iDCard the iDCard to set
	 */
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	
	
}
