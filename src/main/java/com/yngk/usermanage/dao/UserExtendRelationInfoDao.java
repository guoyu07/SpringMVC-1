package com.yngk.usermanage.dao;

import java.util.List;

import com.yngk.usermanage.model.UserExtendRelationInfo;
import com.yngk.utils.dao.BaseDao;

/**
 * @ClassName: UserExtendRelationInfoMapper
 */
public interface UserExtendRelationInfoDao extends BaseDao<UserExtendRelationInfo>
{

	/**
	 * 根据主Id查询扩展属性值
	 * @Title: getListByMainId
	 * @Description: TODO
	 * @return: List<UserExtendRelationInfo>
	 */
	List<UserExtendRelationInfo> selectListByMainId(String mainId);

	/**
	 * 根据用户Id删除扩展属性值
	 * @Title: deleteByMianId
	 * @Description: TODO
	 * @return: int
	 */
	int deleteByMianId(String mainId);
	
	/**
	 * 根据拓展属性Id删除扩展属性值
	 * @Title: deleteByExproId
	 * @Description: TODO
	 * @return: int
	 */
	int deleteByExproId(String exproId);

}