package action.category;

import java.util.List;

import javax.annotation.Resource;

import entity.Category;
import service.Categoryservice;

public class SecondcategoryAction {
	@Resource(name="Categoryservice")
	private Categoryservice categoryservice;
	private int category_id;
	private List<Category> categories;
	
	
	public String execute(){
		
		categories = categoryservice.findById(category_id).getCategories();
		
		return "success";
	}
	
	
	
	public Categoryservice getCategoryservice() {
		return categoryservice;
	}
	public void setCategoryservice(Categoryservice categoryservice) {
		this.categoryservice = categoryservice;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}



	public List<Category> getCategories() {
		return categories;
	}



	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	

	

	
}
