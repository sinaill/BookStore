package action.main;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import entity.Product;
import service.Productservice;

public class Searchaction {
	@Resource(name="Productservice")
	private Productservice productservice;
	private String product_name;
	private List<Product> products;
	private int page=1;
	private int pagesize=4;
	private int totalPage;
	
	
	
	public String execute() throws UnsupportedEncodingException{

		int total = productservice.getproductbyname(product_name).size();

		
		if(total%pagesize == 0){
			totalPage = total/pagesize;
		}else{
			totalPage = total/pagesize + 1;	
		}
		
		products = productservice.getproductbyname(product_name, page, pagesize);
		return "success";
	}
	
	
	
	
	
	public int getPage() {
		return page;
	}





	public void setPage(int page) {
		this.page = page;
	}





	public int getPagesize() {
		return pagesize;
	}





	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}





	public int getTotalPage() {
		return totalPage;
	}





	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}





	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
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
