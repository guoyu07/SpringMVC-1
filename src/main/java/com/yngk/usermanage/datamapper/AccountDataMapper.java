package com.yngk.usermanage.datamapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.abc.usermanage.model.AccountInfo;

public interface AccountDataMapper 
{	
	/**
	 * 查询符合条件用户记录数
	 * @param AccountInfo 查询用户条件对象
	 * @return 符合条件用户记录总数
	 * @throws Exception 异常信息
	 */
	int getAccountCount(@Param(value="queryAccount") AccountInfo AccountInfo) throws Exception;
	
	/**
	 * 查询符合条件用户列表
	 * @param queryAccount 查询用户条件对象
	 * @param startIndex 起始行索引
	 * @param endIndex 结束行索引
	 * @return 符合条件用户列表
	 * @throws Exception 异常信息
	 */
	List<AccountInfo> queryAccountList(@Param(value="queryAccount") AccountInfo queryAccount,@Param(value="startIndex") int startIndex, @Param(value="endIndex") int endIndex) throws Exception;
}
