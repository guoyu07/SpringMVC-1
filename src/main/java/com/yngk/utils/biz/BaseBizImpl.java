package com.yngk.utils.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yngk.utils.dao.BaseDao;

/**
 * 基础biz接口实现
 * @author Jack
 *
 * @param <T>
 */
public abstract class BaseBizImpl<T> implements BaseBiz<T>
{
	public abstract BaseDao<T> getDao();
	
	public int deleteByPrimaryKey(String id) throws RuntimeException
	{
	  return getDao().deleteByPrimaryKey(id);
	}
	
	public int insert(T record) throws RuntimeException
	{
	  return getDao().insert(record);
	}
	
	public int insertSelective(T record) throws RuntimeException
	{
	  return getDao().insertSelective(record);
	}
	
	public T selectByPrimaryKey(String id) throws RuntimeException
	{
	  return getDao().selectByPrimaryKey(id);
	}
	
	public int updateByPrimaryKeySelective(T record) throws RuntimeException
	{
	  return getDao().updateByPrimaryKeySelective(record);
	}
	
	public int updateByPrimaryKey(T record) throws RuntimeException
	{
	  return getDao().updateByPrimaryKey(record);
	}
	
	public List<T> getList(Map<String, Object> map, String order) throws RuntimeException
	{
	  if (order != null)
	  {
	    if (map == null) {
	      map = new HashMap<String, Object>();
	    }
	    map.put("order", order);
	  }
	  return getDao().getPage(map);
	}
	
	public List<T> getList(String order) throws RuntimeException
	{
	  return getList(null, order);
	}
	
	public List<T> getList() throws RuntimeException
	{
	  return getList(null);
	}
}
