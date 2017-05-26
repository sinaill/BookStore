package action.user;

import javax.annotation.Resource;

import entity.Orderes;
import service.Orderservice;

public class RecieveAction {
	@Resource(name="orderservice")
	private Orderservice orderservice;
	private int order_id;
	
	
	
	public String execute(){
		Orderes order = orderservice.getorderbyid(order_id);
		order.setState("已收货");
		orderservice.updateorder(order);
		return "success";
	}
	
	
	
	public Orderservice getOrderservice() {
		return orderservice;
	}
	public void setOrderservice(Orderservice orderservice) {
		this.orderservice = orderservice;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
}
