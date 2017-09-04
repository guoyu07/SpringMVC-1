package com.yngk.utils.restsupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * 字典数据项
 * @author LiuXian
 *
 */
public class DicItems 
{
	private String name = "";
	private List<Map<String, String>> values = new ArrayList<Map<String, String>>();
	
	/**
	 * 字典项名称
	 * @return
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * 字典项名称
	 * @param name 字典项名称
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	
	/**
	 * 字典项值列表
	 * @return 字典项值列表
	 */
	public List<Map<String, String>> getValues() 
	{
		return values;
	}
	
	/**
	 * 字典项值列表
	 * @param values 字典项值列表
	 */
	public void setValues(List<Map<String, String>> values) 
	{
		this.values = values;
	}
}
