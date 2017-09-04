package com.yngk.usermanage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yngk.usermanage.biz.GroupBiz;
import com.yngk.utils.restsupport.QueryResultObject;

/**
 * 部门管理controller
 * @author hubinhua
 * @since 2017-09-24
 */
@Controller
@RequestMapping("/GroupCtrl")
public class GroupController
{
	@Autowired
	private GroupBiz groupBiz;
	
	@RequestMapping(value="/queryGroupList")
	@ResponseBody
	public QueryResultObject queryGroupList(@RequestBody Map<String,Object> MapParam) throws Exception 
	{
		return new QueryResultObject();
	}
}
