package action.cart;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import entity.CartItem;
import util.CartFactory;
import util.CookieUtil;

public class Deleteaction {
	private int product_id;


	@SuppressWarnings("unchecked")
	public String execute() throws UnsupportedEncodingException{
		CartItem temp = null;
		List<CartItem> cartitems = (List<CartItem>) ActionContext.getContext().getSession().get("cart");
		for(CartItem cartitem:cartitems){
			if(cartitem.getProduct().getId() == product_id){
				temp = cartitem;
				
			}
		}
		cartitems.remove(temp);
		CookieUtil.addCookie("cart", CartFactory.getCookieValueFromCartItem(cartitems), 
				ServletActionContext.getResponse());
		return "success";
	}
	
	
	
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	
}
