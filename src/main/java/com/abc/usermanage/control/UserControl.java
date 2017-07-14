package com.abc.usermanage.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/UserControl")
public class UserControl 
{
	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public String test() throws Exception 
	{
//		Map<String, String> mapResult = new HashMap<String, String>();
//		mapResult.put("item", "测试成功");
		
		return "测试成功，我来了！";
	}	
}
