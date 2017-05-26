package action.user;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;

import entity.User;
import service.Userservice;

public class Modifypassword {
	@Resource(name="Userservice")
	private Userservice userservice;
	private String old_password;
	private String new_password;
	private boolean ok;
	private boolean fpw;
	private String email;
	public String execute(){
		User user;
		if(fpw){
			user = userservice.getuserbyemail(email);
			user.setPassword(new_password);
			userservice.updateuser(user);
			ok = true;
		}else{
			user = (User) ActionContext.getContext().getSession().get("user");
			if(user.getPassword().equals(old_password) ){
				user.setPassword(new_password);
				userservice.updateuser(user);
				ok = true;
			}else{
				ok = false;
			}
		}
		 
		
		
		return "success";
	}
	
	


	public boolean isOk() {
		return ok;
	}


	public void setOk(boolean ok) {
		this.ok = ok;
	}


	public String getOld_password() {
		return old_password;
	}
	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}
	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}
	public Userservice getUserservice() {
		return userservice;
	}
	public void setUserservice(Userservice userservice) {
		this.userservice = userservice;
	}



	public boolean isFpw() {
		return fpw;
	}



	public void setFpw(boolean fpw) {
		this.fpw = fpw;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
}
