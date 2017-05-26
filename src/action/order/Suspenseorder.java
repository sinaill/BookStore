package action.order;

import java.util.List;

import javax.annotation.Resource;

import entity.Orderes;
import entity.User;
import service.Orderservice;
import service.Userservice;

public class Suspenseorder {
	@Resource(name="orderservice")
	private Orderservice orderservice;
	@Resource(name="Userservice")
	private Userservice userservice;
	private List<Orderes> orders;
	private int page = 1;
	private int pagesize=2;
	private int totalPage;
	private User user;
	public String execute(){
		int total = (int) orderservice.suspensenum();
		if(total%pagesize == 0){
			totalPage = total/pagesize;
		}else{
			totalPage = total/pagesize + 1;
		}
		orders = orderservice.getsuspenseorder(page,pagesize);
		if(orders.size() != 0){
			user = userservice.getuserbyid(orders.get(0).getUserid());
		}
		
		return "success";
	}

	public Orderservice getOrderservice() {
		return orderservice;
	}

	public void setOrderservice(Orderservice orderservice) {
		this.orderservice = orderservice;
	}

	public List<Orderes> getOrders() {
		return orders;
	}

	public void setOrders(List<Orderes> orders) {
		this.orders = orders;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public Userservice getUserservice() {
		return userservice;
	}

	public void setUserservice(Userservice userservice) {
		this.userservice = userservice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
