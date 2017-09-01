package com.yngk.usermanage.util;

import java.util.List;

public class QueryResultObject 
{
	private List<?> itemList = null;
	private int totalItemCount = 0;
	
	public List<?> getItemList() {
		return itemList;
	}
	public void setItemList(List<?> itemList) {
		this.itemList = itemList;
	}
	public int getTotalItemCount() {
		return totalItemCount;
	}
	public void setTotalItemCount(int totalItemCount) {
		this.totalItemCount = totalItemCount;
	}
	
	
	
}
