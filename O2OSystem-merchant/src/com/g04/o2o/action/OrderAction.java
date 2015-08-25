package com.g04.o2o.action;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g04.o2o.entity.JsonProtocol;
import com.g04.o2o.service.OrderService;

/**
 * Order handler function
 * @author OUOK
 *
 */
@RestController
public class OrderAction {
	@Autowired
	private OrderService os;
<<<<<<< HEAD

	public void setOs(OrderService os) {
		this.os = os;
	}

=======
	
	/**
	 * get all orders
	 * @return
	 */
>>>>>>> 4094124575fd71e8a22e0eda8a9e28a44c0eccf7
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public JsonProtocol getOrders() {
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(os.getAllOrders());
		return jp;
	}
<<<<<<< HEAD

=======
	
	/**
	 * get one order by id
	 * @param id
	 * @return
	 */
>>>>>>> 4094124575fd71e8a22e0eda8a9e28a44c0eccf7
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public JsonProtocol getOrder(@PathVariable Integer id) {
		JsonProtocol jp = new JsonProtocol();
		jp.setObject(os.getOrderById(id));
		return jp;
	}
<<<<<<< HEAD

=======
	
	/**
	 * update order's receiveTime with id&receiveTime.
	 * @param id
	 * @param recevieTime
	 * @return
	 */
>>>>>>> 4094124575fd71e8a22e0eda8a9e28a44c0eccf7
	@RequestMapping(value = "/orders/{id}/rece", method = RequestMethod.PUT)
	public JsonProtocol updateOrderReceiveTime(@PathVariable Integer id,
			Date recevieTime) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(os.updOrderReceiveTime(id, recevieTime));
		return jp;
	}
<<<<<<< HEAD

=======
	
	/**
	 * update order's completedTime with id&completedTime.
	 * @param id
	 * @param completedTime
	 * @return
	 */
>>>>>>> 4094124575fd71e8a22e0eda8a9e28a44c0eccf7
	@RequestMapping(value = "/orders/{id}/comp", method = RequestMethod.PUT)
	public JsonProtocol updOrderCompleteTime(@PathVariable Integer id,
			Date completedTime) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(os.updOrderCompleteTime(id, completedTime));
		return jp;
	}

	/**
	 * update order's status with id&status.
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/orders/{id}/status", method = RequestMethod.PUT)
	public JsonProtocol updOrderStatus(@PathVariable Integer id, Integer status) {
		JsonProtocol jp = new JsonProtocol();
		jp.setResult(os.updOrderStatus(id, status));
		return jp;
	}
}
