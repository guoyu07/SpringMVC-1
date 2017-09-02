package com.yngk.usermanage.biz;

import java.util.List;

import com.yngk.usermanage.model.UserInfo;
import com.yngk.utils.biz.BaseBiz;

/**
 * @ClassName: UserBiz
 */

public interface UserBiz extends BaseBiz<UserInfo>
{
    /**
     * 根据登录名获取用户对象
     * @Title: getByLoginName
     * @Description: TODO
     * @return: UserInfo
     */
    UserInfo getByLoginName(String loginName);

    /**
     * 根据部门查询用户
     * @Title: getListByGroup
     * @Description: TODO
     * @return: List<UserInfo>
     */
    List<UserInfo> getListByGroup(String groupId);

    /**
     * 新增用户
     * @Title: addUserInfo
     * @Description: TODO
     * @return: boolean
     * @throws Exception 
     */
    boolean addUserInfo(UserInfo userInfo) throws Exception;

    /**
     * 删除用户
     * @Title: deleteUserInfo
     * @Description: TODO
     * @return: boolean
     * @throws Exception 
     */
    boolean deleteUserInfo(String id) throws Exception;
    /**
     * 根据ID查询用户
     * @Title: getUserInfoById
     * @Description: TODO
     * @return: UserInfo
     * @throws Exception 
     */
    UserInfo getUserInfoById(String id) throws Exception;
    /**
     * 更新用户
     * @Title: updateUserInfo
     * @Description: TODO
     * @return: boolean
     * @throws Exception 
     */
    boolean updateUserInfo(UserInfo userInfo) throws Exception;
    
    /**
     * 获取注册表中默认密码（没有则默认设置为booway2015）
     * @return
     * @throws Exception
     */
    public String getDefaultSecurity() throws Exception;

    List<UserInfo> getByUserName(String userName);
    
    List<UserInfo> selectUserByQueryCriteria(UserInfo userInfo);
    
    long selectUserCountByQueryCriteria(UserInfo userInfo);
    
    List<UserInfo> getByUserRole(String roleId,String type);
    /**
     * 获取用户的管理人
     * @param userId
     * @return
     */
    List<UserInfo> getManagerListByUserId(String userId);
    
    List<UserInfo> selectRelationUserList(String userId);
    /**
     * 根据部门ID获取用户列表
     * @Title: getListByGroupIdNoRelationNum
     * @Description: TODO
     * @return: List<UserInfo>
     */
    public List<UserInfo> getListByGroupIdNoRelationNum(String groupId);

//    boolean updateHisPwd(String userId, String pwd) throws Exception;

//    UserPwd getUserHisPwdById(String userId);

	public String getIsNeedInputPwd() throws Exception;
	
	/**
	 * 删除用户历史密码
	 * @param userId
	 * @return
	 */
	boolean deleteByUserId(String userId);

	boolean validatePwd(String pwd, UserInfo userInfo) throws Exception;
	
	/**
	 * 通过加密用户名获取用户
	 * @param eName
	 * @return
	 */
	public UserInfo getUsersByEName(String eName);
	
	public UserInfo setUserPwd(UserInfo userInfo) throws Exception;

//	/**
//     * 获取最近两次历史密码
//     * @param userId
//     * @return
//     */
//    List<UserPwd> getRencent2HisPwdById(String userId);

//    /**
//     * 将初始密码插入到历史密码库
//     * @param userId
//     * @param pwd
//     * @return
//     * @throws Exception
//     */
//    boolean insertInitHisPwd(String userId, String pwd) throws Exception;
}