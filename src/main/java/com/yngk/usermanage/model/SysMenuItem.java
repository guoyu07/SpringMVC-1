package com.yngk.usermanage.model;

import com.yngk.utils.treemode.TreeNode;

/**
 * 系统菜单项
 * @author Jack
 *
 */
public class SysMenuItem extends TreeNode<SysMenuItem>
{
	private String name = "";
//	private String component = ""; 
	private String path = "";	
	private String menuFile = "";	
	private String iconCls = "";
	private boolean leaf = true;
	
	
	/**
	 * 菜单名称
	 * @return 菜单名称
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * 菜单名称
	 * @param name 菜单名称
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	
	/**
	 * 请求路径
	 * @return
	 */
	public String getPath() 
	{
		return path;
	}
	
	/**
	 * 请求路径
	 * @param path
	 */
	public void setPath(String path) 
	{
		this.path = path;
	}
	
	/**
	 * 页面文件路径
	 * @return
	 */
	public String getMenuFile() 
	{
		return menuFile;
	}
	
	/**
	 * 页面文件路径
	 * @param menuFile
	 */
	public void setMenuFile(String menuFile) 
	{
		this.menuFile = menuFile;
//		// 构造组件属性
//		this.component = "require('" + this.menuFile + "')";
	}
	
	/**
	 * 菜单图标
	 * @return
	 */
	public String getIconCls() 
	{
		return iconCls;
	}
	
	/**
	 * 菜单图标
	 * @param iconCls
	 */
	public void setIconCls(String iconCls) 
	{
		this.iconCls = iconCls;
	}

	public boolean isLeaf() 
	{
		return leaf;
	}

	public void setLeaf(boolean leaf) 
	{
		this.leaf = leaf;
	}

//	public String getComponent() {
//		return component;
//	}
//
//	public void setComponent(String component) {
//		this.component = component;
//	}

//	/**
//	 * 菜单组件
//	 * @return
//	 */
//	public String getComponent() 
//	{
//		return component;
//	}
	
	
	
}
