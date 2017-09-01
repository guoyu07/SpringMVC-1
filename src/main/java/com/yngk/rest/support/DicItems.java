package com.yngk.rest.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * �ֵ伯�϶���
 * @author LiuXian
 *
 */
public class DicItems 
{
	private String name = "";
	private List<Map<String, String>> values = new ArrayList<Map<String, String>>();
	
	/**
	 * �ֵ����
	 * @return
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * �ֵ����
	 * @param name �ֵ����
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	
	/**
	 * �ֵ�ֵ�б�
	 * @return �ֵ�ֵ�б�
	 */
	public List<Map<String, String>> getValues() 
	{
		return values;
	}
	
	/**
	 * �ֵ�ֵ�б�
	 * @param values �ֵ�ֵ�б�
	 */
	public void setValues(List<Map<String, String>> values) 
	{
		this.values = values;
	}
	
	
}
