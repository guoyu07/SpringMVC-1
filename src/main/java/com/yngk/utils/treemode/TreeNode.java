package com.yngk.utils.treemode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形结构基类
 * @author Jack
 *
 */
public abstract class TreeNode<T>
{
	private List<T> children = new ArrayList<T>();

	/**
	 * 子级节点集合
	 * @return
	 */
	public List<T> getChildren() 
	{
		return children;
	}	
}
