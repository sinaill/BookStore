package action.cart;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import entity.CartItem;

public class Deleteaction {
	private int product_id;


	@SuppressWarnings("unchecked")
	public String execute(){
		CartItem temp = null;
		List<CartItem> cartitems = (List<CartItem>) ActionContext.getContext().getSession().get("cart");
		for(CartItem cartitem:cartitems){
			if(cartitem.getProduct().getId() == product_id){
				temp = cartitem;
				
			}
		}
		cartitems.remove(temp);
		return "success";
	}
	
	
	
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	
}
