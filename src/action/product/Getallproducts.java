package action.product;

import java.util.List;

import javax.annotation.Resource;

import entity.Product;
import service.Productservice;

public class Getallproducts {
	@Resource(name="Productservice")
	private Productservice productservice;
	private List<Product> products;
	private int page = 1;
	private int pagesize=10;
	private int totalPage;
	
	public String execute(){
		int total = (int) productservice.productnum();
		if(total%pagesize == 0){
			totalPage = total/pagesize;
		}else{
			totalPage = total/pagesize + 1;
		}
		products = productservice.getallproducts(page,pagesize);
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
	
	
	
}
