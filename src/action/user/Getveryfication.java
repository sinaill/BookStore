package action.user;

import javax.annotation.Resource;

import entity.User;
import service.Userservice;
import util.SendEmail;
import util.VerifyUtil;

public class Getveryfication {
	@Resource(name="Userservice")
	private Userservice userservice;
	private String email;
	
	
	public String execute(){
		User user = userservice.getuserbyemail(email);
		user.setEmail_verificationCode(VerifyUtil.Createcode());
		SendEmail.send(user.getEmail(), VerifyUtil.FPWcontent()+user.getEmail_verificationCode());
		
		userservice.updateuser(user);
		return "success";
	}


	public Userservice getUserservice() {
		return userservice;
	}


	public void setUserservice(Userservice userservice) {
		this.userservice = userservice;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
