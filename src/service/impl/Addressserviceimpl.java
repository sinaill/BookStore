package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.AddressDao;
import dao.Userdao;
import entity.Address;
import entity.User;
import service.Addressservice;
@Service("addressservice")
public class Addressserviceimpl implements Addressservice {
	
	@Resource(name="userDAO")
	private Userdao userdao;
	@Resource(name="addressdao")
	private AddressDao addressdao;
	@Override
	public void addaddress(User user, Address address) {
		// TODO Auto-generated method stub
		user.getAddress().add(address);
		userdao.updateuser(user);
	}
	
	@Override
	public void deleteaddress(User user, int address_id) {
		// TODO Auto-generated method stub
		List<Address> addresses = user.getAddress();
		for(int i = 0;i<addresses.size();i++){
			if(addresses.get(i).getId() == address_id){
				addresses.remove(addresses.get(i));
			}
		}
		userdao.updateuser(user);
	}

	
	
	@Override
	public Address getaddressbyid(int address_id) {
		// TODO Auto-generated method stub
		return addressdao.getaddressbyid(address_id);
	}

	@Override
	public void modifyaddress(Address address) {
		// TODO Auto-generated method stub
		addressdao.updateaddress(address);
	}
	
	@Override
	public void updateaddress(Address address){
		addressdao.updateaddress(address);
	}

}
