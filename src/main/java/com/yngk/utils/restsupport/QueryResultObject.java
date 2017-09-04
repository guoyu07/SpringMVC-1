package com.yngk.utils.restsupport;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询结果对象
 * @author LiuXian
 *
 */
public class QueryResultObject 
{
	private long itemCount = 0;
	private List<?> itemList = null;
	private List<DicItems> dicItemList = new ArrayList<DicItems>();
	
	/**
	 * 查询集合总数量
	 * @return
	 */
	public long getItemCount() 
	{
		return itemCount;
	}
	
	/**
	 * 查询集合总数量
	 * @param itemCount 查询集合总数量
	 */
	public void setItemCount(long itemCount) 
	{
		this.itemCount = itemCount;
	}
	
	/**
	 * 查询集合
	 * @return 查询集合
	 */
	public List<?> getItemList() 
	{
		return itemList;
	}
	
	/**
	 * 查询集合
	 * @param itemList 查询集合
	 */
	public void setItemList(List<?> itemList) 
	{
		this.itemList = itemList;
	}
	
	/**
	 * 字典列表
	 * @return 字典列表
	 */
	public List<DicItems> getDicItemList() 
	{
		return dicItemList;
	}
	
	/**
	 * 字典列表
	 * @param dicItems 字典列表
	 * @return
	 */
	 public QueryResultObject addDicItems(DicItems dicItems)
	 {
		  this.dicItemList.add(dicItems);
		  return this;
	 }

	 /**
	  * 增加字典项
	  * @param dicItems 字典项
	  * @return
	  */
	 public QueryResultObject addDicItems(List<DicItems> dicItems)
	 {
		  this.dicItemList.addAll(dicItems);
		  return this;
	 }
}
