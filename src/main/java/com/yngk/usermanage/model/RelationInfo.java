package com.yngk.usermanage.model;

import java.io.Serializable;

/**
 * 
 * @ClassName: RelationInfo
 * @Description: TODO
 * @author: xuxiepeng
 * @date: 2014-10-16 下午2:18:28
 */
public class RelationInfo implements Serializable
{
    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */

    private static final long serialVersionUID = 5228660517887644389L;

    private String id;

    private String mainId;

    private String subId;

    private String type;

    private Integer showOrder;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id == null ? null : id.trim();
    }

    public String getMainId()
    {
        return mainId;
    }

    public void setMainId(String mainId)
    {
        this.mainId = mainId == null ? null : mainId.trim();
    }

    public String getSubId()
    {
        return subId;
    }

    public void setSubId(String subId)
    {
        this.subId = subId == null ? null : subId.trim();
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type == null ? null : type.trim();
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