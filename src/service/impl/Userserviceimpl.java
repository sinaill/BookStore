package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.Userdao;
import entity.User;
import service.Userservice;
@Service("Userservice")
public class Userserviceimpl implements Userservice{
	@Resource(name="userDAO")
	private Userdao userdao;
	

	/* 
	 * 通过email获取用户
	 */
	@Override
	public User getuserbyemail(String email) {
		// TODO Auto-generated method stub
		return userdao.getuserbyemail(email);
	}
	
	
	
	@Override
	public User getuserbyid(int user_id) {
		// TODO Auto-generated method stub
		return userdao.getuserbyid(user_id);
	}



	/* 
	 * 添加用户
	 */
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userdao.adduser(user);
	}
	
	
	
	
	@Override
	public List<User> getbanuser(int page,int pagesize) {
		// TODO Auto-generated method stub
		return userdao.getbanuser(page,pagesize);
	}

	@Override
	public List<User> getnobanuser(int page,int pagesize) {
		// TODO Auto-generated method stub
		return userdao.getnobanuser(page,pagesize);
	}
	
	@Override
	public long nobanusernum() {
		// TODO Auto-generated method stub
		return userdao.nobanusernum();
	}

	@Override
	public long banusernum() {
		// TODO Auto-generated method stub
		return userdao.banusernum();
	}

	@Override
	public void updateuser(User user) {
		// TODO Auto-generated method stub
		userdao.updateuser(user);
	}

	@Override
	public void modify_verification(User user) {
		// TODO Auto-generated method stub
		userdao.updateuser(user);
	}

	public Userdao getUserdao() {
		return userdao;
	}

	public void setUserdao(Userdao userdao) {
		this.userdao = userdao;
	}


	
}
