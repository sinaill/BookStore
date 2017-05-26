package action.address;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;

import entity.Address;
import entity.User;
import service.Addressservice;
import service.Userservice;

public class Addaddress {
	@Resource(name="addressservice")
	private Addressservice addressservice;
	@Resource(name="Userservice")
	private Userservice userservice;
	private Address address;
	private int address_id;
	
	
	public String execute(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		//User user = userservice.getuserbyemail("980195840@qq.com");
		if(address_id == 0){
			addressservice.addaddress(user, address);
		}
		else{
			List<Address> addresses = user.getAddress();
			for (int i = 0; i < addresses.size(); i++) {
				if(addresses.get(i).getId() == address_id){
					Address addresstemp = addresses.get(i);
					addresstemp.setReciever_name(address.getReciever_name());
					addresstemp.setAddress(address.getAddress());
					addresstemp.setPostal_code(address.getPostal_code());
					addresstemp.setMobile(address.getMobile());
					addressservice.updateaddress(addresstemp);
				}
			}
			
		}
		return "success";
	}

	
	
	public Addressservice getAddressservice() {
		return addressservice;
	}

	public void setAddressservice(Addressservice addressservice) {
		this.addressservice = addressservice;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
