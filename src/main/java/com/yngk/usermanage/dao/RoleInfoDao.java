package com.yngk.usermanage.dao;

import java.util.List;

import com.yngk.usermanage.model.RoleInfo;
import com.yngk.utils.dao.BaseDao;

/**
 * @ClassName: RoleInfoMapper
 * @Description: TODO
 * @author: xuxiepeng
 * @date: 2014-10-16 下午2:22:05
 */
public interface RoleInfoDao extends BaseDao<RoleInfo>
{

	int updateByPrimaryKey(RoleInfo record);

	/**
	 * 根据用户id获取用户拥有的角色
	 * @Title: selectListByUserId
	 * @Description: TODO
	 * @return: List<RoleInfo>
	 */

	List<RoleInfo> selectListByUserId(String id);

	/**
	 * 根据状态获取列表
	 * @Title: selectListByState
	 * @Description: TODO
	 * @return: List<RoleInfo>
	 */
	List<RoleInfo> selectListByState(String state);

	/**
	 * 根据类型获取岗位/角色列表
	 * @param type
	 * @return
	 */
	List<RoleInfo> selectListByType(String type);

	/**
	 * 根据角色名称查找角色
	 * @param id
	 * @return
	 */
	RoleInfo selectRoleByName(String name);

	/**
	 * 根据岗位名称查找岗位
	 * @param id
	 * @return
	 */
	RoleInfo selectPostByName(String name);
	
	
	 /**
	 * @Description: 依据传入的对象查找 所有符合条件的角色集合(可仅传入roleInfo对象中的任意一个值)
	 * @param roleInfo
	 * @return 
	 * @Return: List<RoleInfo>
	 */
	List<RoleInfo> selectRoleByQueryCriteria(RoleInfo roleInfo);
	
	
	 /**
	 * @Description: 依据传入的对象查找该对象在角色列表中的个数(可仅传入roleInfo对象中的任意一个值)
	 * @param roleInfo
	 * @return 
	 * @Return: long
	 */
	long selectRoleCountByQueryCriteria(RoleInfo roleInfo);
}