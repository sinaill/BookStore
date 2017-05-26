package action.category;

import javax.annotation.Resource;

import service.Categoryservice;

public class Deletecategory {
	@Resource(name="Categoryservice")
	private Categoryservice categoryservice;
	private int category_id;
	private boolean deletefirstcat;
	private int secondcategory_id;
	public String execute(){
		if(deletefirstcat){
			categoryservice.deletefirstcategory(category_id);
		}else{
			categoryservice.deletesecondcategory(category_id,secondcategory_id);
		}
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



	public boolean isDeletefirstcat() {
		return deletefirstcat;
	}



	public void setDeletefirstcat(boolean deletefirstcat) {
		this.deletefirstcat = deletefirstcat;
	}



	public int getSecondcategory_id() {
		return secondcategory_id;
	}



	public void setSecondcategory_id(int secondcategory_id) {
		this.secondcategory_id = secondcategory_id;
	}


	
	
	
}
