package com.yngk.usermanage.biz;

import java.util.List;

import com.yngk.usermanage.model.UserExtendRelationInfo;
import com.yngk.utils.biz.BaseBiz;

/** 
 * @ClassName: UserExtendRelationInfoBiz
 */

public interface UserExtendRelationInfoBiz extends BaseBiz<UserExtendRelationInfo>
{
	/**
	 * 根据主Id查询扩展属性值
	 * @Title: getListByMainId
	 * @Description: TODO
	 * @return: List<UserExtendRelationInfo>
	 */
	List<UserExtendRelationInfo> getListByMainId(String id);
	/**
	 * 添加扩展属性关联关系
	 * @Title: addUserExtendRelation
	 * @Description: TODO
	 * @return: boolean
	 * @throws Exception 
	 */
	boolean addUserExtendRelation( UserExtendRelationInfo userExtendRelationInfo) throws Exception;
   /**
    * 根据用户id删除扩展属性值
    * @Title: deleteByMianId
    * @Description: TODO
    * @return: boolean
    */
	boolean deleteByMianId(String mainId);
	
	boolean deleteByExproId(String exproId);
	
}
