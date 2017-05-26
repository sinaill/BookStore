package service;

import java.util.List;

import entity.User;

public interface Userservice {
	public void addUser(User user);
	public User getuserbyemail(String email);
	public User getuserbyid(int user_id);
	public void modify_verification(User user);
	public void updateuser(User user);
	public List<User> getnobanuser(int page,int pagesize);
	public List<User> getbanuser(int page,int pagesize);
	public long nobanusernum();
	public long banusernum();
}
