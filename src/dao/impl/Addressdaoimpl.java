package dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.AddressDao;
import entity.Address;
@Repository("addressdao")
public class Addressdaoimpl implements AddressDao{
	@Autowired
	private SessionFactory sessionfactory;

	public Session getSession(){
		return sessionfactory.getCurrentSession();
	}
	
	@Override
	public Address getaddressbyid(int address_id) {
		// TODO Auto-generated method stub
		String hql = "from Address a where a.id=? ";
		return (Address) getSession().createQuery(hql).setInteger(0, address_id)
				.uniqueResult();
		
	}

	@Override
	public void updateaddress(Address address) {
		// TODO Auto-generated method stub
		getSession().update(address);
	}
	
	
	
}
