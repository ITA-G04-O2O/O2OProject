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

	/**
	 * 通过id找到商家
	 * 
	 * @param id
	 * @return
	 */
	public Merchant findMerchant(Integer id);

	/**
	 * 更新商家真实姓名
	 * 
	 * @param realName
	 * @return
	 */
	public int updateMerchantRealName(Integer id, String realName);

	/**
	 * 更新商家身份证号
	 * 
	 * @param idCard
	 * @return
	 */
	public int updateMerchantIdCard(Integer id, String idCard);
}
