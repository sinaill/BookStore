package action.product;

import javax.annotation.Resource;

import entity.Product;
import service.Productservice;

public class GetprobyISBN {
	@Resource(name="Productservice")
	private Productservice productservice;
	private String ISBN;
	private  Product product;
	
	
	
	public String execute(){
		product = productservice.getproductbyisbn(ISBN);
		return "success";
	}

	
	
	public Productservice getProductservice() {
		return productservice;
	}

	public void setProductservice(Productservice productservice) {
		this.productservice = productservice;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
