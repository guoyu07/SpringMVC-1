package com.abc.rest.support;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询结果对象
 * @author LiuXian
 *
 */
public class QueryResultObject 
{
	private int itemCount = 0;
	private List<?> itemList = null;
	private List<DicItems> dicItemList = new ArrayList<DicItems>();
	
	/**
	 * 数据项总数
	 * @return
	 */
	public int getItemCount() 
	{
		return itemCount;
	}
	
	/**
	 * 数据项总数
	 * @param itemCount 数据项总数
	 */
	public void setItemCount(int itemCount) 
	{
		this.itemCount = itemCount;
	}
	
	/**
	 * 数据项集合
	 * @return 数据项集合
	 */
	public List<?> getItemList() 
	{
		return itemList;
	}
	
	/**
	 * 数据项集合
	 * @param itemList 数据项集合
	 */
	public void setItemList(List<?> itemList) 
	{
		this.itemList = itemList;
	}
	
	/**
	 * 获取字典列表
	 * @return 获取字典列表
	 */
	public List<DicItems> getDicItemList() 
	{
		return dicItemList;
	}
	
	/**
	 * 增加字典
	 * @param dicItems 字典项
	 * @return
	 */
	 public QueryResultObject addDicItems(DicItems dicItems)
	 {
		    this.dicItemList.add(dicItems);
		    return this;
	 }

	 /**
	  * 增加字典列表
	  * @param dicItems 字典列表
	  * @return
	  */
	 public QueryResultObject addDicItems(List<DicItems> dicItems)
	 {
		    this.dicItemList.addAll(dicItems);
		    return this;
	 }
}
