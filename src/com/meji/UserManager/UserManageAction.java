package com.meji.UserManager;

import java.util.Enumeration;
import java.util.Hashtable;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserManageAction extends ActionSupport implements ModelDriven<User> {
	private User user=new User();
	private static Hashtable<String,User> existingUser=new Hashtable<String,User>();
	
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
	public String createuser() throws Exception{
		if(!existingUser.containsKey(user.getName()))
		{
			User t=(User) user.clone();
			existingUser.put(t.getName(),t);
			setResultMessage(user.getName()+" "+user.getPassword()+" "+user.getEmail());
			return super.execute();
		}
		else
		{
			setResultMessage("User Existed");
			return super.execute();
		}
		
	}
	
	public String Login() throws Exception{
		if(existingUser.containsKey(user.getName()) &&
				user.getPassword().equals(existingUser.get(user.getName()).getPassword()))
		{
			
			setResultMessage("Login Success");
				
		}
		else
			setResultMessage("Login Failed");
		return "result";
		
	}
	
	public String Forget() throws Exception{
		
		Enumeration<User> userEnum=existingUser.elements();
		while(userEnum.hasMoreElements())
		{
			User t=userEnum.nextElement();
			if(t.getEmail().equals(user.getEmail()))
			{
				setResultMessage("Your password is "+t.getPassword());
				return "result";
			}
				
				
		}
		
		setResultMessage("Your email is not registered.");
		return "result";
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
