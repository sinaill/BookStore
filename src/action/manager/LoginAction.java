package action.manager;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import entity.Manager;
import service.Managerservice;

public class LoginAction {
	@Resource(name="managerservice")
	private Managerservice managerservice;
	private String name;
	private String password;
	
	
	public String execute(){
		Manager manager = managerservice.getbyname(name);
		if(manager != null && manager.getPassword().equals(password)){
			ActionContext.getContext().getSession().put("manager", manager);
			return "success";
		}else{
			ServletActionContext.getRequest().setAttribute("login_error", "账号或密码错误");
			return "fail";
		}
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Managerservice getManagerservice() {
		return managerservice;
	}
	public void setManagerservice(Managerservice managerservice) {
		this.managerservice = managerservice;
	}
	
}
