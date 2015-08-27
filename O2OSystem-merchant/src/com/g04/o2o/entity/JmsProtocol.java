package com.g04.o2o.entity;
/**
 * 发送jms有商家注册和订单两种情况
 * 商家注册需要发送type和mid
 * 订单情况发生改变需要有type，uid，mid三种属性
 * @author LILE8
 *
 */
public class JmsProtocol {
	private JmsType type;
	private int mid;
	private int uid;

	public JmsType getType() {
		return type;
	}

	public void setType(JmsType type) {
		this.type = type;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

}
