package com.yngk.usermanage.dao;

import java.util.List;
import java.util.Map;

import com.yngk.usermanage.model.GroupInfo;
import com.yngk.utils.dao.BaseDao;

/**
 * @ClassName: GroupInfoMapper
 * @Description: TODO
 * @author: xuxiepeng
 * @date: 2014-10-16 下午2:22:39
 */
public interface GroupInfoDao extends BaseDao<GroupInfo>
{
	/**
	 * 查找部门列表
	 * @Title: selectList
	 * @Description: TODO
	 * @return: List<GroupInfo>
	 */
	List<GroupInfo> selectList();

	/**
	 * 根据父ID查找部门列表
	 * @Title: selectListByParentId
	 * @Description: TODO
	 * @return: List<GroupInfo>
	 */
	List<GroupInfo> selectListByParentId(String id);

	/**
	 * 根据状态获取列表
	 * @Title: selectList
	 * @Description: TODO
	 * @return: List<GroupInfo>
	 */
	List<GroupInfo> selectListByState(String state);

	/**
	 * 根据长编码获取列表
	 * @Title: selectListByCode
	 * @Description: TODO
	 * @return: List<GroupInfo>
	 */
	List<GroupInfo> selectListByCode(Map<String,Object> map);
	/**
     * 根据状态获取列表
     * @Title: selectList
     * @Description: TODO
     * @return: List<GroupInfo>
     */
    List<GroupInfo> selectListByType(String type);
    
    List<String> getGroupTypeList();
}