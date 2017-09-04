package com.yngk.utils.system;

import java.io.FileInputStream;
import java.util.Properties;

import com.booway.techcomp.commonfunction.StringUtils;

/**
 * 系统配置类
 * @author Jack
 *
 */
public class SystemConfigUtil 
{
	private static final String SystemConfigFileName = "SystemConfig.properties";
	
	/**
	 * 获取对应名称的系统配置
	 * @param propertyName
	 * @return
	 * @throws Exception
	 */
	public static String getSystemConfig(String propertyName) throws Exception
	{		
		Properties sysConfig = new Properties();
		sysConfig.load(new FileInputStream(SystemConfigFileName));
		
		if (!sysConfig.containsKey(propertyName))
		{
			throw new Exception("系统配置中不存在该配置项！");			
		}
		
		return StringUtils.trim(sysConfig.getProperty(propertyName));		
	}
}
