package action.user;

import com.opensymphony.xwork2.ActionContext;

public class Logout {
	public String execute(){
		ActionContext.getContext().getSession().remove("user");
		return "success";
	}
}
