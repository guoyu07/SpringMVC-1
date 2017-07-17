package com.abc.usermanage.control;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.usermanage.model.User;

@Controller
@RequestMapping("/UserControl")
public class UserControl 
{
	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public List<User> test() throws Exception 
	{
//		Map<String, String> mapResult = new HashMap<String, String>();
//		mapResult.put("item", "���Գɹ�");
//		return "���Գɹ��������ˣ�";
		
		List<User> lstUser = new ArrayList<User>();
		User user = new User();
		user.setUserId(UUID.randomUUID().toString());
		user.setUserName("admin");
		user.setPassword("123456");
		user.setUserType("����Ա");
		lstUser.add(user);
		
		user = new User();
		user.setUserId(UUID.randomUUID().toString());
		user.setUserName("user");
		user.setPassword("123456");
		user.setUserType("��ͨ�û�");
		lstUser.add(user);
		
		return lstUser;
	}	
}
