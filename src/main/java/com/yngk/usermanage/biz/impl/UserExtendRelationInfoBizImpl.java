package com.yngk.usermanage.biz.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yngk.usermanage.biz.UserExtendRelationInfoBiz;
import com.yngk.usermanage.dao.UserExtendRelationInfoDao;
import com.yngk.usermanage.model.UserExtendRelationInfo;
import com.yngk.utils.biz.BaseBizImpl;
import com.yngk.utils.dao.BaseDao;

/**
 * @ClassName: UserExtendRelationInfoBizImpl
 */
@Service
public class UserExtendRelationInfoBizImpl extends BaseBizImpl<UserExtendRelationInfo> implements UserExtendRelationInfoBiz,Serializable
{
	private static final long serialVersionUID = 4334389534924389261L;
	@Autowired
	private UserExtendRelationInfoDao userExtendRelationInfoDao;

	@Override
	public List<UserExtendRelationInfo> getListByMainId(String mainId)
	{
		return userExtendRelationInfoDao.selectListByMainId(mainId);
	}

	@Override
	public boolean addUserExtendRelation(UserExtendRelationInfo userExtendRelationInfo) throws Exception
	{
		boolean flag = false;
		int i = userExtendRelationInfoDao.insertSelective(userExtendRelationInfo);
		if (i >= 0)
		{
			flag = true;
		}
		return flag;
	}
	@Override
	public boolean deleteByMianId(String mainId)
	{
		boolean flag = false;
		int i = userExtendRelationInfoDao.deleteByMianId(mainId);
		if (i >= 0)
		{
			flag = true;
		}
		return flag;
	}

	/**
	 * @return the userExtendRelationInfoDao
	 */
	public UserExtendRelationInfoDao getUserExtendRelationInfoDao()
	{
		return userExtendRelationInfoDao;
	}

	/**
	 * @param userExtendRelationInfoDao the userExtendRelationInfoDao to set
	 */
	public void setUserExtendRelationInfoDao(UserExtendRelationInfoDao userExtendRelationInfoDao)
	{
		this.userExtendRelationInfoDao = userExtendRelationInfoDao;
	}

	
	@Override
	public BaseDao<UserExtendRelationInfo> getDao()
	{
		return this.userExtendRelationInfoDao;
	}

	@Override
	public boolean deleteByExproId(String exproId)
	{
		boolean flag = false;
		int i = userExtendRelationInfoDao.deleteByExproId(exproId);
		if (i >= 0)
		{
			flag = true;
		}
		return flag;
	}

}
