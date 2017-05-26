package service;

import java.util.List;

import entity.Category;
import entity.Product;

public interface Categoryservice {
	public void addfirstcategory(String category_name);
	public void addsecondcategory(int category_id,String category_name);
	public Category findAll();
	public void deletefirstcategory(int category_id);
	public void deletesecondcategory(int category_id,int secondcategory_id);
	public Category findById(int category_id);
	public void deletecategory(Category category);
	public void updatecategory(Category category);
	public List<Product> getproducts(int page, int category_id, int pagesize);
}
