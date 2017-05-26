package action.product;

import javax.annotation.Resource;

import entity.Category;
import entity.Product;
import service.Categoryservice;
import service.Productservice;

public class Deleteproduct {
	@Resource(name="Categoryservice")
	private Categoryservice categoryservice;
	@Resource(name="Productservice")
	private Productservice productservice;
	private int product_id;
	private boolean success;
	
	public String execute(){
		Product product = productservice.getprobyid(product_id);
		Category category = product.getCategory();
		category.getProducts().remove(product);
		product.setCategory(null);
		categoryservice.updatecategory(category);
		success = true;
		return "success";
	}

	public Categoryservice getCategoryservice() {
		return categoryservice;
	}

	public void setCategoryservice(Categoryservice categoryservice) {
		this.categoryservice = categoryservice;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Productservice getProductservice() {
		return productservice;
	}

	public void setProductservice(Productservice productservice) {
		this.productservice = productservice;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}


	
	
}
