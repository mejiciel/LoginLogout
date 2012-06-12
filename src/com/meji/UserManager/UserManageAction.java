package com.meji.UserManager;

import com.opensymphony.xwork2.ActionSupport;

public class UserManageAction extends ActionSupport {
	private User user=new User();
	private String resultMessage;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

	public String Create() throws Exception{
		setResultMessage("Create Success");
		return "result";
	}
	
	public String Login() throws Exception{
		if(user.getName().equals("meji") && user.getPassword().equals("123456")) 
			setResultMessage("Login Success");
		else
			setResultMessage("Login Failed");
		return "result";
	}
	
	public String Forget() throws Exception{
		setResultMessage("Recover Success");
		return "result";
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
}
