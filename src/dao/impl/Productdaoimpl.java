package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.ProductDao;
import entity.Product;
@Repository("productdao")
public class Productdaoimpl implements ProductDao {
	
	@Autowired
	private SessionFactory sessionfactory;

	public Session getSession(){
		return sessionfactory.getCurrentSession();
	}
	
	@Override
	public void addproduct(Product product) {
		// TODO Auto-generated method stub
		getSession().save(product);
	}

	@Override
	public void deleteproduct() {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateproduct(Product product) {
		// TODO Auto-generated method stub
		getSession().update(product);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getproductreco() {
		// TODO Auto-generated method stub
		String hql = "from Product order by rand()";
		return getSession().createQuery(hql).setFirstResult(1).setMaxResults(4).list();
	}

	@Override
	public Product getprobyid(int product_id) {
		// TODO Auto-generated method stub
		String hql = "from Product p where p.id=?";
		return (Product) getSession().createQuery(hql).setInteger(0, product_id).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getproductbyname(String product_name) {
		// TODO Auto-generated method stub
		String hql ="from Product p where p.name like:name";
		
		return  getSession().createQuery(hql).setString("name", "%"+product_name+"%").list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getproductbyname(String product_name, int page, int pagesize) {
		String hql ="from Product p where p.name like:name";
		Query query = getSession().createQuery(hql).setString("name", "%"+product_name+"%")
				.setFirstResult((page-1)*pagesize)
				.setMaxResults(pagesize);
		return query.list();
	}

	@Override
	public Product getproductbyisbn(String isbn) {
		// TODO Auto-generated method stub
		String hql = "from Product p where p.ISBN = ?";
		return (Product) getSession().createQuery(hql).setString(0, isbn).uniqueResult();
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getallproducts() {
		// TODO Auto-generated method stub
		String hql = "from Product p";
		return getSession().createQuery(hql).list();
	}

	@Override
	public long productnum() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Product p";
		return (long) getSession().createQuery(hql).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getallproducts(int page, int pagesize) {
		// TODO Auto-generated method stub
		String hql = "from Product p order by p.stock";
		return getSession().createQuery(hql).setFirstResult((page-1)*pagesize)
				.setMaxResults(pagesize).list();
	}

	@Override
	public void deleteproduct(int product_id) {
		// TODO Auto-generated method stub
		getSession().delete(this.getprobyid(product_id));
	}


	
	
	


	

}
