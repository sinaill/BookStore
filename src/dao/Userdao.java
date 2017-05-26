package dao;

import java.util.List;

import entity.User;

public interface Userdao {
	public void adduser(User user);
	public User getuserbyemail(String email);
	public User getuserbyid(int user_id);
	public void updateuser(User user);
	public List<User> getnobanuser(int page,int pagesize);
	public List<User> getbanuser(int page,int pagesize);
	public long nobanusernum();
	public long banusernum();
}
