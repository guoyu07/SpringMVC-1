package com.abc.usermanage.model;


public class User 
{
	private String userId = "";
	private String userName = "";
	private String password = "";
	private String userType = "";
	private String description = "";
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}
	
	public String getUserName() 
	{
		return userName;
	}
	
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getUserType() 
	{
		return userType;
	}
	
	public void setUserType(String userType) 
	{
		this.userType = userType;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
}
