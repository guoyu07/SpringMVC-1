package com.yngk.usermanage.biz;

import java.util.List;

import com.yngk.usermanage.model.RelationInfo;
import com.yngk.utils.biz.BaseBiz;

/** 
 * @ClassName: RelationInfoBiz
 */

public interface RelationInfoBiz extends BaseBiz<RelationInfo>
{
	/**
	 * 根据mainId和type获取subId列表
	 * @Title: getSubIdList
	 * @Description: TODO
	 * @return: List<String>
	 */
	List<String> getSubIdList(String mainId,String type);
	/**
	 * 根据mainId和type获取subId列表
	 * @Title: getSubIdList
	 * @Description: TODO
	 * @return: List<String>
	 */
	List<String> getMainIdList(String subId,String type);
	
	/***
	 * 更新mainid的映射关系
	 * @param mainId
	 * @param resIdList
	 * @return
	 * @throws Exception
	 */
	boolean buildRelation(String mainId, List<String> resIdList, String type) throws Exception;
	
	/**
	 * 通过主id与关系类型删除关系
	 * @param mainId
	 * @param type
	 * @return
	 */
	boolean deleteByMainId(String mainId, String type);
	
	/**
	 * 通过副id与关系类型删除关系
	 * @param mainId
	 * @param type
	 * @return
	 */
	boolean deleteBySubId(String mainId, String type);
	
	 /**
	 * @Description: 通过主副id及类型来删除该条关系
	 * @param mainId
	 * @param subId
	 * @param type
	 * @return 
	 * @Return: boolean true 表示删除成功
	 */
	boolean deleteByMainAndSubId(String mainId,String subId,String type);
	
	 /**
	 * @Description: 通过主id及副id的集合及类型来删除该条关系
	 * @param mainId
	 * @param subIdList 副id集合
	 * @param type
	 * @return 
	 * @Return: boolean true 表示删除成功
	 */
	boolean deleteByMainAndSubIdList(String mainId,List<String> subIdList,String type);
	
	/**
	 * 通过关系id删除关系
	 * @param id
	 * @return
	 */
	boolean deleteByRelationId(String id);
	
	/**
	 * 根据subId和type获取mainId列表
	 * @Title: getMainId
	 * @Description: TODO
	 * @return: String
	 */
	public String getMainId(String subId, String type);
	
	public boolean addRelation(String mainId, List<String> subIdList,
			String type) throws Exception;
}
