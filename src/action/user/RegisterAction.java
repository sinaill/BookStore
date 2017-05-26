package action.user;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;

import entity.User;
import service.Userservice;
import util.SendEmail;
import util.VerifyUtil;

public class RegisterAction {
	@Resource(name="Userservice")
	private Userservice userservice;
		
	private User user;
	
	
	public String execute(){
		user.setEmail_verificationCode(VerifyUtil.Createcode());
		SendEmail.send(user.getEmail(), VerifyUtil.Emailcontent()+user.getEmail_verificationCode());
		user.setIs_verify(false);
		user.setLast_logintime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		user.setBan(false);
		ActionContext.getContext().getSession().put("user", user);
		userservice.addUser(user);
		return "verify";
	}
	
	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Userservice getUserservice() {
		return userservice;
	}

	

	public void setUserservice(Userservice userservice) {
		this.userservice = userservice;
	}



}
