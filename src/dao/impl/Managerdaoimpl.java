package dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.ManagerDao;
import entity.Manager;
@Repository("managerdao")
public class Managerdaoimpl implements ManagerDao {

	@Autowired
	private SessionFactory sessionfactory;

	public Session getSession(){
		return sessionfactory.getCurrentSession();
	}
	
	@Override
	public void updatamanager(Manager manager) {
		// TODO Auto-generated method stub
		getSession().update(manager);
	}

	@Override
	public Manager getbyname(String name) {
		// TODO Auto-generated method stub
		String hql = "from Manager m where m.name=?";
		return (Manager) getSession().createQuery(hql).setString(0, name).uniqueResult();
		
	}
	
	
}
