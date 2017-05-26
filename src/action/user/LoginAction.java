package action.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import entity.User;
import service.Userservice;

public class LoginAction {
	@Resource(name="Userservice")
	private Userservice userservice;
	private User user;
	public String execute(){
		String email = user.getEmail();
		String password = user.getPassword();
		User user = userservice.getuserbyemail(email);
		if(user != null && user.getPassword().equals(password)){
			user.setLast_logintime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			ActionContext.getContext().getSession().put("user", user);
			if(user.isIs_verify()){
				if(user.isBan()){
					ServletActionContext.getRequest().setAttribute("login_error", "该账号已被禁用");
					return "fail";
					
				}
				userservice.updateuser(user);
				return "success";
			}else {
				return "verify";
			}
		}
		
		ServletActionContext.getRequest().setAttribute("login_error", "用户名或密码错误");
		return "fail";
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
