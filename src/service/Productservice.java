package service;

import java.util.List;

import entity.Product;

public interface Productservice {
	public void addproduct(Product product);
	public void updateproduct(Product product);
	public List<Product> getproductreco();
	public Product getprobyid(int product_id);
	public int product_num(int product_id);
	public List<Product> getproductbyname(String product_name);
	public List<Product> getproductbyname(String product_name,int page,int pagesize);
	public Product getproductbyisbn(String isbn);
	
	public long productnum();
	public List<Product> getallproducts();
	public List<Product> getallproducts(int page,int pagesize);
	
	public void deleteproduct(int product_id);
}
