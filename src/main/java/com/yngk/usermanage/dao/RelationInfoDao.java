package com.yngk.usermanage.dao;

import java.util.List;
import java.util.Map;

import com.yngk.usermanage.model.RelationInfo;
import com.yngk.utils.dao.BaseDao;

/**
 * @ClassName: RelationInfoMapper
 * @Description: TODO
 * @author: xuxiepeng
 * @date: 2014-10-16 下午2:22:12
 */
public interface RelationInfoDao extends BaseDao<RelationInfo>
{

	int updateByPrimaryKey(RelationInfo record);

	/**
	 * 根据主ID和类型获取SubId
	 * @Title: selectSubIdList
	 * @Description: TODO
	 * @return: List<String>
	 */
	List<String> selectSubIdList(Map<String, String> map);
	
	List<String> selectMainIdList(Map<String,String> map);

	/**
	 * 根据删除 mainId,subId,type 关联关系
	 * @Title: deleteByDetail
	 * @Description: TODO
	 * @return: int
	 */
	int deleteByDetail(Map<String, String> map);
	
	
	/**
	 * 根据删除 mainId,subId,type 关联关系 ( 可集合删除副id )
	 * @Title: deleteByDetail
	 * @Description: TODO
	 * @return: int
	 */
	int deleteCollectionAble(Map<String, Object> map);
}