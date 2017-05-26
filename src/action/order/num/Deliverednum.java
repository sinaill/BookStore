package action.order.num;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;

import entity.User;
import service.Orderservice;

//待收货
public class Deliverednum {
	@Resource(name="orderservice")
	private Orderservice orderservice;
	private int num;
	public String execute(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		num = (int) orderservice.getdelivernum(user.getId());
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
