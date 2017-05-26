package action.address;

import javax.annotation.Resource;

import entity.Address;
import service.Addressservice;

public class Modifyaddress {
	@Resource(name="addressservice")
	private Addressservice addressservice;
	private Address address;
	
	public String execute(){
		addressservice.updateaddress(address);
		return null;
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
	
	
}
