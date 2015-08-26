package com.g04.o2o.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.entity.Merchant;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.service.MerchantService;

@RestController
public class MerchantAction {

	@Autowired
	private MerchantService merchantService;

	public void setMerchantService(MerchantService merchantService) {
		this.merchantService = merchantService;
	}

	@RequestMapping(value = "/merchant", method = RequestMethod.POST)
	public JsonProtocol regist(Integer uid, String nickName, String idCard,
			byte[] idPic, HttpSession session) {
		System.out.println(nickName);
		JsonProtocol js = new JsonProtocol();
		Merchant mer = new Merchant();
		mer.setIDCard(idCard);
		mer.setId(uid);
		Restaurant restaurant = (Restaurant) session.getAttribute("restrant");
		mer.setRestaurant(restaurant);
		int result = merchantService.addMerchant(mer);
		boolean res = (result == 1 ? true : false);
		js.setResult(res);
		return js;
	}

}
