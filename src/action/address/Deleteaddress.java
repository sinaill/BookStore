package action.address;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;

import entity.Address;
import entity.User;
import service.Userservice;

public class Deleteaddress {
	@Resource(name="Userservice")
	private Userservice userservice;
	private int address_id;
	
	
	
	public String execute(){
		User user = (User) ActionContext.getContext().getSession().get("user");;
		List<Address> address = user.getAddress();
		for (int i = 0; i < address.size(); i++) {
			if(address.get(i).getId() == address_id){
				address.remove(address.get(i));
			}
		}
		userservice.updateuser(user);
		return "success";
	}
	
	
	
	
	
	public Userservice getUserservice() {
		return userservice;
	}
	public void setUserservice(Userservice userservice) {
		this.userservice = userservice;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	
	
}
