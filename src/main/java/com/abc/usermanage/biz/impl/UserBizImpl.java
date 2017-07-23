package com.abc.usermanage.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.usermanage.biz.UserBiz;
import com.abc.usermanage.datamapper.UserDataMapper;
import com.abc.usermanage.model.User;

@Service
public class UserBizImpl implements UserBiz
{
	@Autowired
	private UserDataMapper userDataMapper;

	@Override
	public int getUserCount(User queryUser) throws Exception 
	{
		return this.userDataMapper.getUserCount(queryUser);
	}

	@Override
	public List<User> queryUserList(User queryUser, int startIndex, int endIndex) throws Exception
	{
		return this.userDataMapper.queryUserList(queryUser, startIndex, endIndex);
	}
	
	
}
