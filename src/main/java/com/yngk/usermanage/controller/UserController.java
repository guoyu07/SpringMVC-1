package com.yngk.usermanage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yngk.usermanage.biz.UserBiz;
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
	public QueryResultObject queryUserList(@RequestBody Map<String,Object> MapParam) throws Exception 
	{
		int pageSize = Integer.parseInt(MapParam.get("pageSize").toString());
		int pageIndex = Integer.parseInt(MapParam.get("pageIndex").toString());
		
		UserInfo queryInfo = new UserInfo();
		QueryResultObject queryResultObj = new QueryResultObject();
		// 分页查询
		 PageHelper.startPage(pageIndex, pageSize);
		List<UserInfo> lstUserInfo  = this.userBiz.selectUserByQueryCriteria(queryInfo);
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
}
