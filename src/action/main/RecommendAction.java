package action.main;

import java.util.List;

import javax.annotation.Resource;

import entity.Product;
import redis.clients.jedis.Jedis;
import service.Productservice;
import util.RedisUtils;
import util.SerializeUtils;

public class RecommendAction {
	@Resource(name="Productservice")
	private Productservice productservice;
	private List<Product> products;
	
	
	
	@SuppressWarnings("unchecked")
	public String execute(){
		Jedis jedis = RedisUtils.getJedis();
		byte b[] = jedis.get("rec".getBytes());
		products = (List<Product>) SerializeUtils.unserializeList(b);
		
//		products = productservice.getproductreco();
		return "success";
	}



	public Productservice getProductservice() {
		return productservice;
	}



	public void setProductservice(Productservice productservice) {
		this.productservice = productservice;
	}



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
