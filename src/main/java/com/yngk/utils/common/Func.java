package com.yngk.utils.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Func 
{
	/**
	 * 是否手机号码
	 * @param mobileNum
	 * @return
	 */
	public static boolean isMobileNum(String mobileNum)
	{
		// ^((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))\d{8}$
		String str = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(mobileNum);
		
		return m.matches();
	}
	
	/**
	 * 是否邮箱号码
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email)
	{
		String str = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		
		return m.matches();
	}
}
