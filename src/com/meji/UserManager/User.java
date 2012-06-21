package com.meji.UserManager;

public class User extends Object implements Cloneable{
	
	private String name;
	private String password;
	private String email;
	private String confirmpassword;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		User t=(User) super.clone();
		t.setName(name);
		t.setPassword(password);
		t.setEmail(email);
		return t;
	}
	
	
}
