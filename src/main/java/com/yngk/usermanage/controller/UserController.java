package com.yngk.usermanage.controller;

import java.util.List;
import java.util.Map;

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
import com.mysql.jdbc.StringUtils;
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
}
