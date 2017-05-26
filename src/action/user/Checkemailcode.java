package action.user;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;

import entity.User;
import service.Userservice;

public class Checkemailcode {
	@Resource(name="Userservice")
	private Userservice userservice;
	private String Emailcode;
	private boolean ok = false;
	private boolean fpw;
	private String email;
	public String execute(){
		User user = null;
		if(fpw){
			user = userservice.getuserbyemail(email);
		}else{
			 user = (User) ActionContext.getContext().getSession().get("user");
		}
		
		String code = user.getEmail_verificationCode();
		if(code.equals(Emailcode)){
			user.setIs_verify(true);
			userservice.modify_verification(user);
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


	public String getEmailcode() {
		return Emailcode;
	}


	public void setEmailcode(String emailcode) {
		Emailcode = emailcode;
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
