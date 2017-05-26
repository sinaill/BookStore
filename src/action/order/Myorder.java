package action.order;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;

import entity.Orderes;
import entity.User;
import service.Orderservice;

public class Myorder {
	@Resource(name="orderservice")
	private Orderservice orderservice;
	private List<Orderes> orderes;
	private int page = 1;
	private int pagesize=2;
	private int totalPage;
	private User user;
	
	
	public String execute(){
		user = (User) ActionContext.getContext().getSession().get("user");
		int total = (int) orderservice.getnumbyuserid(user.getId());
		if(total%pagesize == 0){
			totalPage = total/pagesize;
		}else{
			totalPage = total/pagesize + 1;
		}
		orderes = orderservice.getorderbyuserid(user.getId(), page, pagesize);
		return "success";
	}


	public List<Orderes> getOrderes() {
		return orderes;
	}


	public void setOrderes(List<Orderes> orderes) {
		this.orderes = orderes;
	}


	public Orderservice getOrderservice() {
		return orderservice;
	}



	public void setOrderservice(Orderservice orderservice) {
		this.orderservice = orderservice;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
}
