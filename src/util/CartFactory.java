package util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;

import entity.CartItem;
import entity.CookieItem;
import service.Productservice;

public class CartFactory {
	public static List<CookieItem> getCookieItemFromCookieValue(String name,HttpServletRequest req) throws UnsupportedEncodingException{
		List<CookieItem> cookieItems = new ArrayList<CookieItem>();
		CookieItem temp = new CookieItem();
		String value = CookieUtil.findCookie(name, req);
		if(value != null){
			String arg[] = value.split("/");
			for(String s:arg){
				String [] a = s.split(",");
					
						temp.setProduct_id(Integer.parseInt(a[0]));
						temp.setProduct_num(Integer.parseInt(a[1]));
						temp.setAmount(Float.parseFloat(a[2]));
				
					cookieItems.add(temp);
			}
			return cookieItems;
		}
		return null;
	}
	
	public static String getCookieValueFromCartItem(List<CartItem> cartitems){
		StringBuffer sb = new StringBuffer();
		for(CartItem temp:cartitems){
			sb.append(temp.getProduct().getId()+","+temp.getProduct_num()+","
		+temp.getAmount());
			sb.append("/");
		}
		
		return sb.toString();
	}
	@SuppressWarnings("null")
	public static List<CartItem> CookieValueToCartItem(Productservice productService,List<CookieItem> cookieItems){
		@SuppressWarnings("unchecked")
		List<CartItem> cartItems = (List<CartItem>) ActionContext.getContext().getSession().get("cart");
		if(cookieItems == null && cartItems == null){
			cartItems = new ArrayList<CartItem>();
		}
		
		if(cartItems==null && cookieItems!=null){
			cartItems = new ArrayList<CartItem>();
			CartItem temp = new CartItem();
			for(CookieItem item:cookieItems){
				temp.setProduct(productService.getprobyid(item.getProduct_id()));
				temp.setProduct_num(item.getProduct_num());
				temp.setAmount(item.getAmount());
				cartItems.add(temp);
			}
			ActionContext.getContext().getSession().put("cart", cartItems);
		}

		return cartItems;
	}
}
