package com.yngk.usermanage.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: UserInfo
 */
public class UserInfo implements Serializable
{
    private static final long serialVersionUID = -6320060667384225257L;

    private String id;

    private String groupId;

    private String userLogin;

    private String pwd;
    
    private String safeEvalPwd;
    
    private String name;
    
    /**    
     * 身份证号
     */    
    private String privateIdentityId = "";

    private String email;

    private String officePhone;

    private String mobilePhone;

    private Date updateTime;

    private String dataState;

    private Integer showOrder;

    private Integer relationUserNum;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id == null ? null : id.trim();
    }

    public String getGroupId()
    {
        return groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getUserLogin()
    {
        return userLogin;
    }

    public void setUserLogin(String userLogin)
    {
        this.userLogin = userLogin == null ? null : userLogin.trim();
    }

    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email == null ? null : email.trim();
    }

    public String getOfficePhone()
    {
        return officePhone;
    }

    public void setOfficePhone(String officePhone)
    {
        this.officePhone = officePhone == null ? null : officePhone.trim();
    }

    public String getMobilePhone()
    {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone)
    {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    public String getDataState()
    {
        return dataState;
    }

    public void setDataState(String dataState)
    {
        this.dataState = dataState == null ? null : dataState.trim();
    }

    public Integer getShowOrder()
    {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder)
    {
        this.showOrder = showOrder;
    }

    public Integer getRelationUserNum()
    {
        return relationUserNum;
    }

    public void setRelationUserNum(Integer relationUserNum)
    {
        this.relationUserNum = relationUserNum;
    }

    public String getSafeEvalPwd()
    {
        return safeEvalPwd;
    }

    public void setSafeEvalPwd(String safeEvalPwd)
    {
        this.safeEvalPwd = safeEvalPwd == null ? null : safeEvalPwd.trim();
    }

	public String getPrivateIdentityId()
	{
		return privateIdentityId;
	}

	public void setPrivateIdentityId(String privateIdentityId)
	{
		this.privateIdentityId = privateIdentityId;
	}
}