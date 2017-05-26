package action.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;

import entity.Category;
import entity.Product;
import service.Categoryservice;

/**
 * @author Administrator
 *
 */
public class Addproduct {
	@Resource(name="Categoryservice")
	private Categoryservice categoryservice;
	private Product product;
	private int category_id;
	private String fileFileName;
	private File file;
	
	
	
	
	public String execute() throws IOException{
		InputStream is = new FileInputStream(file);
		 OutputStream os = new FileOutputStream(new File("F:/eclipse workspace/BookStore/WebContent/productImages"
				 , fileFileName));
		
		 	byte[] buffer = new byte[500];


	        while(-1 != (is.read(buffer, 0, buffer.length)))
	        {
	            os.write(buffer);
	        }
	        
	        os.close();
	        is.close();
		 
		product.setPicture(fileFileName);
		Category category = categoryservice.findById(category_id);
		category.getProducts().add(product);
		categoryservice.updatecategory(category);
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



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public String getFileFileName() {
		return fileFileName;
	}



	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}



	public File getFile() {
		return file;
	}



	public void setFile(File file) {
		this.file = file;
	}
	
	
	
}
