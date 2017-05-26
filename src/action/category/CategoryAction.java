package action.category;

import java.util.List;

import javax.annotation.Resource;

import entity.Category;
import service.Categoryservice;

public class CategoryAction {
	@Resource(name="Categoryservice")
	private Categoryservice categoryservice;
	private List<Category> categories;
	private boolean json=false;
	
	
	public String execute(){
		
		categories = categoryservice.findAll().getCategories();
		if(json==false){
			return "success";
		}else
			return "json";
		
		
	}
	
	

	
	






	public boolean isJson() {
		return json;
	}




	public void setJson(boolean json) {
		this.json = json;
	}




	public List<Category> getCategories() {
		return categories;
	}



	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}







	public Categoryservice getCategoryservice() {
		return categoryservice;
	}






	public void setCategoryservice(Categoryservice categoryservice) {
		this.categoryservice = categoryservice;
	}

	


	
}
