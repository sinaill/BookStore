package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.ProductDao;
import entity.Product;
import service.Productservice;
@Service("Productservice")
public class Productserviceimpl implements Productservice {
	@Resource(name="productdao")
	private ProductDao productDao;
	
	
	
	@Override
	public void addproduct(Product product) {
		// TODO Auto-generated method stub
		productDao.addproduct(product);
	}

	@Override
	public void updateproduct(Product product) {
		// TODO Auto-generated method stub
		productDao.updateproduct(product);
	}

	
	
	
	



	@Override
	public void deleteproduct(int product_id) {
		// TODO Auto-generated method stub
		productDao.deleteproduct(product_id);
	}

	@Override
	public long productnum() {
		// TODO Auto-generated method stub
		return productDao.productnum();
	}

	@Override
	public List<Product> getallproducts(int page, int pagesize) {
		// TODO Auto-generated method stub
		
		return productDao.getallproducts(page, pagesize);
	}

	@Override
	public List<Product> getallproducts() {
		// TODO Auto-generated method stub
		return productDao.getallproducts();
	}

	@Override
	public Product getproductbyisbn(String isbn) {
		// TODO Auto-generated method stub
		return productDao.getproductbyisbn(isbn);
	}

	@Override
	public List<Product> getproductbyname(String product_name, int page, int pagesize) {
		return productDao.getproductbyname(product_name, page, pagesize); 
	}

	@Override
	public List<Product> getproductbyname(String product_name) {
		// TODO Auto-generated method stub
		return productDao.getproductbyname(product_name);
	}

	@Override
	public int product_num(int product_id) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public Product getprobyid(int product_id) {
		// TODO Auto-generated method stub
		return productDao.getprobyid(product_id);
	}

	@Override
	public List<Product> getproductreco() {
		// TODO Auto-generated method stub
		return productDao.getproductreco();
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
}
