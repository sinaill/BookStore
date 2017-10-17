package action.cart;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import entity.CartItem;
import entity.Product;
import service.Productservice;
import util.CartFactory;
import util.CookieUtil;

public class Addaction {
	@Resource(name="Productservice")
	private Productservice productservice;
	private int product_id;
	private boolean ok;
	
	
	@SuppressWarnings("unchecked")
	public String execute() throws UnsupportedEncodingException{
		boolean exist = false;
//		List<CartItem> cartitems = (List<CartItem>) ActionContext.getContext().getSession().get("cart");
		List<CartItem> cartitems = CartFactory.CookieValueToCartItem(productservice, 
				CartFactory.getCookieItemFromCookieValue("cart", ServletActionContext.getRequest()));
		
		
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
		CookieUtil.addCookie("cart", CartFactory.getCookieValueFromCartItem(cartitems), 
				ServletActionContext.getResponse());
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
