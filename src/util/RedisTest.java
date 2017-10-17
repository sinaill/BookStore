package util;

import java.util.HashMap;
import java.util.Map;

import entity.CookieItem;
import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;

public class RedisTest {
	public static void main(String[] args) {
		Jedis jedis = RedisUtils.getJedis();
		jedis.select(1);
		CookieItem c1 = new CookieItem();
		c1.setProduct_id(1);
		c1.setProduct_num(1);
		c1.setAmount(1000.0f);
		CookieItem c2 = new CookieItem();
		c2.setProduct_id(2);
		c2.setProduct_num(1);
		c2.setAmount(1000.0f);
		Map<String,String> cookie = new HashMap<String,String>();
		cookie.put(String.valueOf(c1.getProduct_id()), JSONObject.fromObject(c1).toString());
		cookie.put(String.valueOf(c2.getProduct_id()), JSONObject.fromObject(c2).toString());
		jedis.hmset("cookieItem", cookie);
//		Map<String,String> m = jedis.hgetAll("k");
//		for (Map.Entry<String, String> entry: m.entrySet()) {
//			System.out.println(entry.getKey() +" " +entry.getValue());
//		}
//		cookie  = jedis.hgetAll("cookieItem");
//		CookieItem c = (CookieItem) JSONObject.toBean(JSONObject.fromObject(cookie.get("2")), CookieItem.class);
//		System.out.println(c.getAmount()+" "+c.getProduct_num());
	}
}
