package com.g04.o2o.service;

import java.util.List;

import com.g04.o2o.entity.Address;

/**
 * 
 * 位置服务
 * 
 * @author LILE8
 * 
 */

public interface AddressService {

	/**
	 * 添加新地址
	 * 
	 * @param addr
	 * @return
	 */
	public int addAddress(Address addr);

	/**
	 * 获取所有的地址
	 * 
	 * @return
	 */
	public List<Address> getAllAddress();

	/**
	 * 获得某个地址
	 * 
	 * @param id
	 * @return
	 */
	public Address getAddress(Integer id);

}
