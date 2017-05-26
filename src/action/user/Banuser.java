package action.user;

import javax.annotation.Resource;

import entity.User;
import service.Userservice;

public class Banuser {
	@Resource(name="Userservice")
	private Userservice userservice;
	private String email;
	
	
	public String execute(){
		User user = userservice.getuserbyemail(email);
		user.setBan(true);
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
