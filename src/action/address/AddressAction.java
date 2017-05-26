package action.address;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;

import entity.Address;
import entity.User;
import service.Addressservice;
import service.Userservice;

public class AddressAction {
	@Resource(name="addressservice")
	private Addressservice addressservice;
	@Resource(name="Userservice")
	private Userservice userservice;
	private int address_id;
	private Address address;
	private boolean json;
	private List<Address> addresses;
	
	public String execute(){

			User user = (User) ActionContext.getContext().getSession().get("user");
			addresses = user.getAddress();

			

				for(int i = 0;i < addresses.size();i++){
					if(addresses.get(i).getId() == address_id){
						address = addresses.get(i);
					}
				}
		
			if(json){
				return "success";
			}
			
			
			return "address";
			

		

	}
	
	public boolean isJson() {
		return json;
	}

	public void setJson(boolean json) {
		this.json = json;
	}

	public Addressservice getAddressservice() {
		return addressservice;
	}

	public void setAddressservice(Addressservice addressservice) {
		this.addressservice = addressservice;
	}

	public Userservice getUserservice() {
		return userservice;
	}

	public void setUserservice(Userservice userservice) {
		this.userservice = userservice;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}



	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}


	
	
}
