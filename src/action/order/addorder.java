package action.order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;

import entity.Address;
import entity.CartItem;
import entity.Item;
import entity.Orderes;
import entity.Product;
import entity.User;
import service.Orderservice;
import service.Productservice;
import service.Userservice;

public class addorder {
	@Resource(name="Userservice")
	private Userservice userservice;
	@Resource(name="orderservice")
	private Orderservice orderservice;
	@Resource(name="Productservice")
	private Productservice productservice;
	private int address_id;
	private float amount;
	private Orderes orderes;
	private Address address;
	@SuppressWarnings("unchecked")
	public String execute(){
		
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		orderes = new Orderes();
		if(address_id != -1){
			List<Address> addresses = user.getAddress();
			for(Address address1: addresses){
				if(address1.getId() == address_id)
					address = address1;
			}
		}
		else{
			user.getAddress().add(address);
			userservice.updateuser(user);
		}

					
		List<CartItem> cartitems = (List<CartItem>) ActionContext.getContext().getSession().get("cart");
		List<Item> items = new ArrayList<Item>();
		
		Product product = null;
		for(CartItem cartitem:cartitems){
			product = cartitem.getProduct();
			amount += cartitem.getAmount();
			Item item = new Item();
			item.setProduct_id(product.getId());
			item.setPrice(product.getPrice());
			item.setProduct_name(product.getName());
			item.setProduct_pic(product.getPicture());
			item.setProduct_num(cartitem.getProduct_num());
			item.setAmount(cartitem.getProduct_num() * product.getPrice());
			items.add(item);
			product.setStock(product.getStock()-cartitem.getProduct_num());
			productservice.updateproduct(product);
		}
		cartitems.clear();
		orderes.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		orderes.setAmount(amount);
		orderes.setState("未受理");
		orderes.setAddress(address);
		
		orderes.setItems(items);
		user.getOrderes().add(orderes);
		userservice.updateuser(user);
		return "success";
	}



	public Orderservice getOrderservice() {
		return orderservice;
	}



	public void setOrderservice(Orderservice orderservice) {
		this.orderservice = orderservice;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public int getAddress_id() {
		return address_id;
	}



	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}



	public float getAmount() {
		return amount;
	}



	public void setAmount(float amount) {
		this.amount = amount;
	}



	public Orderes getOrderes() {
		return orderes;
	}



	public void setOrderes(Orderes orderes) {
		this.orderes = orderes;
	}



	public Userservice getUserservice() {
		return userservice;
	}



	public void setUserservice(Userservice userservice) {
		this.userservice = userservice;
	}



	public Productservice getProductservice() {
		return productservice;
	}



	public void setProductservice(Productservice productservice) {
		this.productservice = productservice;
	}
	
	
	
	
	
}
