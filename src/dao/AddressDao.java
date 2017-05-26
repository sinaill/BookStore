package dao;

import entity.Address;

public interface AddressDao {
	public Address getaddressbyid(int address_id);
	public void updateaddress(Address address);
}
