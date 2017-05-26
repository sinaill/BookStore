package dao;

import java.util.List;

import entity.Product;

public interface ProductDao {
	public void addproduct(Product product);
	public void deleteproduct();
	public void updateproduct(Product product);
	public List<Product> getproductreco();
	public Product getprobyid(int product_id);
	public Product getproductbyisbn(String isbn);
	public List<Product> getproductbyname(String product_name);
	public List<Product> getproductbyname(String product_name,int page,int pagesize);
	
	public long productnum();
	public List<Product> getallproducts();
	public List<Product> getallproducts(int page,int pagesize);
	
	public void deleteproduct(int product_id);
	
}
