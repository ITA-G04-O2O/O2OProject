package com.g04.o2o.service;

import java.util.List;

import com.g04.o2o.entity.Merchant;

/**
 * 
 * 商家服务
 * 
 * @author LILE8
 * 
 */
public interface MerchantService {
	/**
	 * 新增商家
	 * 
	 * @param merchant
	 * @return
	 */
	public int addMerchant(Merchant merchant);

	/**
	 * 找到所有商家
	 * 
	 * @return
	 */
	public List<Merchant> findAllMerchant();

}
