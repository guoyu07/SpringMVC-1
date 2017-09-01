package com.yngk.usermanage.biz;

import java.util.List;

import com.abc.usermanage.model.AccountInfo;

public interface AccountBiz
{
	/**
	 * 查询符合条件用户记录数
	 * @param queryUser 查询用户条件对象
	 * @return 符合条件用户记录总数
	 * @throws Exception 异常信息
	 */
	int getAccountCount(AccountInfo queryUser) throws Exception;
	
	/**
	 * 查询符合条件用户列表
	 * @param queryUser 查询用户条件对象
	 * @param startIndex 起始行索引
	 * @param endIndex 结束行索引
	 * @return 符合条件用户列表
	 * @throws Exception 异常信息
	 */
	List<AccountInfo> queryAccountList(AccountInfo queryUser,int startIndex, int endIndex) throws Exception;
}
