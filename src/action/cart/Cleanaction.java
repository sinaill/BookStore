package action.cart;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import entity.CartItem;
import util.CookieUtil;

public class Cleanaction {
	private int product_id;


	public String execute(){
		List<CartItem> cartitems = new ArrayList<CartItem>();
		ActionContext.getContext().getSession().put("cart", cartitems);
		CookieUtil.deleteCookie("cart", ServletActionContext.getResponse());
		
		return "success";
	}
	
	
	
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
}
