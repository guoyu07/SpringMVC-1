package com.yngk.utils.biz;

import java.util.List;
import java.util.Map;

/**
 * 基础biz接口
 * @author Jack
 *
 * @param <T>
 */
public abstract interface BaseBiz<T>
{
  public abstract int deleteByPrimaryKey(String paramString) throws RuntimeException;
  
  public abstract int insert(T paramT) throws RuntimeException;
  
  public abstract int insertSelective(T paramT) throws RuntimeException;
  
  public abstract T selectByPrimaryKey(String paramString) throws RuntimeException;
  
  public abstract int updateByPrimaryKeySelective(T paramT) throws RuntimeException;
  
  public abstract int updateByPrimaryKey(T paramT) throws RuntimeException;
  
  public abstract List<T> getList(Map<String, Object> paramMap, String paramString) throws RuntimeException;
  
  public abstract List<T> getList(String paramString) throws RuntimeException;
  
  public abstract List<T> getList() throws RuntimeException;
}

