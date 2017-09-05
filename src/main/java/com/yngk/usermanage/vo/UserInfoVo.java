package com.yngk.usermanage.vo;

import com.yngk.usermanage.model.UserInfo;

/**
 * 用户信息vo
 *
 */
public class UserInfoVo extends UserInfo
{
	private static final long serialVersionUID = 3623765362313398240L;
	
	private String secondPwd = "";

	/**
	 * 确认密码
	 * @return 确认密码
	 */
	public String getSecondPwd() 
	{
		return secondPwd;
	}

	/**
	 * 确认密码
	 * @param secondPwd 确认密码
	 */
	public void setSecondPwd(String secondPwd) 
	{
		this.secondPwd = secondPwd;
	}	
}
