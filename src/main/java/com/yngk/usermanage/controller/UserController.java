package com.yngk.usermanage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.booway.techcomp.commonfunction.ConvertUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yngk.usermanage.biz.UserBiz;
import com.yngk.usermanage.model.SysMenuItem;
import com.yngk.usermanage.model.UserInfo;
import com.yngk.usermanage.vo.UserInfoVo;
import com.yngk.utils.restsupport.QueryResultObject;

/**
 * 用户控制类
 * @author Jack
 *
 */
@Controller
@RequestMapping("/User")
public class UserController 
{
	@Autowired
	private UserBiz userBiz;

	@RequestMapping(value="/queryUserList")
	@ResponseBody
	public QueryResultObject queryUserList(@RequestBody UserInfoVo queryUserInfo,@RequestParam int pageIndex,@RequestParam int pageSize) throws Exception 
	{
//		int pageSize = Integer.parseInt(MapParam.get("pageSize").toString());
//		int pageIndex = Integer.parseInt(MapParam.get("pageIndex").toString());
		
//		UserInfo queryInfo = new UserInfo();
		QueryResultObject queryResultObj = new QueryResultObject();
		// 分页查询
		 PageHelper.startPage(pageIndex, pageSize);
		List<UserInfo> lstUserInfo  = this.userBiz.selectUserByQueryCriteria(queryUserInfo);
		PageInfo<UserInfo> userPageInfo = new PageInfo<>(lstUserInfo);
		queryResultObj.setItemList(userPageInfo.getList());
		queryResultObj.setItemCount(userPageInfo.getTotal());
		
		return queryResultObj;
	}
	
	@RequestMapping(value="/createUser")
	@ResponseBody
	public QueryResultObject createUser(@RequestBody UserInfoVo createUserInfo) throws Exception
	{
		QueryResultObject result = new QueryResultObject();
		try 
		{
			// 创建帐户
			this.userBiz.addUserInfo(createUserInfo);
			
			return result;
		} 
		catch (Exception e) 
		{
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			
			return result;
		}
	}
	
	/**
	 * 编辑用户信息
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateUser")
	@ResponseBody
	public QueryResultObject updateUser(@RequestBody UserInfoVo userInfo) throws Exception
	{
		QueryResultObject result = new QueryResultObject();
		try 
		{
			// 更新帐户信息
			this.userBiz.updateUserInfo(userInfo);
			
			return result;
		} 
		catch (Exception e) 
		{
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			
			return result;
		}
	} 
	
	/**
	 * 删除指定用户
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteUser/{userId}")
	@ResponseBody
	public QueryResultObject deleteUser(@PathVariable("userId") String userId) throws Exception
	{
		String userIdStr = ConvertUtils.parseStr(userId);
		
		QueryResultObject result = new QueryResultObject();
		if (this.userBiz.deleteByPrimaryKey(userIdStr) <= 0)
		{
			result.setSuccess(false);
			result.setErrorInfo("删除用户信息失败，请确认！");
		}
		
		
		return result;
	}
	
	@RequestMapping(value="/getUserMenuList")
	@ResponseBody
	public QueryResultObject getUserMenuList(@RequestBody UserInfoVo queryUserInfo) throws Exception
	{
		QueryResultObject result = new QueryResultObject();
		
		List<SysMenuItem> lstMenu = new ArrayList<SysMenuItem>();
		SysMenuItem menu = new SysMenuItem();
		// 工程管理菜单组
		menu.setPath("/");
		menu.setIconCls("project");
		menu.setName("工程管理");
		menu.setMenuFile("Home.vue");
		// 添加到列表
		lstMenu.add(menu);
		
		// 子级菜单
		SysMenuItem childMenu = new SysMenuItem();
		childMenu.setPath("/ProjectList");
		childMenu.setMenuFile("ProjectManage/ProjectList.vue");
		childMenu.setName("工程列表管理");
//		childMenu.setComponent("ProjectList");
		menu.getChildren().add(childMenu);
		
		menu.setLeaf(menu.getChildren().size() <= 0);
		
		// 计划管理菜单组
		menu = new SysMenuItem();
		menu.setPath("/");
		menu.setIconCls("plan");
		menu.setName("计划管理");
		menu.setMenuFile("Home.vue");
		// 添加到列表
		lstMenu.add(menu);
		
		// 子级菜单
		childMenu = new SysMenuItem();
		childMenu.setPath("/PlanList");
		childMenu.setMenuFile("PlanManage/PlanList.vue");
		childMenu.setName("计划列表管理");
		menu.getChildren().add(childMenu);
		
		menu.setLeaf(menu.getChildren().size() <= 0);
		
		// 系统管理菜单组
		menu = new SysMenuItem();
		menu.setPath("/");
		menu.setIconCls("systemmgr");
		menu.setMenuFile("Home.vue");
		menu.setName("系统管理");
		// 添加到列表
		lstMenu.add(menu);
		
		// 子级菜单
		childMenu = new SysMenuItem();
		childMenu.setPath("/GroupManage");
		childMenu.setMenuFile("UserManage/GroupManage.vue");
		childMenu.setName("组织管理");
		menu.getChildren().add(childMenu);
		
		childMenu = new SysMenuItem();
		childMenu.setPath("/AccountManage");
		childMenu.setMenuFile("UserManage/AccountManage.vue");
		childMenu.setName("帐户管理");
		menu.getChildren().add(childMenu);
		
		childMenu = new SysMenuItem();
		childMenu.setPath("/RoleManage");
		childMenu.setMenuFile("UserManage/RoleManage.vue");
		childMenu.setName("角色管理");
		menu.getChildren().add(childMenu);
		
		childMenu = new SysMenuItem();
		childMenu.setPath("/PermissionManage");
		childMenu.setMenuFile("UserManage/PermissionManage.vue");
		childMenu.setName("权限管理");
		menu.getChildren().add(childMenu);
		
		menu.setLeaf(menu.getChildren().size() <= 0);
		
		// 添加到返回结果对象中
		result.setItemList(lstMenu);
		
		return result;
	}
}
