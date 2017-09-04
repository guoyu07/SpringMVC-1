package com.yngk.usermanage.model;

import java.io.Serializable;

/**
 * 
 * @ClassName: UserExtendRelationInfo
 */
public class UserExtendRelationInfo implements Serializable
{
    /**
     * @fieldName: serialVersionUID
     * @fieldType: long
     * @Description: TODO
     */
    private static final long serialVersionUID = -1786521566980745524L;

    private String id;

    private String mainId;

    private String exproId;

    private String name;

    private String value;

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

    public String getExproId()
    {
        return exproId;
    }

    public void setExproId(String exproId)
    {
        this.exproId = exproId == null ? null : exproId.trim();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name == null ? null : name.trim();
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value == null ? null : value.trim();
    }
}