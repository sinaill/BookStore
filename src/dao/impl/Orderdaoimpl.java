package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.Orderdao;
import entity.Orderes;
@Repository("orderdao")
public class Orderdaoimpl implements Orderdao {
	
	
	@Autowired
	private SessionFactory sessionfactory;

	public Session getSession(){
		return sessionfactory.getCurrentSession();
	}
	
	@Override
	public void addorder(Orderes orderes) {
		// TODO Auto-generated method stub
		getSession().save(orderes);
	}

	@Override
	public void update(Orderes orderes) {
		// TODO Auto-generated method stub
		getSession().update(orderes);
	}

	
	
	@Override
	public long ordernum() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Orderes";
		return (long) getSession().createQuery(hql).uniqueResult();
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Orderes> gettreatedorder(int page,int pagesize) {
		// TODO Auto-generated method stub
		String hql = "from Orderes o order by o.id desc";
		return getSession().createQuery(hql).setFirstResult((page-1)*pagesize)
				.setMaxResults(pagesize).list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orderes> getsuspenseorder(int page,int pagesize) {
		// TODO Auto-generated method stub
		String hql = "from Orderes o where o.state=? order by o.id desc";
		return getSession().createQuery(hql).setString(0, "未受理")
				.setFirstResult((page-1)*pagesize)
				.setMaxResults(pagesize).list();
				
		
	}
	
	
	
	@Override
	public long suspensenum() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Orderes o where o.state=? order by o.id desc";
		return (long) getSession().createQuery(hql).setString(0, "未受理").uniqueResult();
	}

	@Override
	public Orderes getorderbyid(int order_id) {
		// TODO Auto-generated method stub
		String hql = "from Orderes o where o.id=?";
		return (Orderes) getSession().createQuery(hql).setInteger(0, order_id).uniqueResult();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orderes> getorderbyuserid(int user_id,int page,int pagesize) {
		// TODO Auto-generated method stub
		String hql = "select u.orderes from User u where u.id=?";
		return getSession().createQuery(hql).setInteger(0, user_id)
				.setFirstResult((page-1)*pagesize)
				.setMaxResults(pagesize).list();
		
	}

	@Override
	public int getnumbyuserid(int user_id) {
		// TODO Auto-generated method stub
		//String hql = "select COUNT(*) from (select u.orderes from User u where u.id=?)";
		String hql = "select u.orderes from User u where u.id=?";
		return (int) getSession().createQuery(hql).setInteger(0, user_id).list().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orderes> recievedorder(int user_id,int page,int pagesize) {
		// TODO Auto-generated method stub
		String hql = "from Orderes o where o.userid=? and o.state=? order by o.id desc";
		return getSession().createQuery(hql).setInteger(0, user_id)
				.setString(1, "已收货").setFirstResult((page-1)*pagesize)
				.setMaxResults(pagesize).list();
	}

	@Override
	public long getrecievenum(int user_id) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Orderes o where o.state=? and o.userid=?";
		return (long) getSession().createQuery(hql).setString(0, "已收货").setInteger(1, user_id)
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orderes> deliveredorder(int user_id, int page, int pagesize) {
		// TODO Auto-generated method stub
		String hql = "from Orderes o where o.userid=? and o.state=? order by o.id desc";
		return getSession().createQuery(hql).setInteger(0, user_id)
				.setString(1, "已发货").setFirstResult((page-1)*pagesize)
				.setMaxResults(pagesize).list();
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Orderes> deliveredorder(int page, int pagesize) {
		String hql = "from Orderes o where o.state=? order by o.id desc";
		return getSession().createQuery(hql).setString(0, "已发货").setFirstResult((page-1)*pagesize)
				.setMaxResults(pagesize).list();
	}

	@Override
	public long getdelivernum(int user_id) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Orderes o where o.state=? and o.userid=?";
		return (long) getSession().createQuery(hql).setString(0, "已发货").setInteger(1, user_id)
				.uniqueResult();
	}
	
	
	
	@Override
	public long getdelivernum() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Orderes o where o.state=?";
		return (long) getSession().createQuery(hql).setString(0, "已发货")
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orderes> untreatedorder(int user_id, int page, int pagesize) {
		// TODO Auto-generated method stub
		String hql = "from Orderes o where o.userid=? and o.state=? order by o.id desc";
		return getSession().createQuery(hql).setInteger(0, user_id)
				.setString(1, "未受理").setFirstResult((page-1)*pagesize)
				.setMaxResults(pagesize).list();
	}

	@Override
	public long untreatedmun(int user_id) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Orderes o where o.state=? and o.userid=? order by o.id desc";
		return (long) getSession().createQuery(hql).setString(0, "未受理").setInteger(1, user_id)
				.uniqueResult();
	}
	
	
}
