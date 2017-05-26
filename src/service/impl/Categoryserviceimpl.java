package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import dao.CategoryDao;
import entity.Category;
import entity.Product;
import service.Categoryservice;
@Service("Categoryservice")
public class Categoryserviceimpl implements Categoryservice{
	@Resource(name="categorydao")
	private CategoryDao categoryDao;
	

	
	
	@Override
	public void addfirstcategory(String category_name) {
		// TODO Auto-generated method stub
		Category category = categoryDao.findById(1);
		Category category1 = new Category();
		category1.setName(category_name);
		category.getCategories().add(category1);
		categoryDao.updatecategory(category);
	}




	@Override
	public void addsecondcategory(int category_id,String category_name) {
		// TODO Auto-generated method stub
		Category category = categoryDao.findById(category_id);
		Category category1 = new Category();
		category1.setName(category_name);
		category.getCategories().add(category1);
		categoryDao.updatecategory(category);
	}

	
	

	@Override
	public void deletefirstcategory(int category_id) {
		// TODO Auto-generated method stub
		Category category = categoryDao.findById(1);
		List<Category> categories = category.getCategories();
		for(int i = 0;i < categories.size();i++){
			Category category1 = categories.get(i);
			if(category1.getId() == category_id){
				categories.remove(category1);
			}
		}
		categoryDao.updatecategory(category);
	}




	@Override
	public void deletesecondcategory(int category_id,int secondcategory_id) {
		// TODO Auto-generated method stub
		Category category = categoryDao.findById(category_id);
		List<Category> categories = category.getCategories();
		for(int i = 0;i < categories.size();i++){
			Category category1 = categories.get(i);
			if(category1.getId() == secondcategory_id){	
				categories.remove(category1);
			}
		}
		categoryDao.updatecategory(category);
	}

	
	

	@Override
	public List<Product> getproducts(int page, int category_id, int pagesize) {
		// TODO Auto-generated method stub
		return categoryDao.getproducts(page, category_id, pagesize);
	}




	@Override
	public Category findById(int category_id) {
		// TODO Auto-generated method stub
		return categoryDao.findById(category_id);
	}




	@Override
	public void deletecategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao.deletecategory(category);
	}




	@Override
	public Category findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}




	@Override
	public void updatecategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao.updatecategory(category);
	}




	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	
	
	
}
