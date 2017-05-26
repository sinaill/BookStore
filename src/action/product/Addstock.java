package action.product;

import javax.annotation.Resource;

import entity.Product;
import service.Productservice;

public class Addstock {
	@Resource(name="Productservice")
	private Productservice productservice;
	private int product_id;
	private int num;
	private boolean success;
	
	public String execute(){
		Product product = productservice.getprobyid(product_id);
		product.setStock(product.getStock()+num);
		productservice.updateproduct(product);
		success = true;
		return "success";
	}

	public Productservice getProductservice() {
		return productservice;
	}

	public void setProductservice(Productservice productservice) {
		this.productservice = productservice;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}
