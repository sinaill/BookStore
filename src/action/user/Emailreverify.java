package action.user;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;

import entity.User;
import service.Userservice;
import util.SendEmail;
import util.VerifyUtil;

public class Emailreverify {
	
	@Resource(name="Userservice")
	private Userservice userservice;
	private User user;
	public String execute(){
		user = (User) ActionContext.getContext().getSession().get("user");
		user.setEmail_verificationCode(VerifyUtil.Createcode());
		SendEmail.send(user.getEmail(), VerifyUtil.Emailcontent()+user.getEmail_verificationCode());
		
		userservice.updateuser(user);
		return "success";
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
