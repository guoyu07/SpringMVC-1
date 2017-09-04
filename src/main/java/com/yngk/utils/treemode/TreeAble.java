package com.yngk.utils.treemode;

/**
 * 树形结构对象接口
 * @author Jack
 *
 */
public abstract interface TreeAble
{
  /**
   * 主键
   */
  public abstract void setId(String paramString);
  
  /**
   * 主键
   * @return 主键
   */
  public abstract String getId();
  
  /**
   * 父级ID
   */
  public abstract void setParentId(String paramString);
  
  /**
   * 父级ID
   * @return
   */
  public abstract String getParentId();
}

