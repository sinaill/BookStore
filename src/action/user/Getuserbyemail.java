package action.user;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import entity.User;
import service.Userservice;

public class Getuserbyemail {
	@Resource(name="Userservice")
	private Userservice userservice;
	private List<User> users;
	private String email;
	
	public String execute(){
		users = new ArrayList<User>();
		users.add(userservice.getuserbyemail(email));
		
		return "success";
	}

	public Userservice getUserservice() {
		return userservice;
	}

	public void setUserservice(Userservice userservice) {
		this.userservice = userservice;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
