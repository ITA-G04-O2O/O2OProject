package com.g04.o2o.vo;

public class AccountInfoVO {
	private String tel;
	private String realName;
	private String idNum;
	
	public AccountInfoVO(String tel, String realName, String idNum,
			Double blance) {
		super();
		this.tel = tel;
		this.realName = realName;
		this.idNum = idNum;
		this.blance = blance;
	}
	public AccountInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public Double getBlance() {
		return blance;
	}
	public void setBlance(Double blance) {
		this.blance = blance;
	}
	private Double blance;
}
