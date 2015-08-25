package com.g04.o2o.service;

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

}
