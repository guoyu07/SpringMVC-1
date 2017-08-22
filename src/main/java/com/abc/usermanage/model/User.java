package com.abc.usermanage.model;

import java.util.Date;

public class User 
{
	private String userId = "";
	private String userName = "";
	private String password = "";
	private String userType = "";
	private String description = "";
	private Date registerTime = null;
	
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
	
	/**
	 * 注册时间
	 * @return 注册时间
	 */
	public Date getRegisterTime() 
	{
		return registerTime;
	}
	
	/**
	 * 注册时间
	 * @param registerTime 注册时间
	 */
	public void setRegisterTime(Date registerTime) 
	{
		this.registerTime = registerTime;
	}
}
