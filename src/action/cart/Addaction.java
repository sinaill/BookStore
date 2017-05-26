package action.cart;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;

import entity.CartItem;
import entity.Product;
import service.Productservice;

public class Addaction {
	@Resource(name="Productservice")
	private Productservice productservice;
	private int product_id;
	private boolean ok;
	
	
	@SuppressWarnings("unchecked")
	public String execute(){
		boolean exist = false;
		List<CartItem> cartitems = (List<CartItem>) ActionContext.getContext().getSession().get("cart");
		if(cartitems == null){
			cartitems = new ArrayList<CartItem>();
		}
		for(CartItem cartitem:cartitems){
			if(cartitem.getProduct().getId() == product_id){
				if(cartitem.getProduct().getStock() >= (cartitem.getProduct_num()+1)){
					cartitem.setProduct_num(cartitem.getProduct_num()+1);
					cartitem.setAmount(cartitem.getProduct().getPrice() * cartitem.getProduct_num());
					ok=true;
				}
				
				exist=true;
			}
		}
		if(!exist){
			Product product = productservice.getprobyid(product_id);
			if(product.getStock() > 0){
				CartItem cartitem1 = new CartItem(); 
				cartitem1.setProduct(product);
				cartitem1.setAmount(product.getPrice());
				cartitems.add(cartitem1);
				ok=true;
			}
	
		}
		
		ActionContext.getContext().getSession().put("cart", cartitems);
		
		return "success";
	}
	
	
	

	public boolean isOk() {
		return ok;
	}




	public void setOk(boolean ok) {
		this.ok = ok;
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
	
	
}
