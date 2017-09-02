package com.yngk.usermanage.biz;

import java.util.List;

import com.yngk.usermanage.model.RoleInfo;
import com.yngk.utils.biz.BaseBiz;

/** 
 * @ClassName: RoleBiz
 */

public interface RoleBiz extends BaseBiz<RoleInfo>
{
	/**
	 * 根据用户获取角色列表
	 * @Title: getListByUserId
	 * @Description: TODO
	 * @return: List<RoleInfo>
	 */
	List<RoleInfo> getListByUserId(String userid);
	/**
	 * 根据状态获取角色列表
	 * @Title: getListByState
	 * @Description: TODO
	 * @return: List<RoleInfo>
	 */
	List<RoleInfo> getListByState(String state);
	
	/**
	 * 通过角色id获取角色
	 * @param userid
	 * @return
	 * @throws Exception 
	 */
	RoleInfo getRoleByRoleId(String roleId) throws Exception;
	
	/**
	 * 根据类型获取角色/岗位列表
	 * @param type 对象类型
	 * @param tag 是否过滤被禁用的角色/岗位
	 * @return
	 */
	List<RoleInfo> selectListByType(String type, boolean tag);
	
	/**
	 * 按角色/岗位ID删除角色/岗位
	 * @param roleId
	 * @return 
	 * @throws Exception 
	 */
	public boolean deleteByID(String roleId) throws Exception;
	
	/**
	 * 更新岗位/角色
	 * @param info
	 * @return 
	 * @throws Exception 
	 */
	public boolean updateRole(RoleInfo info) throws Exception;
	
	/**
	 * 添加角色或岗位
	 * @param info
	 */
	public void addRole(RoleInfo info) throws Exception;
	
    public List<RoleInfo> findRoleByQueryCriteria(RoleInfo roleInfo);

    public long findRoleCountByQueryCriteria(RoleInfo roleInfo);
    
    boolean checkRoleMutualExclusion(List<RoleInfo> temp) throws Exception;
}
