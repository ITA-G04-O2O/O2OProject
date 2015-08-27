package com.g04.o2o.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.g04.o2o.entity.Merchant;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.service.MerchantService;

@Controller
public class MerchantAction {

	@Autowired
	private MerchantService merchantService;

	public void setMerchantService(MerchantService merchantService) {
		this.merchantService = merchantService;
	}

	@RequestMapping(value = "/merchant", method = RequestMethod.POST)
	public String regist(String nickName, String idCard,
			@RequestParam("file") MultipartFile file, HttpSession session) {
		System.out.println("MerchantAction...");
		System.out.println(nickName);
		Merchant mer = new Merchant();
		mer.setIDCard(idCard);
		
//		mer.setId(2);
		
		Restaurant restaurant = (Restaurant) session.getAttribute("restaurant");
		mer.setRestaurant(restaurant);
		merchantService.addMerchant(mer);
		return "waiting";
	}
}
