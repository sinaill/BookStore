package service;

import entity.Address;
import entity.User;

public interface Addressservice {
	public void addaddress(User user,Address address);
	public void deleteaddress(User user, int address_id);
	public void modifyaddress(Address address);
	public void updateaddress(Address address);
	public Address getaddressbyid(int address_id);
}
