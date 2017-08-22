package com.abc.usermanage.model;

import java.util.Date;

public class AccountInfo 
{
	private String accountId = "";
	private String groupId = "";
	private String loginName = "";
	private String password = "";
	private String name = "";
	private String email = "";
	private String officePhone = "";
	private String mobilePhone = "";
	private Date lastUpdateTime = null;
	private String dataState = "";
	private Date createTime = null;
	private int showOrder = 0;
	
	public String getAccountId() {
		return accountId;
	}
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public String getGroupId() {
		return groupId;
	}
	
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	public String getLoginName() {
		return loginName;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getOfficePhone() {
		return officePhone;
	}
	
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	
	public String getMobilePhone() {
		return mobilePhone;
	}
	
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	public String getDataState() {
		return dataState;
	}
	
	public void setDataState(String dataState) {
		this.dataState = dataState;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public int getShowOrder() {
		return showOrder;
	}
	
	public void setShowOrder(int showOrder) {
		this.showOrder = showOrder;
	}	
	
}
