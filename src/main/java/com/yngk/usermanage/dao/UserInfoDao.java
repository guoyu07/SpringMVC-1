package com.yngk.usermanage.dao;

import java.util.List;
import java.util.Map;

import com.yngk.usermanage.model.UserInfo;
import com.yngk.utils.dao.BaseDao;

/**
 * @ClassName: UserInfoMapper
 * @Description: TODO
 * @author: xuxiepeng
 * @date: 2014-10-16 下午2:21:50
 */
public interface UserInfoDao extends BaseDao<UserInfo>
{
	/**
	 * 根据登陆名查找用户对象
	 * @Title: selectByLoginName
	 * @Description: TODO
	 * @return: UserInfo
	 */
	UserInfo selectByLoginName(String loginName);

	/**
	 * 根据部门ID查询用户列表
	 * @Title: getListByGroup
	 * @Description: TODO
	 * @return: List<UserInfo>
	 */
	List<UserInfo> selectListByGroupId(String groupId);
	/**
	 * 根据部门查询部门用户无关联人数
	 * @Title: selectListByGroupIdNoRelationNum
	 * @Description: TODO
	 * @return: List<UserInfo>
	 */
	List<UserInfo> selectListByGroupIdNoRelationNum(String groupId);

	List<UserInfo> selectByUserName(Map<String, String> map);
	
	List<UserInfo> selectUserByQueryCriteria(UserInfo userInfo);
	
	long selectUserCountByQueryCriteria(UserInfo userInfo);
	
	List<UserInfo> selectByUserRole(Map<String, String> map);
	
	List<UserInfo> selectRelationUserList(Map<String, String> map);

	/**
	 * 通过加密用户名获取用户
	 * @param eName
	 * @return
	 */
    List<UserInfo> getUsersByEName(Map<String, String> map);
}