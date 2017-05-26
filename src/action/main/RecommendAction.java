package action.main;

import java.util.List;

import javax.annotation.Resource;

import entity.Product;
import service.Productservice;

public class RecommendAction {
	@Resource(name="Productservice")
	private Productservice productservice;
	private List<Product> products;
	
	
	
	public String execute(){
		products = productservice.getproductreco();
		return "success";
	}



	public Productservice getProductservice() {
		return productservice;
	}



	public void setProductservice(Productservice productservice) {
		this.productservice = productservice;
	}



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
