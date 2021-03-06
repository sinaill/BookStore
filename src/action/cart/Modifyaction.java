package action.cart;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import entity.CartItem;
import util.CartFactory;
import util.CookieUtil;

public class Modifyaction {
	private int product_id;
	private int product_num;

	@SuppressWarnings("unchecked")
	public String execute() throws UnsupportedEncodingException{
		List<CartItem> cartitems = (List<CartItem>) ActionContext.getContext().getSession().get("cart");
		for(CartItem cartitem:cartitems){
			if(cartitem.getProduct().getId() == product_id){
				if(cartitem.getProduct().getStock() >= product_num){
					cartitem.setProduct_num(product_num);
					cartitem.setAmount(product_num * cartitem.getProduct().getPrice());
				}else{
					cartitem.setProduct_num(cartitem.getProduct().getStock());
				}
				
			}
		}
		CookieUtil.addCookie("cart", CartFactory.getCookieValueFromCartItem(cartitems), 
				ServletActionContext.getResponse());
		return "success";
	}
	
	
	
	public int getProduct_num() {
		return product_num;
	}



	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}



	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
}
