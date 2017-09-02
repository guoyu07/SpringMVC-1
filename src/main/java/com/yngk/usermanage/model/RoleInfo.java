package com.yngk.usermanage.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: RoleInfo
 * @Description: TODO
 * @author: xuxiepeng
 * @date: 2014-10-16 下午2:18:39
 */
public class RoleInfo implements Serializable
{
    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */
    private static final long serialVersionUID = -1526034379550884345L;

    private String id;

    private String name;

    private String description;

    private String type;

    private String code;

    private Date updateTime;

    private String dataState;

    private Integer showOrder;

    private String domain;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id == null ? null : id.trim();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description == null ? null : description.trim();
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type == null ? null : type.trim();
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code == null ? null : code.trim();
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

    public String getDomain()
    {
        return domain;
    }

    public void setDomain(String domain)
    {
        this.domain = domain == null ? null : domain.trim();
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof RoleInfo)
        {
            return this.id.equals(((RoleInfo) obj).getId());
        }
        return super.equals(obj);
    }

}