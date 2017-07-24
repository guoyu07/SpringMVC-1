package com.abc.usermanage.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.usermanage.biz.UserBiz;
import com.abc.usermanage.model.User;
import com.abc.usermanage.util.QueryResultObject;

@Controller
@RequestMapping("/UserControl")
public class UserControl 
{
	@Autowired
	private UserBiz userBiz;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public QueryResultObject test(@RequestParam int pageIndex, @RequestParam int pageSize) throws Exception 
	{
//		Map<String, String> mapResult = new HashMap<String, String>();
//		mapResult.put("item", "测试成功");
//		return "测试成功，我来了！";
		
//		List<User> lstUser = new ArrayList<User>();
//		User user = new User();
//		user.setUserId(UUID.randomUUID().toString());
//		user.setUserName("admin");
//		user.setPassword("123456");
//		user.setUserType("管理员");
//		lstUser.add(user);
//		
//		user = new User();
//		user.setUserId(UUID.randomUUID().toString());
//		user.setUserName("user");
//		user.setPassword("123456");
//		user.setUserType("普通用户");
//		lstUser.add(user);
		
		User queryUser = new User();
		
		int startIndex = pageSize * (pageIndex - 1) + 1;
		int endIndex = startIndex + pageSize - 1;
		
		QueryResultObject queryResultObj = new QueryResultObject();
		queryResultObj.setItemList(this.userBiz.queryUserList(queryUser, startIndex, endIndex));
		queryResultObj.setTotalItemCount(this.userBiz.getUserCount(queryUser));
		
		return queryResultObj;
	}	
}
