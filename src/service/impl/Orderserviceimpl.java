package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.Orderdao;
import entity.Orderes;
import service.Orderservice;
@Service("orderservice")
public class Orderserviceimpl implements Orderservice{
	@Resource(name="orderdao")
	private Orderdao orderdao;
	
	
	
	
	@Override
	public long ordernum() {
		// TODO Auto-generated method stub
		return orderdao.ordernum();
	}

	@Override
	public List<Orderes> gettreatedorder(int page,int pagesize) {
		// TODO Auto-generated method stub
		return orderdao.gettreatedorder(page,pagesize);
	}
	
	@Override
	public List<Orderes> getsuspenseorder(int page,int pagesize) {
		// TODO Auto-generated method stub
		return orderdao.getsuspenseorder(page,pagesize);
	}

	
	
	@Override
	public long suspensenum() {
		// TODO Auto-generated method stub
		return orderdao.suspensenum();
	}

	@Override
	public void updateorder(Orderes orderes) {
		// TODO Auto-generated method stub
		orderdao.update(orderes);
	}

	@Override
	public void addorder(Orderes orderes) {
		// TODO Auto-generated method stub
		orderdao.addorder(orderes);
	}
	
	

	@Override
	public Orderes getorderbyid(int order_id) {
		// TODO Auto-generated method stub
		return orderdao.getorderbyid(order_id);
	}
	
	
	

	@Override
	public long getrecievenum(int user_id) {
		// TODO Auto-generated method stub
		return orderdao.getrecievenum(user_id);
	}

	@Override
	public List<Orderes> recievedorder(int user_id,int page,int pagesize) {
		// TODO Auto-generated method stub
		return orderdao.recievedorder(user_id,page,pagesize);
	}
	
	
	
	@Override
	public List<Orderes> deliveredorder(int user_id, int page, int pagesize) {
		// TODO Auto-generated method stub
		return orderdao.deliveredorder(user_id, page, pagesize);
	}

	
	
	@Override
	public List<Orderes> deliveredorder(int page, int pagesize) {
		// TODO Auto-generated method stub
		return orderdao.deliveredorder(page, pagesize);
	}

	@Override
	public long getdelivernum(int user_id) {
		// TODO Auto-generated method stub
		return orderdao.getdelivernum(user_id);
	}
	
	
	
	@Override
	public long getdelivernum() {
		// TODO Auto-generated method stub
		return orderdao.getdelivernum();
	}

	@Override
	public List<Orderes> untreatedorder(int user_id, int page, int pagesize) {
		// TODO Auto-generated method stub
		return orderdao.untreatedorder(user_id, page, pagesize);
	}

	@Override
	public long untreatedmun(int user_id) {
		// TODO Auto-generated method stub
		return orderdao.untreatedmun(user_id);
	}

	@Override
	public int getnumbyuserid(int user_id) {
		// TODO Auto-generated method stub
		return orderdao.getnumbyuserid(user_id);
	}

	@Override
	public List<Orderes> getorderbyuserid(int user_id,int page,int pagesize) {
		// TODO Auto-generated method stub
		return orderdao.getorderbyuserid(user_id,page,pagesize);
	}

	public Orderdao getOrderdao() {
		return orderdao;
	}

	public void setOrderdao(Orderdao orderdao) {
		this.orderdao = orderdao;
	}
	
	
}
