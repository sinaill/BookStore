package action.manager;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;

import entity.Manager;
import service.Managerservice;

public class Modifypassword {
	@Resource(name="managerservice")
	private Managerservice managerservice;
	private String password;
	public String execute(){
		Manager manager = (Manager) ActionContext.getContext().getSession().get("manager");
		manager.setPassword(password);
		managerservice.updatamanager(manager);
		return "success";
	}
	public Managerservice getManagerservice() {
		return managerservice;
	}
	public void setManagerservice(Managerservice managerservice) {
		this.managerservice = managerservice;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
