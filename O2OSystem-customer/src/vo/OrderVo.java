package vo;

import java.util.List;


public class OrderVo {
	private Integer id;
	private String merchantTel;
	private String orderStatus;
	private List<OrderItemVo> items;
	private String address;
	private String mycomment;
	private String restName;
	private String orderShowTime;
	private String orderNumber;
	private String receiver;
	private String receiverTel;
	private Integer myscore;
	private Integer uid;
	
	public OrderVo(Integer id, String merchantTel, String orderStatus, List<OrderItemVo> items, String address, String mycomment, String restName, String orderShowTime, String orderNumber,
			String receiver, String receiverTel, Integer myscore) {
		super();
		this.id = id;
		this.merchantTel = merchantTel;
		this.orderStatus = orderStatus;
		this.items = items;
		this.address = address;
		this.mycomment = mycomment;
		this.restName = restName;
		this.orderShowTime = orderShowTime;
		this.orderNumber = orderNumber;
		this.receiver = receiver;
		this.receiverTel = receiverTel;
		this.myscore = myscore;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the merchantTel
	 */
	public String getMerchantTel() {
		return merchantTel;
	}
	/**
	 * @param merchantTel the merchantTel to set
	 */
	public void setMerchantTel(String merchantTel) {
		this.merchantTel = merchantTel;
	}
	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * @return the items
	 */
	public List<OrderItemVo> getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(List<OrderItemVo> items) {
		this.items = items;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the mycomment
	 */
	public String getMycomment() {
		return mycomment;
	}
	/**
	 * @param mycomment the mycomment to set
	 */
	public void setMycomment(String mycomment) {
		this.mycomment = mycomment;
	}
	/**
	 * @return the restName
	 */
	public String getRestName() {
		return restName;
	}
	/**
	 * @param restName the restName to set
	 */
	public void setRestName(String restName) {
		this.restName = restName;
	}
	/**
	 * @return the orderShowTime
	 */
	public String getOrderShowTime() {
		return orderShowTime;
	}
	/**
	 * @param orderShowTime the orderShowTime to set
	 */
	public void setOrderShowTime(String orderShowTime) {
		this.orderShowTime = orderShowTime;
	}
	/**
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}
	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}
	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	/**
	 * @return the receiverTel
	 */
	public String getReceiverTel() {
		return receiverTel;
	}
	/**
	 * @param receiverTel the receiverTel to set
	 */
	public void setReceiverTel(String receiverTel) {
		this.receiverTel = receiverTel;
	}
	/**
	 * @return the myscore
	 */
	public Integer getMyscore() {
		return myscore;
	}
	/**
	 * @param myscore the myscore to set
	 */
	public void setMyscore(Integer myscore) {
		this.myscore = myscore;
	}
	/**
	 * @return the uid
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
}
