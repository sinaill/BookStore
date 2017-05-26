package service;



import java.util.List;

import entity.Orderes;

public interface Orderservice {
	public void updateorder(Orderes orderes);
	public void addorder(Orderes orderes);
	
	public long ordernum();
	public List<Orderes> gettreatedorder(int page,int pagesize);
	
	public long suspensenum();
	public List<Orderes> getsuspenseorder(int page,int pagesize);
	public Orderes getorderbyid(int order_id);
	public List<Orderes> getorderbyuserid(int user_id,int page,int pagesize);
	public int getnumbyuserid(int user_id);
	
	public List<Orderes> recievedorder(int user_id,int page,int pagesize);
	public long getrecievenum(int user_id);
	
	public List<Orderes> deliveredorder(int page,int pagesize);
	public List<Orderes> deliveredorder(int user_id,int page,int pagesize);
	public long getdelivernum(int user_id);
	public long getdelivernum();
	
	public List<Orderes> untreatedorder(int user_id,int page,int pagesize);
	public long untreatedmun(int user_id);
}
