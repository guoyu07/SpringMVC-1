package com.yngk.usermanage.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.usermanage.biz.AccountBiz;
import com.abc.usermanage.datamapper.AccountDataMapper;
import com.abc.usermanage.model.AccountInfo;

@Service
public class AccountBizImpl implements AccountBiz
{
	@Autowired
	private AccountDataMapper accountDataMapper;

	@Override
	public int getAccountCount(AccountInfo queryUser) throws Exception 
	{
		return this.accountDataMapper.getAccountCount(queryUser);
	}

	@Override
	public List<AccountInfo> queryAccountList(AccountInfo queryUser, int startIndex, int endIndex) throws Exception
	{
//		PageHelper pageHelper = new PageHelper();
//		Page<Student> page = PageHelper.startPage(pageNum, pageSize);
		
		return this.accountDataMapper.queryAccountList(queryUser, startIndex, endIndex);
	}
	
	/**
	 * hbhua
	 */
	public void testGit()
	{
		return;
	}
	
}
