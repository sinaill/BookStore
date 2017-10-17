package action.cart;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import entity.CartItem;
import service.Productservice;
import util.CartFactory;

public class CartAction {
	@Resource(name="Productservice")
	private Productservice productservice;
	private List<CartItem> cartitems;
	private float amount;
	
	@SuppressWarnings("unchecked")
	public String execute() throws UnsupportedEncodingException{
//		cartitems = (List<CartItem>) ActionContext.getContext().getSession().get("cart");
		cartitems = CartFactory.CookieValueToCartItem(productservice, 
				CartFactory.getCookieItemFromCookieValue("cart", ServletActionContext.getRequest()));
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


	/**
	 * @return the productservice
	 */
	public Productservice getProductservice() {
		return productservice;
	}


	/**
	 * @param productservice the productservice to set
	 */
	public void setProductservice(Productservice productservice) {
		this.productservice = productservice;
	}
	
	
}
