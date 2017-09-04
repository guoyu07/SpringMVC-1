package com.yngk.usermanage.model;

import java.io.Serializable;

/**
 * 用户关联列表显示使用pojo对象
 * @author liangjinquan
 *
 */
public class UserRelation implements Serializable
{
	private static final long serialVersionUID = 5807409071452014455L;

	public static final String RELATION_TYPE_USER = "用户";

	public static final String RELATION_TYPE_GROUP = "部门";

	private String id;

	private String relationType;

	private String relationName;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getRelationType()
	{
		return relationType;
	}

	public void setRelationType(String relationType)
	{
		this.relationType = relationType;
	}

	public String getRelationName()
	{
		return relationName;
	}

	public void setRelationName(String relationName)
	{
		this.relationName = relationName;
	}
}
