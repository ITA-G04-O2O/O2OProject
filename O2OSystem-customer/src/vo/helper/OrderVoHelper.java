package vo.helper;

import java.util.ArrayList;
import java.util.List;

import vo.OrderItemVo;
import vo.OrderVo;

import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.Order;

public class OrderVoHelper {

	public static OrderVo get(Order order) {
		Integer id=order.getId();
		String merchantTel=order.getResturant().getTel();
		Integer var_status = order.getStatus();
		String orderStatus=OrderStatusHelper.getStatusDesc(var_status);
		List<OrderItemVo> items = new ArrayList<>();
		System.out.println(order.getItems().size());
		for(MenuItem it:order.getItems()){
			String itemName=it.getItemName();
			Double price = it.getPrice();
			OrderItemVo item = new OrderItemVo(itemName, 1, price);
			items.add(item);
		}
		
		String address = order.getUserDefineAddress();
		String mycomment = order.getComment();
		String restName = order.getResturant().getName();
		String orderShowTime=order.getCompletedTime().toLocaleString();
		String orderNumber=order.getId().toString();
		String receiver=order.getUser().getLoginName();
		String receiverTel=order.getTel();
		Integer myscore=order.getScore().intValue();
		OrderVo vo = new OrderVo(id, merchantTel, orderStatus, items, address, mycomment, restName, orderShowTime, orderNumber, receiver, receiverTel, myscore);
		return vo;
		
	}

}
