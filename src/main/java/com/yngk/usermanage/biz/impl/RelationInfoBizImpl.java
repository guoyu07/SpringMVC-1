package com.yngk.usermanage.biz.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yngk.usermanage.biz.RelationInfoBiz;
import com.yngk.usermanage.dao.RelationInfoDao;
import com.yngk.usermanage.model.RelationInfo;
import com.yngk.utils.biz.BaseBizImpl;
import com.yngk.utils.dao.BaseDao;

/**
 * @ClassName: RelationInfoBizImpl
 */
@Service
public class RelationInfoBizImpl extends BaseBizImpl<RelationInfo> implements RelationInfoBiz, Serializable
{

	private static final long serialVersionUID = -2779269239443610269L;
	@Autowired
	private RelationInfoDao relationInfoDao;

	@Override
	public List<String> getSubIdList(String mainId, String type)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("mainId", mainId);
		map.put("type", type);
		return relationInfoDao.selectSubIdList(map);
	}

	/**
	 * @return the relationInfoDao
	 */
	public RelationInfoDao getRelationInfoDao()
	{
		return relationInfoDao;
	}

	/**
	 * @param relationInfoDao
	 *            the relationInfoDao to set
	 */
	public void setRelationInfoDao(RelationInfoDao relationInfoDao)
	{
		this.relationInfoDao = relationInfoDao;
	}
	
	
	@Override
	public boolean addRelation(String mainId, List<String> subIdList,
			String type) throws Exception
	{
		boolean flag = true;
		int order = 0;
		for (String name : subIdList)
		{
			RelationInfo relationInfo = new RelationInfo();
			relationInfo.setId(UUID.randomUUID().toString());
			relationInfo.setMainId(mainId);
			relationInfo.setType(type);
			relationInfo.setSubId(name);
			relationInfo.setShowOrder(order++);
			int i = relationInfoDao.insert(relationInfo);
			if (i <= 0)
			{
				flag = false;
			}
		}
//		CommonUtil.clearCache();
		return flag;
	}
	
	@Override
	public boolean buildRelation(String mainId, List<String> subIdList,
			String type) throws Exception
	{
		boolean flag = true;
		Map<String, String> map = new HashMap<String, String>();
		map.put("mainId", mainId);
		map.put("type", type);
		List<String> list = relationInfoDao.selectSubIdList(map);
		List<String> addList = new ArrayList<String>();
		List<String> deleteList = new ArrayList<String>();

		for (String name : subIdList)
		{
			if (list.contains(name))
			{
				continue;
			}
			else
			{
				addList.add(name);
			}
		}
		for (String name : list)
		{
			if (subIdList.contains(name))
			{
				continue;
			}
			else
			{
				deleteList.add(name);
			}
		}
		for (String name : addList)
		{
			RelationInfo relationInfo = new RelationInfo();
			relationInfo.setId(UUID.randomUUID().toString());
			relationInfo.setMainId(mainId);
			relationInfo.setType(type);
			relationInfo.setSubId(name);
			relationInfo.setShowOrder(0);
			int i = relationInfoDao.insert(relationInfo);
			if (i <= 0)
			{
				flag = false;
				return false;
			}
		}
		for (String name : deleteList)
		{
			map.put("subId", name);
			int i = relationInfoDao.deleteByDetail(map);
			if (i < 0)
			{
				flag = false;
				return false;
			}
		}
//		if (addList.size() > 0 || deleteList.size() > 0)
//		{
//		    CommonUtil.clearCache();
//		}
		return flag;
	}

	@Override
	public boolean deleteByMainId(String mainId, String type)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("mainId", mainId);
		map.put("type", type);
		int i = relationInfoDao.deleteByDetail(map);
		if (i <= 0)
		{
			return false;
		}
//        CommonUtil.clearCache();
		return true;
	}

	@Override
	public boolean deleteBySubId(String subId, String type)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("subId", subId);
		map.put("type", type);
		int i = relationInfoDao.deleteByDetail(map);
		if (i <= 0)
		{
			return false;
		}
//        CommonUtil.clearCache();
		return true;
	}

	@Override
	public boolean deleteByRelationId(String id)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		int i = relationInfoDao.deleteByDetail(map);
		if (i <= 0)
		{
			return false;
		}
//        CommonUtil.clearCache();
		return true;
	}

	@Override
	public boolean deleteByMainAndSubId(String mainId, String subId, String type)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("mainId", mainId);
		map.put("subId", subId);
		map.put("type", type);
		int i = relationInfoDao.deleteByDetail(map);
		if (i <= 0)
		{
			return false;
		}
//        CommonUtil.clearCache();
		return true;
	}

	@Override
	public boolean deleteByMainAndSubIdList(String mainId,
			List<String> subIdList, String type)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mainId", mainId);
		map.put("subIdList", subIdList);
		map.put("type", type);
		int i = relationInfoDao.deleteCollectionAble(map);
		if (i <= 0)
		{
			return false;
		}
//        CommonUtil.clearCache();
		return true;
	}

	@Override
	public String getMainId(String subId, String type)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("subId", subId);
		map.put("type", type);
		List<String> list = relationInfoDao.selectMainIdList(map);
		if (list != null && list.size() > 0)
		{
			return list.get(0);
		}
		return "";
	}

	@Override
	public BaseDao<RelationInfo> getDao()
	{
		return relationInfoDao;
	}

	@Override
	public List<String> getMainIdList(String subId, String type)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("subId", subId);
		map.put("type", type);
		return relationInfoDao.selectMainIdList(map);
	}
}
