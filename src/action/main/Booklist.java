package action.main;

import java.util.List;

import javax.annotation.Resource;

import entity.Category;
import entity.Product;
import service.Categoryservice;

public class Booklist {
	private int category_id;
	@Resource(name="Categoryservice")
	private Categoryservice categoryservice;

	private List<Product> products;
	private int page = 1;
	private int pagesize=4;
	private int totalPage;
	
	public String execute(){
		Category category = categoryservice.findById(category_id);
		int total = category.getCategory_productnum();
		if(total%pagesize == 0){
			totalPage = total/pagesize;
		}else{
			totalPage = total/pagesize + 1;
		}
		products = categoryservice.getproducts(page, category_id, pagesize);
		return "success";
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



	public int getTotalPage() {
		return totalPage;
	}



	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}




	
	
	
}
