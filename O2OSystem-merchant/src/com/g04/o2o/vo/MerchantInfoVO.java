package com.g04.o2o.vo;

public class MerchantInfoVO {
	private Integer id;
	private String realName;
	private String tel;
	private String idCard;

	public MerchantInfoVO() {

	}

	public MerchantInfoVO(Integer id, String realName, String tel, String idCard) {
		super();
		this.id = id;
		this.realName = realName;
		this.tel = tel;
		this.idCard = idCard;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "MerchantInfoVO [id=" + id + ", realName=" + realName + ", tel="
				+ tel + ", idCard=" + idCard + "]";
	}

}
