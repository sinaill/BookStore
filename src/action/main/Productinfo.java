package action.main;

import javax.annotation.Resource;

import entity.Product;
import service.Productservice;

public class Productinfo {
	@Resource(name="Productservice")
	private Productservice productservice;
	private int product_id;
	private Product product;
	
	public String execute(){
		product = productservice.getprobyid(product_id);
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
