package com.yngk.usermanage.model;

import java.io.Serializable;
import java.util.Date;

import com.yngk.utils.treemode.TreeAble;

/**
 * 
 * @ClassName: GroupInfo
 */
public class GroupInfo implements Serializable, TreeAble
{
    private static final long serialVersionUID = 6133148299585157877L;

    private String id;

    private String parentId;

    private String name;

    private String description;

    private String type;

    private String code;

    private String area;

    private Date updateTime;

    private String dataState;

    private Integer showOrder;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id == null ? null : id.trim();
    }

    public String getParentId()
    {
        return parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId == null ? null : parentId.trim();
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

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area == null ? null : area.trim();
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
}