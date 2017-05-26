package entity;


import java.util.List;

public class User {
	private int id;
	private String nickname;
	private String password;
	private String email;
	private String email_verificationCode;
	private boolean is_verify;
	private boolean ban;
	private String last_logintime;
	private List<Address> address;
	private List<Orderes> orderes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}


	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_verificationCode() {
		return email_verificationCode;
	}
	public void setEmail_verificationCode(String email_verificationCode) {
		this.email_verificationCode = email_verificationCode;
	}
	public boolean isIs_verify() {
		return is_verify;
	}
	public void setIs_verify(boolean is_verify) {
		this.is_verify = is_verify;
	}
	public String getLast_logintime() {
		return last_logintime;
	}
	public void setLast_logintime(String last_logintime) {
		this.last_logintime = last_logintime;
	}
	public List<Orderes> getOrderes() {
		return orderes;
	}
	public void setOrderes(List<Orderes> orderes) {
		this.orderes = orderes;
	}
	public boolean isBan() {
		return ban;
	}
	public void setBan(boolean ban) {
		this.ban = ban;
	}
	
	

	
}
