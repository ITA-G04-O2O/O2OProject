package com.g04.o2o.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g04.o2o.dao.MerchantDao;
import com.g04.o2o.entity.Merchant;
import com.g04.o2o.service.MerchantService;

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
}
