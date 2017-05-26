package action.user;

import java.util.List;

import javax.annotation.Resource;

import entity.User;
import service.Userservice;

public class Getbanuser {
	@Resource(name="Userservice")
	private Userservice userservice;
	private List<User> users;
	private int page = 1;
	private int pagesize=9;
	private int totalPage;
	
	public String execute(){
		int total = (int) userservice.banusernum();
		if(total%pagesize == 0){
			totalPage = total/pagesize;
		}else{
			totalPage = total/pagesize + 1;
		}
		users = userservice.getbanuser(page,pagesize);
		return "success";
	}


	public Userservice getUserservice() {
		return userservice;
	}


	public void setUserservice(Userservice userservice) {
		this.userservice = userservice;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
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
