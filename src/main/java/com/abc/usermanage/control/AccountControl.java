package com.abc.usermanage.control;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.usermanage.biz.AccountBiz;
import com.abc.usermanage.model.AccountInfo;
import com.abc.usermanage.util.QueryResultObject;

@Controller
@RequestMapping("/AccountControl")
public class AccountControl 
{
	@Autowired
	private AccountBiz accountBiz;
	
	@RequestMapping(value="/test")
	@ResponseBody
	public QueryResultObject test(@RequestBody Map MapParam) throws Exception 
	{
//		@RequestParam int pageIndex, @RequestParam int pageSize
//		Map<String, String> mapResult = new HashMap<String, String>();
//		mapResult.put("item", "���Գɹ�");
//		return "���Գɹ��������ˣ�";
		
//		List<User> lstUser = new ArrayList<User>();
//		User user = new User();
//		user.setUserId(UUID.randomUUID().toString());
//		user.setUserName("admin");
//		user.setPassword("123456");
//		user.setUserType("����Ա");
//		lstUser.add(user);
//		
//		user = new User();
//		user.setUserId(UUID.randomUUID().toString());
//		user.setUserName("user");
//		user.setPassword("123456");
//		user.setUserType("��ͨ�û�");
//		lstUser.add(user);
		
		AccountInfo queryUser = new AccountInfo();
//		queryUser.setUserName("user");
		
		// 测试
		int pageSize = Integer.parseInt(MapParam.get("pageSize").toString());
		int pageIndex = Integer.parseInt(MapParam.get("pageIndex").toString());
		int startIndex = pageSize * (pageIndex - 1) + 1;
		int endIndex = startIndex + pageSize - 1;
		
		QueryResultObject queryResultObj = new QueryResultObject();
		queryResultObj.setItemList(this.accountBiz.queryAccountList(queryUser, startIndex, endIndex));
		queryResultObj.setTotalItemCount(this.accountBiz.getAccountCount(queryUser));
		
		return queryResultObj;
	}	
}
