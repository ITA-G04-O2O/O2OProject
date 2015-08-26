package vo.helper;

public class OrderStatusHelper {
	public static String getStatusDesc(Integer status){
		//1: user add order. 2:merchant received order. 3:merchant refused order. 4: order finished.
		switch (status) {
		case 1:
			return "用户提交订单";
		case 2:
			return "订单被确认";
		case 3:
			return "商家拒绝订单";
		case 4:
			return "订单完成";
		default:
			return "无状态";
		}
	}
}
