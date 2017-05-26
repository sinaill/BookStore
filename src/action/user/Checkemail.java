package action.user;

import javax.annotation.Resource;

import entity.User;
import service.Userservice;

public class Checkemail {
	@Resource(name="Userservice")
	private Userservice userservice;
	private String email;
	private boolean ok;
	
	
	public String execute(){
		User user = userservice.getuserbyemail(email);
		if(user != null){
			ok=false;
		}else{
			ok=true;
		}
		return "success";
	}
	
	
	
	
	
	public boolean isOk() {
		return ok;
	}





	public void setOk(boolean ok) {
		this.ok = ok;
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
