package com.g04.o2o.action;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.g04.o2o.entity.JmsProtocol;
import com.g04.o2o.entity.JmsType;
import com.g04.o2o.entity.Merchant;
import com.g04.o2o.entity.Restaurant;
import com.g04.o2o.entity.User;
import com.g04.o2o.service.MerchantService;
import com.g04.o2o.service.UserService;
import com.g04.o2o.tools.JMSUtil;
import com.g04.o2o.tools.JsonUtil;
import com.g04.o2o.vo.MerchantInfoVO;

@Controller
public class MerchantAction {

	@Autowired
	private MerchantService merchantService;

	@Autowired
	private UserService userService;

	public void setMerchantService(MerchantService merchantService) {
		this.merchantService = merchantService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/merchant", method = RequestMethod.POST)
	public String regist(String nickName, String idCard,
			@RequestParam("file") MultipartFile file, HttpSession session)
			throws IOException {
		System.out.println("MerchantAction...");
		System.out.println(nickName);
		Merchant mer = new Merchant();
		mer.setIDCard(idCard);
		User user = userService.getUserById(4);
		mer.setUser(user);
		mer.setIDimage(file.getBytes());
		Restaurant restaurant = (Restaurant) session.getAttribute("restaurant");
		restaurant.setTel(user.getTel());
		mer.setRestaurant(restaurant);
		restaurant.setOwner(mer);
		merchantService.addMerchant(mer);
		JMSUtil jms = new JMSUtil("g04_que");
		JmsProtocol msg = new JmsProtocol();
		msg.setType(JmsType.regist);
		jms.sendMsg(JsonUtil.toJSon(msg));
		return "waiting";
	}

	@ResponseBody
	@RequestMapping(value = "/merchant/{id}", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public MerchantInfoVO getMerchant(@PathVariable Integer id,
			HttpSession session) throws IOException {
		System.out.println("MerchantAction2...");
		System.out.println(id);
		Merchant mer = merchantService.findMerchant(id);
		MerchantInfoVO merV = new MerchantInfoVO();
		merV.setIdCard(mer.getIDCard());
		merV.setRealName(mer.getRealName());
		merV.setTel(mer.getUser().getLoginName());
		System.out.println(merV);
		return merV;
	}

	@ResponseBody
	@RequestMapping(value = "/merchant/vo", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public String update(Integer id, String tel, String idCard,
			String realName, HttpSession session) throws IOException {
		System.out.println("MerchantAction3...");
		System.out.println(id + realName + tel + idCard);
		merchantService.updateMerchantIdCard(id, idCard);
		merchantService.updateMerchantRealName(id, realName);
		return "true";
	}

}
