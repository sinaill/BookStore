package action.category;


import javax.annotation.Resource;

import service.Categoryservice;

public class Addcategory {
	@Resource(name="Categoryservice")
	private Categoryservice categoryservice;
	private int category_id;
	private String category_name;
	private boolean addfirstcat;
	
	
	
	public String execute(){
		if(addfirstcat){
			categoryservice.addfirstcategory(category_name);
			
		}else {
			categoryservice.addsecondcategory(category_id, category_name);
		}
		
		return "success";
	}

	



	public boolean isAddfirstcat() {
		return addfirstcat;
	}





	public void setAddfirstcat(boolean addfirstcat) {
		this.addfirstcat = addfirstcat;
	}







	public String getCategory_name() {
		return category_name;
	}





	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}





	public int getCategory_id() {
		return category_id;
	}



	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}



	public Categoryservice getCategoryservice() {
		return categoryservice;
	}

	public void setCategoryservice(Categoryservice categoryservice) {
		this.categoryservice = categoryservice;
	}
	
	
}
