package action.cart;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import entity.CartItem;

public class CartAction {
	
	private List<CartItem> cartitems;
	private float amount;
	
	@SuppressWarnings("unchecked")
	public String execute(){
		cartitems = (List<CartItem>) ActionContext.getContext().getSession().get("cart");
		if(cartitems!= null){
			for(CartItem cartitem:cartitems){
				amount+= (cartitem.getProduct().getPrice() * cartitem.getProduct_num());
			}
		}

		return "success";
	}


	public List<CartItem> getCartitems() {
		return cartitems;
	}


	public void setCartitems(List<CartItem> cartitems) {
		this.cartitems = cartitems;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
}
