package dao;

import java.util.List;

import entity.Category;
import entity.Product;

public interface CategoryDao {
	public void addcategory(Category category);
	public Category findAll();
	public List<Category> findByParentId(int id);
	public Category findById(int id);
	public void updatecategory(Category category);
	public void deletecategory(Category category);
	public List<Product> getproducts(int page,int category_id,int pagesize);

}
