package com.yngk.usermanage.biz;

import java.util.List;

import com.yngk.usermanage.model.GroupInfo;
import com.yngk.utils.biz.BaseBiz;

/** 
 * @ClassName: GroupBiz
 */

public interface GroupBiz extends BaseBiz<GroupInfo>
{
	/**
	 * 获取部门列表
	 * @Title: getList
	 * @Description: TODO
	 * @return: List<GroupInfo>
	 */
	List<GroupInfo> getList();
	/**
	 * 根据父id获取子节点
	 * @Title: getListByParentId
	 * @Description: TODO
	 * @return: List<GroupInfo>
	 */
	List<GroupInfo> getListByParentId(String id);
	/**
	 * 增加部门
	 * @Title: addGroup
	 * @Description: TODO
	 * @return: boolean
	 * @throws Exception 
	 */
	boolean addGroup(GroupInfo groupInfo) throws Exception;
	/**
	 * 删除部门
	 * @Title: deleteGroup
	 * @Description: TODO
	 * @return: boolean
	 */
	boolean deleteGroup(String id)throws Exception;
	/**
	 *  编辑部门
	 * @Title: editGroup
	 * @Description: TODO
	 * @return: boolean
	 * @throws Exception 
	 */
	boolean editGroup(GroupInfo groupInfo) throws Exception;
	/**
	 * 根据状态获取部门列表
	 * @Title: getList
	 * @Description: TODO
	 * @return: List<GroupInfo>
	 */
	List<GroupInfo> getList(String state);
	/**
	 * 根据Id获取部门
	 * @Title: getById
	 * @Description: TODO
	 * @return: GroupInfo
	 * @throws Exception 
	 */
	GroupInfo getById(String id) throws Exception;
	/**
	 * 根据长编码获取子部门
	 * @Title: getListByCode
	 * @Description: TODO
	 * @return: List<GroupInfo>
	 */
	List<GroupInfo> getListByCode(String longCode);
	/**
	 * 根据部门类型获取部门列表
	 * @param groupType
	 * @return
	 */
	public List<GroupInfo> getGroupListByType(String groupType);
	
	List<String> getGroupTypeList();
}
