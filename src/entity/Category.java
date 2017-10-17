package entity;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String description;
	private List<Category> categories;
	private int Category_productnum;
	private List<Product> products;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public int getCategory_productnum() {
		return Category_productnum;
	}
	public void setCategory_productnum(int category_productnum) {
		Category_productnum = category_productnum;
	}

	
}
