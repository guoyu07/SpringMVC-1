package com.yngk.rest.support;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ѯ������
 * @author LiuXian
 *
 */
public class QueryResultObject 
{
	private int itemCount = 0;
	private List<?> itemList = null;
	private List<DicItems> dicItemList = new ArrayList<DicItems>();
	
	/**
	 * ���������
	 * @return
	 */
	public int getItemCount() 
	{
		return itemCount;
	}
	
	/**
	 * ���������
	 * @param itemCount ���������
	 */
	public void setItemCount(int itemCount) 
	{
		this.itemCount = itemCount;
	}
	
	/**
	 * ������
	 * @return ������
	 */
	public List<?> getItemList() 
	{
		return itemList;
	}
	
	/**
	 * ������
	 * @param itemList ������
	 */
	public void setItemList(List<?> itemList) 
	{
		this.itemList = itemList;
	}
	
	/**
	 * ��ȡ�ֵ��б�
	 * @return ��ȡ�ֵ��б�
	 */
	public List<DicItems> getDicItemList() 
	{
		return dicItemList;
	}
	
	/**
	 * �����ֵ�
	 * @param dicItems �ֵ���
	 * @return
	 */
	 public QueryResultObject addDicItems(DicItems dicItems)
	 {
		    this.dicItemList.add(dicItems);
		    return this;
	 }

	 /**
	  * �����ֵ��б�
	  * @param dicItems �ֵ��б�
	  * @return
	  */
	 public QueryResultObject addDicItems(List<DicItems> dicItems)
	 {
		    this.dicItemList.addAll(dicItems);
		    return this;
	 }
}
