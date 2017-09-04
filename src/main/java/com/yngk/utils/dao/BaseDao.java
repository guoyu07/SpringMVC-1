package com.yngk.utils.dao;

import java.util.List;
import java.util.Map;

/**
 * 数据操作基础接口
 * @author Jack
 *
 * @param <T>
 */
public abstract interface BaseDao<T>
{
  /**
   * 通过主键删除对象
   * @param paramString 主键编号
   * @return
   * @throws RuntimeException
   */
  public abstract int deleteByPrimaryKey(String paramString) throws RuntimeException;
  
  /**
   * 插入对象
   * @param paramT 对象信息
   * @return
   * @throws RuntimeException
   */
  public abstract int insert(T paramT) throws RuntimeException;
  
  /**
   * 插入选择的对象信息
   * @param paramT 对象信息
   * @return
   * @throws RuntimeException
   */
  public abstract int insertSelective(T paramT) throws RuntimeException;
  
  /**
   * 通过主键查询单条对象
   * @param paramString 主键编号
   * @return
   * @throws RuntimeException
   */
  public abstract T selectByPrimaryKey(String paramString) throws RuntimeException;
  
  /**
   * 通过主键更新选择的对象信息
   * @param paramT 对象信息
   * @return
   * @throws RuntimeException
   */
  public abstract int updateByPrimaryKeySelective(T paramT) throws RuntimeException;
  
  /**
   * 通过主键更新对象信息
   * @param paramT 对象信息
   * @return
   * @throws RuntimeException
   */
  public abstract int updateByPrimaryKey(T paramT) throws RuntimeException;
  
  /**
   * 分页查询数据
   * @param paramMap 查询条件集合
   * @return
   * @throws RuntimeException
   */
  public abstract List<T> getPage(Map<String, Object> paramMap) throws RuntimeException;
}

