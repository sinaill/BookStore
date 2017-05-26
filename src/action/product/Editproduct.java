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
import service.Productservice;

/**
 * @author Administrator
 *
 */
public class Editproduct {
	@Resource(name="Productservice")
	private Productservice productservice;
	@Resource(name="Categoryservice")
	private Categoryservice categoryservice;
	private Product product;
	private String fileFileName;
	private File file;
	private int category_id;
	
	
	
	public String execute() throws IOException{
		if(file != null){
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
		}
		Product temp = productservice.getprobyid(product.getId());
		product.setCategory(temp.getCategory());
		if(temp.getCategory().getId() != category_id){
			Category category = categoryservice.findById(category_id);
			product.setCategory(category);
		}

		productservice.updateproduct(product);
		
		return "success";
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








	public Categoryservice getCategoryservice() {
		return categoryservice;
	}





	public void setCategoryservice(Categoryservice categoryservice) {
		this.categoryservice = categoryservice;
	}





	public int getCategory_id() {
		return category_id;
	}





	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}





	public Productservice getProductservice() {
		return productservice;
	}





	public void setProductservice(Productservice productservice) {
		this.productservice = productservice;
	}
	
	
	
}
