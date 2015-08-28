package com.g04.o2o.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g04.o2o.dao.MerchantDao;
import com.g04.o2o.entity.JmsProtocol;
import com.g04.o2o.entity.JmsType;
import com.g04.o2o.entity.Merchant;
import com.g04.o2o.service.MerchantService;
import com.g04.o2o.tools.JMSUtil;
import com.g04.o2o.tools.JsonUtil;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantDao dao;

	@Override
	@Transactional
	public int addMerchant(Merchant merchant) {
		return dao.add(merchant);
	}

	@Override
	public List<Merchant> findAllMerchant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Merchant findMerchant(Integer id) {
		return dao.search(Merchant.class, id);
	}

	@Override
	@Transactional
	public int updateMerchantRealName(Integer id, String realName) {
		return dao.updateValue(id, Merchant.class, "realName", realName);
	}

	@Override
	@Transactional
	public int updateMerchantIdCard(Integer id, String idCard) {
		// TODO Auto-generated method stub
		return dao.updateValue(id, Merchant.class, "IDCard", idCard);
	}
}
