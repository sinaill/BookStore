package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.Userdao;
import entity.User;
@Repository("userDAO")
public class Userdaoimpl implements Userdao {
	@Autowired
	private SessionFactory sessionfactory;

	public Session getSession(){
		return sessionfactory.getCurrentSession();
	}
	
	@Override
	public void adduser(User user) {
		// TODO Auto-generated method stub
		getSession().save(user);
	}
	
	@Override
	public User getuserbyemail(String email) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.email=?";
		Query query = getSession().createQuery(hql);
		return (User) query.setString(0, email).uniqueResult();
		
	}
	
	
	
	@Override
	public User getuserbyid(int user_id) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.id=?";
		
		return (User) getSession().createQuery(hql).setInteger(0, user_id).uniqueResult();
	}

	@Override
	public void updateuser(User user) {
		// TODO Auto-generated method stub
		getSession().update(user);
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getnobanuser(int page,int pagesize) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.ban=?";
		return getSession().createQuery(hql).setString(0, "false")
				.setFirstResult((page-1)*pagesize)
				.setMaxResults(pagesize).list();
	}
	
	

	@Override
	public long nobanusernum() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from User u where u.ban=?";
		return (long) getSession().createQuery(hql).setString(0, "false").uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getbanuser(int page,int pagesize) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.ban!=?";
		return getSession().createQuery(hql).setString(0, "false")
				.setFirstResult((page-1)*pagesize)
				.setMaxResults(pagesize).list();
	}

	
	
	@Override
	public long banusernum() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from User u where u.ban!=?";
		return (long) getSession().createQuery(hql).setString(0, "false").uniqueResult();
	}

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}


}
