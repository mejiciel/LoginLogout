package com.meji.UserManager;

import java.util.Enumeration;
import java.util.Hashtable;

import org.apache.struts2.ServletActionContext;

import com.meji.UserManagement.UserManager;
import com.meji.UserManagement.UserProfile;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserManageAction extends ActionSupport implements ModelDriven<UserProfile> {
	private UserProfile user=new UserProfile();
	
	private UserProfile currentUser;
	public UserProfile getCurrentUser() {
		return currentUser;
	}

	private String resultMessage;
	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
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
		UserManager umgr=new UserManager();
		if(!umgr.CheckUserExistByName(user.getName()))
		{
			umgr.CreateUser(user);
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
		UserManager umgr=new UserManager();
		if(umgr.ValidateUser(user))
		{
			ServletActionContext.getContext().getSession().put("login", true);
			ServletActionContext.getContext().getSession().put("currentuser", user);
			setResultMessage("Login Success");
			return "home";
		}
		else
			setResultMessage("Login Failed");
		return "result";
		
	}
	public String Logout() throws Exception{
		Object o=ServletActionContext.getContext().getSession().get("login");
		if(o!=null && (boolean)o==true)
		{
			ServletActionContext.getContext().getSession().remove("login");
			ServletActionContext.getContext().getSession().remove("currentuser");
			setResultMessage("Logged out");
		}
		else
		{
			setResultMessage("Not Logged in");
		}
		return "result";
	}
	
	public String Forget() throws Exception{
		
		UserManager umgr=new UserManager();
		if(umgr.CheckUserExistByEmail(user.getEmail()))
		{
			
			setResultMessage("Your password is "+umgr.GetPasswordByEmail(user.getEmail()));
			return "result";
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
	public UserProfile getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
