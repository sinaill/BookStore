package action.order;

import java.util.List;

import javax.annotation.Resource;

import entity.Orderes;
import service.Orderservice;

public class Getreatedorder {
	@Resource(name="orderservice")
	private Orderservice orderservice;
	private List<Orderes> orders;
	private int page = 1;
	private int pagesize=2;
	private int totalPage;
	
	public String execute(){
		int total = (int) orderservice.ordernum();
		if(total%pagesize == 0){
			totalPage = total/pagesize;
		}else{
			totalPage = total/pagesize + 1;
		}
		orders = orderservice.gettreatedorder(page,pagesize);
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
	
}
