package com.yngk.usermanage.model;

import java.io.Serializable;

/**
 * 
 * @ClassName: ExtendPropertyInfo
 */
public class ExtendPropertyInfo implements Serializable
{
    private static final long serialVersionUID = -7842207687001175738L;

    private String id;

    private String type;

    private String name;

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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type == null ? null : type.trim();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name == null ? null : name.trim();
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