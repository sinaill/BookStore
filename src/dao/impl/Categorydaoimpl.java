package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.CategoryDao;
import entity.Category;
import entity.Product;
@Repository("categorydao")
public class Categorydaoimpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionfactory;

	public Session getSession(){
		return sessionfactory.getCurrentSession();
	}
	
	@Override
	public void addcategory(Category category) {
		// TODO Auto-generated method stub
		getSession().save(category);
	}

	@Override
	public Category findAll() {
		// TODO Auto-generated method stub
		String hql = "from Category c where c.id=?";
		Query query = getSession().createQuery(hql).setInteger(0, 1);
		return  (Category) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findByParentId(int id) {
		// TODO Auto-generated method stub
		String hql = "from Category c where c.parentid=?";
		Query query = getSession().createQuery(hql).setInteger(0, id);
		return query.list();
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		String hql = "from Category c where c.id=?";
		Query query = getSession().createQuery(hql).setInteger(0, id);
		return (Category) query.uniqueResult();
	}

	@Override
	public void updatecategory(Category category) {
		// TODO Auto-generated method stub
		getSession().update(category);
	}

	@Override
	public void deletecategory(Category category) {
		// TODO Auto-generated method stub
		getSession().delete(category);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getproducts(int page, int category_id, int pagesize) {
		// TODO Auto-generated method stub
		String hql = "select c.products from Category c where c.id=?";
		Query query = getSession().createQuery(hql).setInteger(0, category_id);
		query.setFirstResult((page-1)*pagesize);
		query.setMaxResults(pagesize);
		
		return  query.list();
	}
	
	
}
