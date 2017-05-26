package action.order.num;

import javax.annotation.Resource;


import service.Orderservice;

//待收货
public class DeliverednumBack {
	@Resource(name="orderservice")
	private Orderservice orderservice;
	private int num;
	public String execute(){
		num = (int) orderservice.getdelivernum();
		return "success";
	}
	public Orderservice getOrderservice() {
		return orderservice;
	}
	public void setOrderservice(Orderservice orderservice) {
		this.orderservice = orderservice;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
